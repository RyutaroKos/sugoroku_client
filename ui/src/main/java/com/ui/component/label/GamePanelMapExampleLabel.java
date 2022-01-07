package com.ui.component.label;

import com.ui.component.subcomponent.MapGrid;
import com.ui.component.subcomponent.Player;
import com.ui.scheme.ColorScheme;
import com.ui.scheme.FontScheme;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class GamePanelMapExampleLabel extends JLabel {
    String text;
    LabelIcon labelIcon;

    GamePanelMapExampleLabel(String text) {
        super();
        this.text = text;
        try {
            switch (MapGrid.valueOf(this.text)) {
                case START -> setText("スタート地点");
                case GOAL -> setText("ゴール地点");
                case BLANK -> setText("効果なし");
                case GET_ITEM -> setText("道具獲得");
                case FORWARD -> setText("１〜４マス前進");
                case BACKWARD -> setText("１〜３マス後退");
                case CROSSROAD -> setText("分岐地点");
                case RENDEZVOUS -> setText("合流地点");
                case ALL_GET_ITEM -> setText("全員道具獲得");
                case ALL_LOSE_ITEM -> setText("全員道具損失");
                case RESTART -> setText("警告：スタート地点に伝送");
            }
        } catch (IllegalArgumentException e) {
            switch (Player.valueOf(this.text)) {
                case PLAYER_1 -> setText("プレイヤー１");
                case PLAYER_2 -> setText("プレイヤー２");
                case PLAYER_3 -> setText("プレイヤー３");
                case PLAYER_4 -> setText("プレイヤー４");
                default -> throw e;
            }
        }
        labelIcon = new LabelIcon(18, 18);
        setIcon(labelIcon);
        setFont(FontScheme.GAME_MAP_EXAMPLE.getFont());
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
                switch (MapGrid.valueOf(text)) {
                    case START -> g2.setPaint(ColorScheme.DARK_BLUE.getColor());
                    case GOAL -> g2.setPaint(ColorScheme.DARK_RED.getColor());
                    case BLANK -> g2.setPaint(Color.WHITE);
                    case GET_ITEM -> g2.setPaint(ColorScheme.LIGHT_GOLD.getColor());
                    case FORWARD -> g2.setPaint(ColorScheme.LIGHT_RED.getColor());
                    case BACKWARD -> g2.setPaint(ColorScheme.LIGHT_BLUE.getColor());
                    case CROSSROAD -> g2.setPaint(ColorScheme.DARK_GREEN.getColor());
                    case RENDEZVOUS -> g2.setPaint(ColorScheme.LIGHT_GREEN.getColor());
                    case ALL_GET_ITEM -> g2.setPaint(ColorScheme.GOLD.getColor());
                    case ALL_LOSE_ITEM -> g2.setPaint(ColorScheme.INDIGO.getColor());
                    case RESTART -> g2.setPaint(ColorScheme.DARK_GRAY.getColor());
                }
                g2.fill(new Rectangle2D.Double(x, y, iconWidth, iconHeight));
                g2.setPaint(Color.BLACK);
                g2.draw(new Rectangle2D.Double(x, y, iconWidth, iconHeight));
            } catch (IllegalArgumentException e) {
                switch (Player.valueOf(text)) {
                    case PLAYER_1 -> g2.setPaint(ColorScheme.RED.getColor());
                    case PLAYER_2 -> g2.setPaint(ColorScheme.PURPLE.getColor());
                    case PLAYER_3 -> g2.setPaint(ColorScheme.YELLOW.getColor());
                    case PLAYER_4 -> g2.setPaint(ColorScheme.GREEN.getColor());
                    default -> throw e;
                }
                g2.fill(new Ellipse2D.Double(x , y , iconWidth, iconHeight));
                g2.setPaint(Color.BLACK);
                g2.draw(new Ellipse2D.Double(x, y, iconWidth, iconHeight));
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
