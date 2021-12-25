package com.netcom.websocket;

import com.data.Protocol;
import com.data.Request;
import com.data.buffer.ResultBuffer;
import jakarta.websocket.*;
import org.json.JSONObject;

@ClientEndpoint
public class WebSocketEndpoint {
    @OnOpen
    public void onOpen(Session session) {
        JSONObject result = new JSONObject();
        result.put(Protocol.Result.toString(), Request.CONNECTION.toString());
        result.put(Protocol.Status.toString(), true);
        ResultBuffer.getInstance().registerResult(result);
        System.out.println("Client session opened with id: " + session.getId());
    }

    @OnMessage
    public void onMessage(String replyMessage) {
        JSONObject result = new JSONObject(replyMessage);
        ResultBuffer.getInstance().registerResult(result);
        System.out.println("Client received reply message:\n" + result);
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
