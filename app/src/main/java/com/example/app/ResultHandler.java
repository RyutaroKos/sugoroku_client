package com.example.app;

import com.data.Protocol;
import com.data.Request;
import com.data.buffer.ResultBuffer;
import com.ui.component.UIKeyword;
import com.ui.component.FactoryConstructor;
import com.ui.component.MainFrame;
import org.json.JSONObject;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ResultHandler implements Runnable {
    MainFrame mainFrame;
    JSONObject resultObject;

    ResultHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
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
        FactoryConstructor.getFactory(UIKeyword.Dialog).getDialog(mainFrame, UIKeyword.SignupDialog, resultObject.getBoolean(Protocol.Status.toString()), null).setVisible(true);
    }

    private void randomMatch() { //TODO: add player list and chat record
        if (resultObject.getBoolean(Protocol.Status.toString())) {
            SwingUtilities.invokeLater(() -> {
                mainFrame.setLobbyPanel(UIKeyword.RandomLobby.toString(), resultObject.getString(Protocol.LobbyID.toString()));
                mainFrame.changePanel(mainFrame.getLobbyPanel());
            });
        }
    }

    private void privateMatch() { //TODO: add player list and chat record
        if (resultObject.getBoolean(Protocol.Status.toString())) {
            SwingUtilities.invokeLater(() -> {
                mainFrame.setLobbyPanel(UIKeyword.PrivateLobby.toString(), resultObject.getString(Protocol.LobbyID.toString()));
                mainFrame.changePanel(mainFrame.getLobbyPanel());
            });
        }
    }

    private void checkRecord() {
        String gameRecord = "あなたの成績：" + resultObject.getInt("Win") + "勝、" + resultObject.getInt("Lose") + "敗です";
        FactoryConstructor.getFactory(UIKeyword.Dialog).getDialog(mainFrame, UIKeyword.GameRecordDialog, null, gameRecord).setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            if (!ResultBuffer.getInstance().isEmpty()) {
                resultObject = ResultBuffer.getInstance().retrieveResult();
                switch (Request.valueOf(resultObject.getString(Protocol.Result.toString()))) {
                    case LOGIN -> login();
                    case SIGNUP -> signup();
                    case RANDOM_MATCH -> randomMatch();
                    case PRIVATE_MATCH -> privateMatch();
                    case CHECK_RECORD -> checkRecord();
                    default -> System.out.println("Unsupported protocol.");
                }
            } else {
                try {
                    TimeUnit.MICROSECONDS.sleep(100); //result読み取り処理が追いつかない場合、このタイムアウトを延長
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
