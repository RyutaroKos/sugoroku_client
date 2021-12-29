package com.ui.component.label;

import com.ui.component.subcomponent.MapGrid;
import com.ui.scheme.ColorScheme;

import javax.swing.*;
import java.awt.*;

public class GamePanelLabel extends JLabel {
    String label;
    LabelIcon labelIcon;

    GamePanelLabel(String label) {
        super();
        this.label = label;
        try {
            switch (MapGrid.valueOf(this.label)) {
                case START -> setText("スタート地点");
                case GOAL -> setText("ゴール地点");
                case BLANK -> setText("ノーマル（効果なし）");
                case GET_ITEM -> setText("道具獲得");
                case FORWARD -> setText("１マス前進");
                case BACKWARD -> setText("１マス後退");
                case CROSSROAD -> setText("分岐地点");
                case RENDEZVOUS -> setText("合流地点");
                case ALL_GET_ITEM -> setText("全員道具獲得");
                case ALL_LOSE_ITEM -> setText("全員道具損失");
                case RESTART -> setText("警告：スタート地点に伝送");
            }
        } catch (IllegalArgumentException e) {
            switch (label) {
                case "PLAYER_1" -> setText("プレイヤー１");
                case "PLAYER_2" -> setText("プレイヤー２");
                case "PLAYER_3" -> setText("プレイヤー３");
                case "PLAYER_4" -> setText("プレイヤー４");
                default -> throw e;
            }
        }
        labelIcon = new LabelIcon(10, 10);
        setIcon(labelIcon);
    }

    class LabelIcon implements Icon {
        private final int iconWidth;
        private final int iconHeight;

        LabelIcon(int width, int height) {
            iconWidth = width;
            iconHeight = height;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g;
            try {
                switch (MapGrid.valueOf(label)) {
                    case START -> {
                        g2.setPaint(ColorScheme.DARK_BLUE.getColor());
                        g2.fillRect(x, y, iconWidth, iconHeight);
                    }
                    case GOAL -> {
                        g2.setPaint(ColorScheme.DARK_RED.getColor());
                        g2.fillRect(x, y, iconWidth, iconHeight);
                    }
                    case BLANK -> {
                        g2.setPaint(ColorScheme.WHITE.getColor());
                        g2.fillRect(x, y, iconWidth, iconHeight);
                    }
                    case GET_ITEM -> {
                        g2.setPaint(ColorScheme.LIGHT_GOLD.getColor());
                        g2.fillRect(x, y, iconWidth, iconHeight);
                    }
                    case FORWARD -> {
                        g2.setPaint(ColorScheme.LIGHT_RED.getColor());
                        g2.fillRect(x, y, iconWidth, iconHeight);
                    }
                    case BACKWARD -> {
                        g2.setPaint(ColorScheme.LIGHT_BLUE.getColor());
                        g2.fillRect(x, y, iconWidth, iconHeight);
                    }
                    case CROSSROAD -> {
                        g2.setPaint(ColorScheme.DARK_GREEN.getColor());
                        g2.fillRect(x, y, iconWidth, iconHeight);
                    }
                    case RENDEZVOUS -> {
                        g2.setPaint(ColorScheme.LIGHT_GREEN.getColor());
                        g2.fillRect(x, y, iconWidth, iconHeight);
                    }
                    case ALL_GET_ITEM -> {
                        g2.setPaint(ColorScheme.GOLD.getColor());
                        g2.fillRect(x, y, iconWidth, iconHeight);
                    }
                    case ALL_LOSE_ITEM -> {
                        g2.setPaint(ColorScheme.INDIGO.getColor());
                        g2.fillRect(x, y, iconWidth, iconHeight);
                    }
                    case RESTART -> {
                        g2.setPaint(ColorScheme.DARK_GRAY.getColor());
                        g2.fillRect(x, y, iconWidth, iconHeight);
                    }
                }
                g2.setPaint(Color.BLACK);
                g2.drawRect(x, y, iconWidth, iconHeight);
            } catch (IllegalArgumentException e) {
                switch (label) {
                    case "PLAYER_1" -> g2.setPaint(ColorScheme.RED.getColor());
                    case "PLAYER_2" -> g2.setPaint(ColorScheme.PURPLE.getColor());
                    case "PLAYER_3" -> g2.setPaint(ColorScheme.YELLOW.getColor());
                    case "PLAYER_4" -> g2.setPaint(ColorScheme.GREEN.getColor());
                    default -> throw e;
                }
                g2.fillOval(x , y , iconWidth, iconHeight);
                g2.setPaint(Color.BLACK);
                g2.drawOval(x, y, iconWidth, iconHeight);
            }
        }

        @Override
        public int getIconWidth() {
            return iconWidth;
        }

        @Override
        public int getIconHeight() {
            return iconHeight;
        }
    }
}
