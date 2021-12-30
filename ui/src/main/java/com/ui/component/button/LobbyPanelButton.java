package com.ui.component.button;

import com.ui.scheme.ColorScheme;
import com.ui.scheme.FontScheme;

import javax.swing.*;
import java.awt.*;

public class LobbyPanelButton extends JButton {
    LobbyPanelButton(String text) {
        super(text);
        setStyle(text);
    }

    private void setStyle(String text) {
        switch (text) {
            case "退室" -> {
                setBackground(ColorScheme.LIGHT_BRICK.getColor());
                setPreferredSize(new Dimension(150, 70));
                setFont(FontScheme.LOBBY_BANNER_BUTTON.getFont());
            }
            case "開始" -> {
                setBackground(ColorScheme.LIGHT_YELLOW.getColor());
                setPreferredSize(new Dimension(150, 70));
                setFont(FontScheme.LOBBY_BANNER_BUTTON.getFont());
            }
            case "送信" -> {
                setBackground(ColorScheme.LIGHT_INDIGO.getColor());
                setPreferredSize(new Dimension(80, 45));
                setFont(FontScheme.LOBBY_BODYPANEL_BUTTON.getFont());
            }
            default -> throw new IllegalArgumentException("Unexpected value: " + text);
        }
    }
}
