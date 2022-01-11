package com.example.app;

import com.data.Protocol;
import com.data.Request;
import com.data.buffer.GameBuffer;
import com.data.buffer.RequestBuffer;
import com.data.buffer.ResultBuffer;
import com.netcom.websocket.WebSocketClient;
import com.ui.component.UIKeyword;
import com.ui.component.MainFrame;
import com.ui.component.dialog.*;
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
            LoginDialog.getDialog(mainFrame).setVisible(true);
        }
    }

    private void signup() {
        SignupDialog.getDialog(mainFrame, resultObject.getBoolean(Protocol.Status.toString())).setVisible(true);
    }

    private void updatePlayerList() { //required by randomMatch() and privateMatch()
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
                mainFrame.setLobbyPanel(UIKeyword.RandomLobby, resultObject.getString(Protocol.LobbyID.toString()));
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
                mainFrame.setLobbyPanel(UIKeyword.PrivateLobby, resultObject.getString(Protocol.LobbyID.toString()));
                mainFrame.changePanel(mainFrame.getLobbyPanel());
                updatePlayerList();
            });
        } else if (GameBuffer.getInstance().getLobbyID() != null) {
            SwingUtilities.invokeLater(this::updatePlayerList);
        }
    }

    private void checkRecord() {
        String gameRecord = "あなたの対戦成績：" + resultObject.getInt(Protocol.Win.toString()) + "勝、" + resultObject.getInt(Protocol.Lose.toString()) + "敗";
        GameRecordDialog.getDialog(mainFrame, gameRecord).setVisible(true);
    }

    private void exitLobby() {
        SwingUtilities.invokeLater(this::updatePlayerList);
    }

    private void startGame() {
        if (resultObject.getBoolean(Protocol.Status.toString())) {
            WebSocketClient.getInstance().switchToAppServer();
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

    private void setGamePlayers() { //required by joinGame()
        JSONArray jsonArray = resultObject.getJSONArray(Protocol.PlayerList.toString());
        for (int i = 0; i < jsonArray.length(); i++) {
            ((GamePanelPlayerCard) mainFrame.getGamePanel().getPlayerCards()[i]).setPlayerName(jsonArray.getString(i));
            GameBuffer.getInstance().setPlayerList(jsonArray.getString(i));
        }
    }

    private void joinGame() {
        if (resultObject.getBoolean(Protocol.Status.toString())) {
            SwingUtilities.invokeLater(() -> {
                mainFrame.setGamePanel();
                mainFrame.changePanel(mainFrame.getGamePanel());
                setGamePlayers();
                mainFrame.getGamePanel().startPlayerTurn();
            });
        }
    }

    private void nextTurn() {
        GameBuffer.getInstance().setCurrentPlayer(resultObject.getString(Protocol.Username.toString()));
        mainFrame.getGamePanel().startPlayerTurn();
    }

    private void pieceMoveForward(Protocol protocol) { //required by rollDice(), selectRoute() and girdEffect(int type)
        if (protocol == Protocol.Roll || protocol == Protocol.Value) {
            for (int i = 0; i < resultObject.getInt(protocol.toString()); i++) {
                try {
                    mainFrame.getGamePanel().getGameMap().moveForward(GameBuffer.getInstance().getCurrentIndex());
                    TimeUnit.MILLISECONDS.sleep(500); //piece movement animation, repaints every 0.5 second
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.err.println("ERROR: unsupported protocol for pieceMoveForward() in ResultHandler.java");
        }
    }

    private void pieceMoveBackward() { //required by girdEffect(int type)
        for (int i = 0; i < resultObject.getInt(Protocol.Value.toString()); i++) {
            try {
                mainFrame.getGamePanel().getGameMap().moveBackward(GameBuffer.getInstance().getCurrentIndex());
                TimeUnit.MILLISECONDS.sleep(500); //piece movement animation, repaints every 0.5 second
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void pieceBackToStart() { //required by girdEffect(int type)
        mainFrame.getGamePanel().getGameMap().backToStart(GameBuffer.getInstance().getCurrentIndex());
    }

    private void getItem() { //required by gridEffect(int type)
        //TODO: complete getItem()
    }

    private void allGetItem() { //required by gridEffect(int type)
        //TODO: complete allGetItem()
    }

    private void allLoseItem() { //required by gridEffect(int type)
        //TODO: complete allLoseItem()
    }

    private void gridEffect(int type) {
        switch (type) {
            case 0 -> {}
            case 1 -> getItem();
            case 2 -> pieceMoveForward(Protocol.Value);
            case 3 -> pieceMoveBackward();
            case 4 -> pieceBackToStart();
            case 5 -> allGetItem();
            case 6 -> allLoseItem();
            default -> System.err.println("ERROR: unsupported grid effect type for gridEffect() in ResultHandler.java");
        }
    }

    private void rollDice() {
        if (GameBuffer.getInstance().isMyTurn()) {
            RollDiceDialog.getDialog(mainFrame, resultObject.getInt(Protocol.Roll.toString()) + resultObject.getInt(Protocol.NextDiceNum.toString())).setVisible(true);
        }
        if (resultObject.getInt(Protocol.NextDiceNum.toString()) == 0) {
            SwingUtilities.invokeLater(() -> {
                pieceMoveForward(Protocol.Roll);
                gridEffect(resultObject.getInt(Protocol.Effect.toString()));
            });
        } else {
            SwingUtilities.invokeLater(() -> pieceMoveForward(Protocol.Roll));
            SelectRouteDialog.getDialog(mainFrame).setVisible(true);
        }
    }

    private void selectRoute() {
        if (resultObject.getInt(Protocol.NextDiceNum.toString()) == 0) {
            SwingUtilities.invokeLater(() -> pieceMoveForward(Protocol.Roll));
        }
    }

    private void endGame() {
        EndGameDialog.getDialog(mainFrame, resultObject.getString(Protocol.Username.toString()));
        GameBuffer.getInstance().clearInGameData();
        WebSocketClient.getInstance().switchToClientServer();
        SwingUtilities.invokeLater(() -> mainFrame.changePanel(mainFrame.getMatchingPanel()));
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
                        case NEXT_TURN -> nextTurn();
                        case ROLL_DICE -> rollDice();
                        case SELECT_ROUTE -> selectRoute();
                        case END_GAME -> endGame();
                        default -> System.err.println("ERROR: illegal protocol detected.");
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
