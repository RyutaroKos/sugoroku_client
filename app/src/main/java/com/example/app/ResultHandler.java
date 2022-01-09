package com.example.app;

import com.data.Protocol;
import com.data.Request;
import com.data.buffer.GameBuffer;
import com.data.buffer.RequestBuffer;
import com.data.buffer.ResultBuffer;
import com.netcom.websocket.WebSocketClient;
import com.ui.component.UIKeyword;
import com.ui.component.FactoryConstructor;
import com.ui.component.MainFrame;
import com.ui.component.subcomponent.GamePanelPlayerCard;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ResultHandler implements Runnable {
    MainFrame mainFrame;
    JSONObject resultObject;

    ResultHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    private void connection() { //remove mainFrame.getTopPanel() != null after test
        if (resultObject.getBoolean(Protocol.Status.toString()) && mainFrame.getTopPanel() != null) {
            mainFrame.getTopPanel().onConnection();
        }
    }

    private void login() {
        if (resultObject.getBoolean(Protocol.Status.toString())) {
            SwingUtilities.invokeLater(() -> {
                mainFrame.setMatchingPanel();
                mainFrame.changePanel(mainFrame.getMatchingPanel());
            });
        } else {
            FactoryConstructor.getFactory(UIKeyword.Dialog).getDialog(mainFrame, UIKeyword.LoginDialog, null, null).setVisible(true);
        }
    }

    private void signup() {
        FactoryConstructor.getFactory(UIKeyword.Dialog)
                .getDialog(mainFrame, UIKeyword.SignupDialog, resultObject.getBoolean(Protocol.Status.toString()), null).setVisible(true);
    }

    private void updatePlayerList() {
        JSONArray jsonArray = resultObject.getJSONArray(Protocol.PlayerList.toString());
        mainFrame.getLobbyPanel().getPlayerListArea().setText("");
        for (int i = 0; i < jsonArray.length(); i++) {
            mainFrame.getLobbyPanel().getPlayerListArea().append("・" + jsonArray.getString(i) + "\n\n");
        }
    }

    private void randomMatch() {
        if (resultObject.getBoolean(Protocol.Status.toString()) && GameBuffer.getInstance().getLobbyID() == null) {
            GameBuffer.getInstance().setLobbyID(resultObject.getString(Protocol.LobbyID.toString()));
            SwingUtilities.invokeLater(() -> {
                mainFrame.setLobbyPanel(UIKeyword.RandomLobby.toString(), resultObject.getString(Protocol.LobbyID.toString()));
                mainFrame.changePanel(mainFrame.getLobbyPanel());
                updatePlayerList();
            });
        } else if (GameBuffer.getInstance().getLobbyID() != null) {
            SwingUtilities.invokeLater(this::updatePlayerList);
        }
    }

    private void privateMatch() {
        if (resultObject.getBoolean(Protocol.Status.toString()) && GameBuffer.getInstance().getLobbyID() == null) {
            GameBuffer.getInstance().setLobbyID(resultObject.getString(Protocol.LobbyID.toString()));
            SwingUtilities.invokeLater(() -> {
                mainFrame.setLobbyPanel(UIKeyword.PrivateLobby.toString(), resultObject.getString(Protocol.LobbyID.toString()));
                mainFrame.changePanel(mainFrame.getLobbyPanel());
                updatePlayerList();
            });
        } else if (GameBuffer.getInstance().getLobbyID() != null) {
            SwingUtilities.invokeLater(this::updatePlayerList);
        }
    }

    private void checkRecord() {
        String gameRecord = "あなたの対戦成績：" + resultObject.getInt(Protocol.Win.toString()) + "勝、" + resultObject.getInt(Protocol.Lose.toString()) + "敗です";
        FactoryConstructor.getFactory(UIKeyword.Dialog).getDialog(mainFrame, UIKeyword.GameRecordDialog, null, gameRecord).setVisible(true);
    }

    private void exitLobby() {
        SwingUtilities.invokeLater(this::updatePlayerList);
    }

    private void startGame() {
        if (resultObject.getBoolean(Protocol.Status.toString())) {
            WebSocketClient.getInstance().switchServer("ws://localhost:8080/app/example"); //必要に応じてエンドポイントを調整
            JSONObject joinGameRequest = new JSONObject();
            joinGameRequest.put(Protocol.Request.toString(), Request.JOIN_GAME);
            joinGameRequest.put(Protocol.Username.toString(), GameBuffer.getInstance().getUsername());
            RequestBuffer.getInstance().registerRequest(joinGameRequest);
            System.out.println("INFO: connect to application server.");
        }
    }

    private void receiveChat() {
        SwingUtilities.invokeLater(() -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            mainFrame.getLobbyPanel().getChatArea().append("・" + resultObject.getString(Protocol.Username.toString()) + " - " + dateTimeFormatter.format(now) + "\n　" + resultObject.getString(Protocol.Message.toString()) + '\n');
        });
    }

    private void setGamePlayers() {
        JSONArray jsonArray = resultObject.getJSONArray(Protocol.PlayerList.toString());
        for (int i = 0; i < jsonArray.length(); i++) {
            ((GamePanelPlayerCard) mainFrame.getGamePanel().getPlayerCards()[i]).setPlayerName(jsonArray.getString(i));
            if (jsonArray.getString(i).equals(GameBuffer.getInstance().getUsername())) {
                GameBuffer.getInstance().setMyTurn(i);
            }
        }
    }

    private void joinGame() {
        if (resultObject.getBoolean(Protocol.Status.toString())) {
            SwingUtilities.invokeLater(() -> {
                mainFrame.setGamePanel();
                mainFrame.changePanel(mainFrame.getGamePanel());
                setGamePlayers();
                GameBuffer.getInstance().setGameTurn();
                mainFrame.getGamePanel().startMyTurn();
            });
        }
    }

    private void pieceMoveForward() {
        for (int i = 0; i < resultObject.getInt(Protocol.Roll.toString()); i++) {
            try {
                mainFrame.getGamePanel().getGameMap().moveForward(GameBuffer.getInstance().getGameTurn() % GameBuffer.getInstance().getMyTurn() - 1);
                TimeUnit.MILLISECONDS.sleep(500); //piece movement animation, repaints every 0.5 second
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void pieceMoveBackward() {
        for (int i = 0; i < resultObject.getInt(Protocol.Roll.toString()); i++) {
            try {
                mainFrame.getGamePanel().getGameMap().moveBackward(GameBuffer.getInstance().getGameTurn() % GameBuffer.getInstance().getMyTurn() - 1);
                TimeUnit.MILLISECONDS.sleep(500); //piece movement animation, repaints every 0.5 second
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void pieceBackToStart() {
        mainFrame.getGamePanel().getGameMap().backToStart(GameBuffer.getInstance().getGameTurn() % GameBuffer.getInstance().getMyTurn() - 1);
    }

    private void rollDice() {
        if (GameBuffer.getInstance().getGameTurn() % GameBuffer.getInstance().getMyTurn() == GameBuffer.getInstance().getMyTurn()) {
            //TODO: show roll dice dialog
        }
        if (resultObject.getInt(Protocol.NextDiceNum.toString()) == 0) {
            SwingUtilities.invokeLater(() -> {
                pieceMoveForward();
                GameBuffer.getInstance().nextTurn();
                mainFrame.getGamePanel().startMyTurn(); //move to gird effect method?
            });
        } else {
            SwingUtilities.invokeLater(this::pieceMoveForward);
            //TODO: show select route dialog
        }
    }

    private void selectRoute() {

    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!ResultBuffer.getInstance().isEmpty()) {
                    resultObject = ResultBuffer.getInstance().retrieveResult();
                    switch (Request.valueOf(resultObject.getString(Protocol.Result.toString()))) {
                        case CONNECTION -> connection();
                        case LOGIN -> login();
                        case SIGNUP -> signup();
                        case RANDOM_MATCH -> randomMatch();
                        case PRIVATE_MATCH -> privateMatch();
                        case CHECK_RECORD -> checkRecord();
                        case EXIT_LOBBY -> exitLobby();
                        case START_GAME -> startGame();
                        case SEND_CHAT -> receiveChat();
                        case JOIN_GAME -> joinGame();
                        case ROLL_DICE -> rollDice();
                        case SELECT_ROUTE -> selectRoute();
                        default -> System.err.println("Error: illegal protocol detected.");
                    }
                } else {
                    TimeUnit.MICROSECONDS.sleep(100); //result読み取り処理が追いつかない場合、このタイムアウトを延長
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
