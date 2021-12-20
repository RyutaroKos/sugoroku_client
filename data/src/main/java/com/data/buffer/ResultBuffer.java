package com.data.buffer;

import java.util.ArrayDeque;

public class ResultBuffer extends ArrayDeque<String> {
    private static final ResultBuffer instance = new ResultBuffer();

    private ResultBuffer() {}

    public String retrieveResult() {
        return instance.poll();
    }

    public static ResultBuffer getInstance() {
        return instance;
    }
}
