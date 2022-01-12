package com.example.app;

import com.data.Flag;
import com.data.Request;
import com.data.buffer.ResultBuffer;
import com.ui.component.MainFrame;
import org.json.JSONObject;
/*以下のimport文はまとめられるかもしれない*/
import com.ui.component.dialog.LoginDialog;
import com.ui.component.dialog.SignupDialog;
import com.ui.component.dialog.GameRecordDialog;

import java.util.concurrent.TimeUnit;


public class ResultManager implements Runnable {
    MainFrame mainFrame;
    
    ResultManager(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    /*引数追加*/
    public void login(JSONObject resultObject) {
    	if(resultObject.getBoolean(Flag.Status.toString())) {
    		this.mainFrame.changePanel(this.mainFrame.getMatchingPanel());
    	}
    	else {
    		LoginDialog.getDialog(this.mainFrame).setVisible(true);
    	}
    }
    
    public void signUp(JSONObject resultObject) {
       SignupDialog.getDialog(this.mainFrame,resultObject.getBoolean(Flag.Status.toString())).setVisible(true);
    }
    
    public void randomMatch(JSONObject resultObject) {
    if(resultObject.getBoolean(Flag.Status.toString())) {
       this.mainFrame.changePanel(this.mainFrame.getLobbyPanel("random",resultObject.getString(Flag.LobbyID.toString())));
       
       /*  playerListの渡し方        = resultObject.get(Flag.PlayerList.toString()) */
       /*textAreaに表示 LobbyPanelクラスplayerListArea*/
    }
    }
    
    public void privateMatch(JSONObject resultObject) {
    	if(resultObject.getBoolean(Flag.Status.toString())) {
    	  this.mainFrame.changePanel(this.mainFrame.getLobbyPanel("private",resultObject.getString(Flag.LobbyID.toString())));	
    	}
    }
    
    public void checkRecord(JSONObject resultObject) {
    	/*戦績表示処理　勝ち数と負け数*/
    	String win = String.valueOf(resultObject.getInt(Flag.Win.toString()));
    	String lose = String.valueOf(resultObject.getInt(Flag.Lose.toString()));
    	String record = win + "勝" + lose + "敗";
    	GameRecordDialog.getDialog(this.mainFrame,record);
    	
    }

    @Override
    public void run() {
        while (true) {
            if (!ResultBuffer.getInstance().isEmpty()) {
                JSONObject resultObject = ResultBuffer.getInstance().retrieveResult();
                switch (Request.valueOf(resultObject.getString(Flag.Result.toString()))) {
                    case LOGIN:
                    	this.login(resultObject);
                        System.out.println("Result received.");
                    case SIGNUP:
                    	this.signUp(resultObject);
                    case RANDOM_MATCH:
                    	this.randomMatch(resultObject);
                    case PRIVATE_MATCH:
                    	this.privateMatch(resultObject);
                    case CHECK_RECORD:
                    	this.checkRecord(resultObject);
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
