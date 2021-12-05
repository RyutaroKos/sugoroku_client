package com.ui.component.button;

import com.ui.scheme.ColorScheme;
import com.ui.scheme.FontScheme;

import javax.swing.*;
import java.awt.*;

public class MatchingPanelButton extends JButton {
    MatchingPanelButton(String label) {
        super(label);
        setPreferredSize(new Dimension(350, 100));
        setBackground(ColorScheme.LIGHT_GOLD.getColor());
        setFont(FontScheme.MATCHING_BUTTON.getFont());
    }
}
