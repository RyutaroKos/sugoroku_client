package com.data.buffer;

public class DataBuffer {
    private static final DataBuffer instance = new DataBuffer();
    private String username;
    private String password;
    private String lobbyID;
    private String message;

    private DataBuffer() {
        username = null;
        password = null;
        lobbyID = null;
        message = null;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLobbyID(String lobbyID) {
        this.lobbyID = lobbyID;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLobbyID() {
        return lobbyID;
    }

    public String getMessage() {
        return message;
    }

    public static DataBuffer getInstance() {
        return instance;
    }
}
