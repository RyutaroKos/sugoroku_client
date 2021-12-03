package com.ui.component.subpanel;

import com.ui.scheme.ColorScheme;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LobbyPanelBottom extends JPanel {
    LobbyPanelBottom(String title) {
        setPreferredSize(new Dimension(400, 600));
        setBorder(new LineBorder(Color.BLACK, 1, false));
        setColor(title);
        setLayout(new GridBagLayout());
    }

    private void setColor(String title) {
        if (title.equals("playerList")) {
            setBackground(ColorScheme.LIGHT_GOLD.getColor());
        } else {
            setBackground(ColorScheme.LIGHT_BLUE.getColor());
        }
    }

    public static LobbyPanelBottom getPanel(String title) {
        return new LobbyPanelBottom(title);
    }
}
