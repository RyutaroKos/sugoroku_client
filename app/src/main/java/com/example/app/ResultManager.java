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
    	/*
    	if(reslutObject.get(Flag.Status.toString())) {
    		mainFrame.changePannel(mainFrame.getMachingPannel());
    	}
    	else {
    		LoginDialog.getDialog(mainFrame).setVisible(true);
    	}
    	*/
    }
    
    public void signUp() {
    	//SignupDialog signupDialog = new SignupDialog(this.mainFrame,resultObject.get(Flag.Status));
    }
    
    public void randomMatch() {
    	
    }
    
    public void privateMatch() {
    	
    }
    
    public void checkRecord() {
    	
    }

    @Override
    public void run() {
        while (true) {
            if (!ResultBuffer.getInstance().isEmpty()) {
                JSONObject resultObject = ResultBuffer.getInstance().retrieveResult();
                switch (Request.valueOf(resultObject.getString(Flag.Result.toString()))) {
                    case LOGIN:
                        System.out.println("Result received.");
                    case SIGNUP:
                    	signUp();
                    case RANDOM_MATCH:
                    	randomMatch();
                    case PRIVATE_MATCH:
                    	privateMatch();
                    case CHECK_RECORD:
                    	
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
