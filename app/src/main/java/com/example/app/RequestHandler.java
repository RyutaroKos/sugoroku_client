package com.example.app;

import com.data.buffer.RequestBuffer;
import com.netcom.websocket.WebSocketClient;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

public class RequestHandler implements Runnable {
    WebSocketClient webSocketClient;

    RequestHandler() {
        webSocketClient = WebSocketClient.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            if (webSocketClient.getConnectionStatus() && !RequestBuffer.getInstance().isEmpty()) {
                JSONObject requestObject = RequestBuffer.getInstance().retrieveRequest();
                webSocketClient.sendRequest(requestObject.toString());
                System.out.println(requestObject);
            } else {
                try {
                    TimeUnit.MICROSECONDS.sleep(100); //request読み取り処理が追いつかない場合、このタイムアウトを延長
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
