package com.ui.component;

import com.ui.component.button.LobbyPanelButton;
import com.ui.scheme.ColorScheme;
import com.ui.scheme.LayoutScheme;
import com.ui.component.subpanel.*;

import javax.swing.*;
import java.awt.*;

public class LobbyPanel extends JPanel {
    MainFrame parentFrame;
    String lobbyType;
    String lobbyID;

    LobbyPanel(MainFrame parentFrame) {
        setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        setLayout(new GridBagLayout());
        this.parentFrame = parentFrame;

        JPanel lobbyTop = LobbyPanelTop.getPanel();
        JPanel lobbyLeft = LobbyPanelBottom.getPanel("playerList");
        JPanel lobbyRight = LobbyPanelBottom.getPanel("chatPanel");
        JButton exitLobbyButton = LobbyPanelButton.getButton("退室");
        JButton startGameButton = LobbyPanelButton.getButton("開始");
        JButton sendMessageButton = LobbyPanelButton.getButton("送信");



        add(lobbyTop, LayoutScheme.LOBBY_TITLE.getLayout());
        add(lobbyLeft, LayoutScheme.LOBBY_PLAYERLIST.getLayout());
        add(lobbyRight, LayoutScheme.LOBBY_CHATPANEL.getLayout());
    }


}
