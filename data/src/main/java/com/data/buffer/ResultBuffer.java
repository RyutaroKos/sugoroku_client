package com.data.buffer;

import org.json.JSONObject;

import java.util.ArrayDeque;

public class ResultBuffer extends ArrayDeque<JSONObject> {
    private static final ResultBuffer instance = new ResultBuffer();

    private ResultBuffer() {}

    public void registerResult(JSONObject result) {
        instance.add(result);
    }

    public JSONObject retrieveResult() {
        return instance.poll();
    }

    public static ResultBuffer getInstance() {
        return instance;
    }
}
