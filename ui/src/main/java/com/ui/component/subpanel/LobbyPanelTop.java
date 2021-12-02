package com.ui.component.subpanel;

import com.ui.scheme.ColorScheme;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LobbyPanelTop extends JPanel {
    LobbyPanelTop() {
        this.setPreferredSize(new Dimension(800, 100));
        this.setBorder(new LineBorder(Color.BLACK, 1, false));
        this.setBackground(ColorScheme.LIGHT_RED.getColor());
    }

    public static LobbyPanelTop getPanel() {
        return new LobbyPanelTop();
    }
}
