package com.netcom.websocket;

import javax.websocket.*;

@ClientEndpoint
public class WebSocketEndpoint {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client session opened with id: " + session.getId());
    }

    @OnMessage
    public void onMessage(String replyMessage) {
        System.out.println("Client received reply message:\n" + replyMessage);
    }

    @OnError
    public void onError(Throwable throwable) {
        System.err.println("Client error: " + throwable.getMessage());
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Client session closed with id: " + session.getId());
    }
}
