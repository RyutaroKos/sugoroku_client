package com.ui.component.label;

import com.ui.scheme.FontScheme;

import javax.swing.*;

public class GamePanelMapLabel extends JLabel {
    GamePanelMapLabel(String text) {
        super(text);
        setFont(FontScheme.GAME_MAP_LABEL.getFont());
    }
}
