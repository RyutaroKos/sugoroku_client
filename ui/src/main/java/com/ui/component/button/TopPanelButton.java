package com.ui.component.button;

import com.ui.scheme.*;

import javax.swing.*;
import java.awt.*;

public class TopPanelButton extends JButton {
    TopPanelButton(String label) {
        super(label);
        this.setPreferredSize(new Dimension(250, 100));
        this.setFont(FontScheme.TOP_BUTTON.getFont());
        setBackgroundColor(label);
    }

    private void setBackgroundColor(String label) {
        if (label.equals("ログイン")) {
            this.setBackground(ColorScheme.LIGHT_BRICK.getColor());
        } else {
            this.setBackground(ColorScheme.LIGHT_YELLOW.getColor());
        }
    }
}
