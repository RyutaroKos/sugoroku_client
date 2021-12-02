package com.ui.component;

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
        this.setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        this.setLayout(new GridBagLayout());
        this.parentFrame = parentFrame;

        JPanel lobbyTop = LobbyPanelTop.getPanel();
        JPanel lobbyLeft = LobbyPanelBottom.getPanel("playerList");
        JPanel lobbyRight = LobbyPanelBottom.getPanel("chatPanel");

        this.add(lobbyTop, LayoutScheme.LOBBY_TITLE.getLayout());
        this.add(lobbyLeft, LayoutScheme.LOBBY_PLAYERLIST.getLayout());
        this.add(lobbyRight, LayoutScheme.LOBBY_CHATPANEL.getLayout());
    }


}
