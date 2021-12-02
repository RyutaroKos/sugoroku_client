package com.ui.component.subpanel;

import com.ui.scheme.ColorScheme;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LobbyPanelBottom extends JPanel {
    LobbyPanelBottom(String title) {
        this.setPreferredSize(new Dimension(400, 600));
        this.setBorder(new LineBorder(Color.BLACK, 1, false));
        setPanelColor(title);
    }

    void setPanelColor(String title) {
        if (title.equals("playerList")) {
            this.setBackground(ColorScheme.LIGHT_GOLD.getColor());
        } else {
            this.setBackground(ColorScheme.LIGHT_BLUE.getColor());
        }
    }

    public static LobbyPanelBottom getPanel(String title) {
        return new LobbyPanelBottom(title);
    }
}
