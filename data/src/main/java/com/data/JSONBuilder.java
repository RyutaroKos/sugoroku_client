package com.data;

import com.data.buffer.DataBuffer;
import org.json.JSONObject;

public class JSONBuilder {
    private final JSONObject jsonObject;

    JSONBuilder(String requestType) {
        jsonObject = new JSONObject();
        jsonObject.put("REQUEST", requestType);
        switch (Request.valueOf(requestType)) {
            case LOGIN, SIGNUP -> {
                jsonObject.put("USERNAME", DataBuffer.getInstance().getUsername());
                jsonObject.put("PASSWORD", DataBuffer.getInstance().getPassword());
            }
            case RANDOM_MATCH, CHECK_RECORD -> jsonObject.put("USERNAME", DataBuffer.getInstance().getUsername());
            case PRIVATE_MATCH, EXIT_LOBBY -> {
                jsonObject.put("USERNAME", DataBuffer.getInstance().getUsername());
                jsonObject.put("LOBBY_ID", DataBuffer.getInstance().getLobbyID());
            }
            case START_GAME -> jsonObject.put("LOBBY_ID", DataBuffer.getInstance().getLobbyID());
            case SEND_CHAT -> {
                jsonObject.put("USERNAME", DataBuffer.getInstance().getUsername());
                jsonObject.put("LOBBY_ID", DataBuffer.getInstance().getLobbyID());
                jsonObject.put("MESSAGE", DataBuffer.getInstance().getMessage());
            }
        }
    }

    public static JSONObject getJsonObject(String requestType) {
        return new JSONBuilder(requestType).jsonObject;
    }
}
