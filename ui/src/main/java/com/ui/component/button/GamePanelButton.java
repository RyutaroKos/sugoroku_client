package com.ui.component.button;

import com.ui.scheme.ColorScheme;
import com.ui.scheme.FontScheme;

import javax.swing.*;
import java.awt.*;

public class GamePanelButton extends JButton {
    GamePanelButton(String text) {
        super(text);
        setStyle(text);
    }

    private void setStyle(String text) {
        if (text.equals("道具を使用する")) {
            setBackground(ColorScheme.LIGHT_YELLOW.getColor());
        } else {
            setBackground(ColorScheme.LIGHT_BRICK.getColor());
        }
        setPreferredSize(new Dimension(200, 70));
        setFont(FontScheme.LOBBY_BANNER_BUTTON.getFont());
    }
}
