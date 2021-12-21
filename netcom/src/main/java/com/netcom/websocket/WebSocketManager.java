package com.netcom.websocket;

import jakarta.websocket.ContainerProvider;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;

import java.io.IOException;
import java.net.URI;

public class WebSocketManager {
    Session session;
    WebSocketContainer container;
    URI uri;
    
    WebSocketManager(String uri) {
        container = ContainerProvider.getWebSocketContainer();
        this.uri = URI.create(uri);
    }
    
    public boolean isConnected() {
//        System.out.println("Client is connected?: " + session.isOpen());
        return session.isOpen();
    }

    public void connect() {
        System.out.println("Client connected to: " + uri);
        try {
            session = container.connectToServer(new WebSocketEndpoint(), uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendRequestMessage(String requestMessage) {
        System.out.println("Client send request message:\n" + requestMessage);
        try {
            session.getBasicRemote().sendText(requestMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect() throws IOException {
        if (!session.isOpen()) {
            session.close();
        }
    }
}
