package com.ui.component.button;

import com.ui.scheme.*;

import javax.swing.*;
import java.awt.*;

public class DialogButton extends JButton {
    DialogButton(String label) {
        super(label);
        setPreferredSize(new Dimension(100, 50));
        setFont(FontScheme.DIALOG_BUTTON.getFont());
        setBackground(ColorScheme.LIGHT_ORANGE.getColor());
    }

    public static DialogButton getButton(String label) {
        return new DialogButton(label);
    }
}
