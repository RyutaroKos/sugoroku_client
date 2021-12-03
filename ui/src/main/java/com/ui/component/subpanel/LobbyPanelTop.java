package com.ui.component.subpanel;

import com.ui.scheme.ColorScheme;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LobbyPanelTop extends JPanel {
    LobbyPanelTop() {
        setPreferredSize(new Dimension(800, 100));
        setBorder(new LineBorder(Color.BLACK, 1, false));
        setBackground(ColorScheme.LIGHT_RED.getColor());
        setLayout(new GridBagLayout());
    }

    public static LobbyPanelTop getPanel() {
        return new LobbyPanelTop();
    }
}
