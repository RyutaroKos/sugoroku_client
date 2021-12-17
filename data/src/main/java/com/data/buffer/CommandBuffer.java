package com.data.buffer;

import java.util.ArrayDeque;

public class CommandBuffer extends ArrayDeque<String> {
    private static final CommandBuffer instance = new CommandBuffer();

    private CommandBuffer() {}

    public void registerCommand(String command) {
        instance.add(command);
    }

    public String retrieveCommand() {
        return instance.poll();
    }

    public static CommandBuffer getInstance() {
        return instance;
    }
}
