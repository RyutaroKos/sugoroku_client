package com.ui.component;

import com.ui.scheme.ColorScheme;

import javax.swing.*;
import java.awt.*;

public class MatchingPanel extends JPanel {
    MainFrame parentFrame;

    MatchingPanel(MainFrame parentFrame) {
        this.setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        this.setLayout(new GridBagLayout());

        this.parentFrame = parentFrame;
    }
}
