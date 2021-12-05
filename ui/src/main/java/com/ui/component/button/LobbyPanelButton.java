package com.ui.component.button;

import com.ui.scheme.ColorScheme;
import com.ui.scheme.FontScheme;

import javax.swing.*;
import java.awt.*;

public class LobbyPanelButton extends JButton {
    LobbyPanelButton(String label) {
        super(label);
        setStyle(label);
    }

    private void setStyle(String label) {
        switch (label) {
            case "退室":
                setBackground(ColorScheme.LIGHT_BRICK.getColor());
                setPreferredSize(new Dimension(150, 70));
                setFont(FontScheme.LOBBY_TOP_BUTTON.getFont());
                break;
            case "開始":
                setBackground(ColorScheme.LIGHT_YELLOW.getColor());
                setPreferredSize(new Dimension(150, 70));
                setFont(FontScheme.LOBBY_TOP_BUTTON.getFont());
                break;
            case "送信":
                setBackground(ColorScheme.LIGHT_INDIGO.getColor());
                setPreferredSize(new Dimension(80, 45));
                setFont(FontScheme.LOBBY_BOTTOM_BUTTON.getFont());
                break;
            default:
                break;
        }
    }
}
