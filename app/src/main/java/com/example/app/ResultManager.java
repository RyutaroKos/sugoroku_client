package com.example.app;

import com.data.Flag;
import com.data.Request;
import com.data.buffer.ResultBuffer;
import com.ui.component.MainFrame;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

public class ResultManager implements Runnable {
    MainFrame mainFrame;
    
    ResultManager(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public void login() {
    	if(reslutObject.get(Flag.Status.toString())) {
    		this.mainFrame.changePannel(this.mainFrame.getMachingPannel());
    	}
    	else {
    		LoginDialog.getDialog(this.mainFrame).setVisible(true);
    	}
    }
    
    public void signUp() {
       SignupDialog.getDialog(this.mainFrame,resultObject.get(Flag.Status.toString())).setVisible(true);
    }
    
    public void randomMatch() {
    }
    
    public void privateMatch() {
    	
    }
    
    public void checkRecord() {
    	/*マッチングパネルクラスの中(呼び出し方)1*/
    }
    
    public void sendChat() {
    	//サーバーに貯めたchatを表示
    	//自分が送ったchatはそのまま表示、他人のchatはseverから受け取って表示
    	
    }
    
    public void startGame() {
    	//同様にアプリケーションサーバ―に接続
    }
    
    public void exitLobby() {
    	//抜けるときにseverに名前が送信され、「その名前+が退出しました」をLobbyに表示
    	
    }

    @Override
    public void run() {
        while (true) {
            if (!ResultBuffer.getInstance().isEmpty()) {
                JSONObject resultObject = ResultBuffer.getInstance().retrieveResult();
                switch (Request.valueOf(resultObject.getString(Flag.Result.toString()))) {
                    case LOGIN:
                    	this.login();
                        System.out.println("Result received.");
                    case SIGNUP:
                    	this.signUp();
                    case RANDOM_MATCH:
                    	this.randomMatch();
                    case PRIVATE_MATCH:
                    	this.privateMatch();
                    case CHECK_RECORD:
                    	this.checkRecord();
                    case SEND_CHAT:
                    	this.sendChat();
                    case START_GAME:
                    	this.startGame();
                    case EXIT_LOBBY:
                    	this.exitLobby();
                    default:
                        System.out.println("Unsupported protocol.");
                }
            } else {
                try {
                    TimeUnit.MICROSECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
