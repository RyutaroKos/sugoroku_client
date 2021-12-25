package com.netcom.websocket;

public class WebSocketClient {
    private static final WebSocketClient instance = new WebSocketClient();
    private String serverEndpoint;
    private WebSocketManager webSocketManager;

    private WebSocketClient() {
        serverEndpoint = "ws://localhost:8080/app/sample"; //必要に応じてエンドポイントを調整
        webSocketManager = new WebSocketManager(serverEndpoint);
        webSocketManager.connect();
    }

    public boolean getConnectionStatus() {
        return webSocketManager.isConnected();
    }

    public void sendRequest(String request) {
        webSocketManager.sendRequestMessage(request);
    }

    public void switchServer(String endpoint) {
        try {
            serverEndpoint = endpoint;
            webSocketManager.disconnect();
            webSocketManager = new WebSocketManager(endpoint);
            webSocketManager.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebSocketClient getInstance() {
        return instance;
    }
}
