package com.netcom.websocket;

public class WebSocketClient {
    private static final WebSocketClient instance = new WebSocketClient();
    private final WebSocketManager webSocketManager;
    private WebSocketManager currentManager;

    private WebSocketClient() {
        String clientServerEndpoint = "ws://localhost:8080/app/sample"; //必要に応じてエンドポイントを調整
        webSocketManager = new WebSocketManager(clientServerEndpoint);
        webSocketManager.connect();
        currentManager = webSocketManager;
    }

    public boolean getConnectionStatus() {
        return currentManager.isConnected();
    }

    public void sendRequest(String request) {
        currentManager.sendRequestMessage(request);
    }

    public void switchToAppServer() {
        String appServerEndpoint = "ws://localhost:8080/app/example"; //必要に応じてエンドポイントを調整
        currentManager = new WebSocketManager(appServerEndpoint);
        currentManager.connect();
    }

    public void switchToClientServer() {
        try {
            currentManager.disconnect();
            currentManager = webSocketManager;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebSocketClient getInstance() {
        return instance;
    }
}
