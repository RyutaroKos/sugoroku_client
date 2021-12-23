package com.data.buffer;

public class GameBuffer {
    private static final GameBuffer instance = new GameBuffer();
    private String username;
    private String lobbyID;

    private GameBuffer() {
        username = null;
        lobbyID = null;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setLobbyID(String lobbyID) {
        this.lobbyID = lobbyID;
    }

    public String getLobbyID() {
        return lobbyID;
    }

    public void clearLobbyID() {
        lobbyID = null;
    }

    public static GameBuffer getInstance() {
        return instance;
    }
}
