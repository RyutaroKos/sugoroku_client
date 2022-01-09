package com.ui.component.subcomponent;

import com.ui.scheme.ColorScheme;
import com.ui.scheme.FontScheme;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GamePanelPlayerCard extends JPanel {
    JLabel playerLabel;
    JLabel playerName;
    JLabel playerStatus;

    GamePanelPlayerCard(Player player) {
        switch (player) {
            case PLAYER_1 -> {
                setBackground(ColorScheme.RED.getColor());
                playerLabel = new JLabel("プレイヤー１");
            }
            case PLAYER_2 -> {
                setBackground(ColorScheme.PURPLE.getColor());
                playerLabel = new JLabel("プレイヤー２");
            }
            case PLAYER_3 -> {
                setBackground(ColorScheme.YELLOW.getColor());
                playerLabel = new JLabel("プレイヤー３");
            }
            case PLAYER_4 -> {
                setBackground(ColorScheme.GREEN.getColor());
                playerLabel = new JLabel("プレイヤー４");
            }
        }
        setPreferredSize(new Dimension(300, 150));
        setBorder(new LineBorder(Color.BLACK, 1, false));
        setLayout(new GridLayout(3, 1, 10, 10));
        playerName = new JLabel();
        playerStatus = new JLabel("・状態：");

        playerLabel.setFont(FontScheme.GAME_MAP_EXAMPLE.getFont());
        playerName.setFont(FontScheme.GAME_MAP_EXAMPLE.getFont());
        playerStatus.setFont(FontScheme.GAME_MAP_EXAMPLE.getFont());

        add(playerLabel);
        add(playerName);
        add(playerStatus);
    }

    public void setPlayerName(String name) {
        playerName.setText("・名前：" + name);
    }

    public void setPlayerStatus(Boolean status) {
        if (status) {
            playerStatus.setText("・状態：行動中");
        } else {
            playerStatus.setText("・状態：待機中");
        }
    }

    public static GamePanelPlayerCard getPlayerCard(Player player) {
        return new GamePanelPlayerCard(player);
    }
}
