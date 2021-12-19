package com.data;

import com.data.buffer.DataBuffer;
import org.json.JSONObject;

public class JSONBuilder {
    private final JSONObject jsonObject;

    JSONBuilder(String requestType) {
        jsonObject = new JSONObject();
        jsonObject.put("Request", requestType);
        switch (Request.valueOf(requestType)) {
            case LOGIN, SIGNUP -> {
                jsonObject.put("Username", DataBuffer.getInstance().getUsername());
                jsonObject.put("Password", DataBuffer.getInstance().getPassword());
            }
            case RANDOM_MATCH, CHECK_RECORD -> jsonObject.put("Username", DataBuffer.getInstance().getUsername());
            case PRIVATE_MATCH, EXIT_LOBBY -> {
                jsonObject.put("Username", DataBuffer.getInstance().getUsername());
                jsonObject.put("LobbyID", DataBuffer.getInstance().getLobbyID());
            }
            case START_GAME -> jsonObject.put("LobbyID", DataBuffer.getInstance().getLobbyID());
            case SEND_CHAT -> {
                jsonObject.put("Username", DataBuffer.getInstance().getUsername());
                jsonObject.put("LobbyID", DataBuffer.getInstance().getLobbyID());
                jsonObject.put("Message", DataBuffer.getInstance().getMessage());
            }
        }
    }

    public static JSONObject getJsonObject(String requestType) {
        return new JSONBuilder(requestType).jsonObject;
    }
}
