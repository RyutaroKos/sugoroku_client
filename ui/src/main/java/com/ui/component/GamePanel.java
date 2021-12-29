package com.ui.component;

import com.ui.component.subcomponent.GamePanelMap;
import com.ui.scheme.ColorScheme;

import javax.swing.*;

/**
 * ゲーム開始後表示する第四の画面：ゲームパネル。
 * 現在工事中…
 */

public class GamePanel extends JPanel {
    MainFrame parentFrame;
    GamePanelMap gamePanelMap;
    JButton forward = new JButton("Forward");
    JButton backward = new JButton("Backward");
    JButton direction = new JButton("Direction");

    GamePanel(MainFrame mainFrame) {
        setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        parentFrame = mainFrame;
        gamePanelMap = new GamePanelMap();

        forward.addActionListener(e -> gamePanelMap.moveForward(0));
        backward.addActionListener(e -> gamePanelMap.moveBackward(0));
        direction.addActionListener(e -> gamePanelMap.setKeepDirection(0));
        add(gamePanelMap);
        add(forward);
        add(backward);
        add(direction);
    }
}
