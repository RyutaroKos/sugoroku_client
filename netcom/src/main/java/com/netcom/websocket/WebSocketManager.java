package com.netcom.websocket;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
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
        System.out.println("Client is connected?: " + session.isOpen());
        return session.isOpen();
    }

    public boolean connect() {
        System.out.println("Client connected to: " + uri);
        try {
            session = container.connectToServer(new WebSocketEndpoint(), uri);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
}
