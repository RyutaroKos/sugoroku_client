package com.example.app;

import com.data.Flag;
import com.data.Request;
import com.data.buffer.ResultBuffer;
import com.ui.component.MainFrame;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

public class ResultHandler implements Runnable {
    MainFrame mainFrame;

    ResultHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {
        while (true) {
            if (!ResultBuffer.getInstance().isEmpty()) {
                JSONObject resultObject = ResultBuffer.getInstance().retrieveResult();
                switch (Request.valueOf(resultObject.getString(Flag.Result.toString()))) {
                    case LOGIN -> System.out.println("Result received.");
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
