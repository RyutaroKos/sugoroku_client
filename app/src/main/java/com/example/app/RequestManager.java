package com.example.app;

import com.data.buffer.RequestBuffer;

import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class RequestManager implements Runnable {
    @Override
    public void run() {
        while (true) {
            if (!RequestBuffer.getInstance().isEmpty()) {
                JSONObject jsonObject = RequestBuffer.getInstance().retrieveRequest();
                System.out.println(jsonObject);
            } else {
                try {
                    TimeUnit.MICROSECONDS.sleep(100); //コマンド読み取り処理が追いつかない場合、このタイムアウトを延長
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
