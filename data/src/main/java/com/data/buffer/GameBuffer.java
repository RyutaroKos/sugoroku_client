package com.data.buffer;

public class GameBuffer {
    private static final GameBuffer instance = new GameBuffer();
    private String username;
    private String lobbyID;
    private int myTurn;
    private int gameTurn;

    private GameBuffer() {
        username = null;
        lobbyID = null;
        myTurn = 0;
        gameTurn = 0;
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

    public void setMyTurn(int myTurn) {
        this.myTurn = ++myTurn;
    }

    public int getMyTurn() {
        return myTurn;
    }

    public void setGameTurn() {
        gameTurn = 1;
    }

    public void nextTurn() {
        gameTurn++;
    }

    public int getGameTurn() {
        return gameTurn;
    }

    public void clearTurnData() {
        myTurn = 0;
        gameTurn = 0;
    }

    public static GameBuffer getInstance() {
        return instance;
    }
}
