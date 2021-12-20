package com.data.buffer;

import com.data.Request;
import org.json.JSONObject;

import java.util.ArrayDeque;

public class RequestBuffer extends ArrayDeque<JSONObject> {
    private static final RequestBuffer instance = new RequestBuffer();

    private RequestBuffer() {}

    public JSONObject getRequestObject() {
        return new JSONObject();
    }

    public void registerRequest(JSONObject request) {
        instance.add(request);
    }

    public JSONObject retrieveRequest() {
        return instance.poll();
    }

    public static RequestBuffer getInstance() {
        return instance;
    }
}
