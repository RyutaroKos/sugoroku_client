package com.ui.component.button;

import com.ui.scheme.ColorScheme;
import com.ui.scheme.FontScheme;

import javax.swing.*;
import java.awt.*;

public class DialogButton extends JButton {
    DialogButton(String label) {
        super(label);
        setPreferredSize(new Dimension(100, 50));
        setFont(FontScheme.DIALOG_BUTTON.getFont());
        setColor(label);
    }

    void setColor(String label) {
        if (label.equals("はい")) {
            setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        } else {
            setBackground(ColorScheme.LIGHT_YELLOW.getColor());
        }
    }

    public static DialogButton getButton(String label) {
        return new DialogButton(label);
    }
}
