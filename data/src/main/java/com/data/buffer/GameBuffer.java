package com.data.buffer;

import java.util.ArrayList;
import java.util.List;

public class GameBuffer {
    private static final GameBuffer instance = new GameBuffer();
    private String username;
    private String lobbyID;
    private String currentPlayer;
    private final List<String> playerList;

    private GameBuffer() {
        username = null;
        lobbyID = null;
        currentPlayer = null;
        playerList = new ArrayList<>();
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

    public void setCurrentPlayer(String playerName) {
        currentPlayer = playerName;
    }

    public void setPlayerList(String playerName) {
        playerList.add(playerName);
    }

    public List<String> getPlayerList() {
        return playerList;
    }

    public boolean isMyTurn() {
        return username.equals(currentPlayer);
    }

    public int getCurrentIndex() {
        return playerList.indexOf(currentPlayer);
    }

    public void clearInGameData() {
        lobbyID = null;
        currentPlayer = null;
        playerList.clear();
    }

    public static GameBuffer getInstance() {
        return instance;
    }
}
