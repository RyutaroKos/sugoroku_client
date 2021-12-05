package com.ui.component.button;

import com.ui.scheme.ColorScheme;
import com.ui.scheme.FontScheme;

import javax.swing.*;
import java.awt.*;

public class TopPanelButton extends JButton {
    TopPanelButton(String label) {
        super(label);
        setPreferredSize(new Dimension(250, 100));
        setBackgroundColor(label);
        setFont(FontScheme.TOP_BUTTON.getFont());
    }

    private void setBackgroundColor(String label) {
        if (label.equals("ログイン")) {
            this.setBackground(ColorScheme.LIGHT_BRICK.getColor());
        } else {
            this.setBackground(ColorScheme.LIGHT_YELLOW.getColor());
        }
    }
}
