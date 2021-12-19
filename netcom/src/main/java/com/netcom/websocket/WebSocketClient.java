package com.netcom.websocket;

import java.util.concurrent.TimeUnit;

public class WebSocketClient implements Runnable {
    WebSocketManager webSocketManager;

    WebSocketClient() {
        String serverEndpoint = "ws://localhost:8080/app/sample";
        webSocketManager = new WebSocketManager(serverEndpoint);
        webSocketManager.connect();
    }

    @Override
    public void run() {
        while (true) {
            if (webSocketManager.isConnected()) {
                webSocketManager.sendRequestMessage("test");
            }
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
