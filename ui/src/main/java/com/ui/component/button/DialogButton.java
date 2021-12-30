package com.ui.component.button;

import com.ui.scheme.ColorScheme;
import com.ui.scheme.FontScheme;

import javax.swing.*;
import java.awt.*;

public class DialogButton extends JButton {
    DialogButton(String text) {
        super(text);
        setPreferredSize(new Dimension(100, 50));
        setColor(text);
        setFont(FontScheme.DIALOG_BUTTON.getFont());
    }

    private void setColor(String label) {
        if (label.equals("はい")) {
            setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        } else {
            setBackground(ColorScheme.LIGHT_YELLOW.getColor());
        }
    }
}
