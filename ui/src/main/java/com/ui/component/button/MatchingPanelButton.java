package com.ui.component.button;

import com.ui.scheme.*;

import javax.swing.*;
import java.awt.*;

public class MatchingPanelButton extends JButton {
    MatchingPanelButton(String label) {
        super(label);
        this.setPreferredSize(new Dimension(350, 100));
        this.setBackground(ColorScheme.LIGHT_GOLD.getColor());
        this.setFont(FontScheme.MATCHING_BUTTON.getFont());
    }

    public static MatchingPanelButton getButton(String label) {
        return new MatchingPanelButton(label);
    }
}
