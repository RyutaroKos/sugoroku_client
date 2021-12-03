package com.ui.component.button;

import com.ui.scheme.*;

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
                this.setBackground(ColorScheme.LIGHT_BRICK.getColor());
                this.setPreferredSize(new Dimension(100, 80));
                this.setFont(FontScheme.LOBBY_TOP_BUTTON.getFont());
                break;
            case "開始":
                this.setBackground(ColorScheme.LIGHT_YELLOW.getColor());
                this.setPreferredSize(new Dimension(100, 80));
                this.setFont(FontScheme.LOBBY_TOP_BUTTON.getFont());
                break;
            case "送信":
                this.setBackground(ColorScheme.LIGHT_INDIGO.getColor());
                this.setPreferredSize(new Dimension(40, 20));
                this.setFont(FontScheme.LOBBY_BUTTOM_BUTTON.getFont());
                break;
        }
    }

    public static LobbyPanelButton getButton(String label) {
        return new LobbyPanelButton(label);
    }
}
