package com.ui.component.subcomponent;

import com.ui.scheme.ColorScheme;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GamePanelMap extends JPanel {
    private final MapGrid[][] mapGrids = {
            {MapGrid.BLANK, MapGrid.BLANK, MapGrid.CROSSROAD, MapGrid.BLANK, MapGrid.FORWARD, MapGrid.NULL, MapGrid.BACKWARD, MapGrid.BACKWARD, MapGrid.RENDEZVOUS, MapGrid.BLANK, MapGrid.ALL_GET_ITEM, MapGrid.NULL, MapGrid.GOAL},
            {MapGrid.BLANK, MapGrid.NULL, MapGrid.GET_ITEM, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.FORWARD, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.FORWARD, MapGrid.NULL, MapGrid.BLANK},
            {MapGrid.GET_ITEM, MapGrid.NULL, MapGrid.GET_ITEM, MapGrid.NULL, MapGrid.GET_ITEM, MapGrid.NULL, MapGrid.FORWARD, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.BLANK},
            {MapGrid.BLANK, MapGrid.NULL, MapGrid.GET_ITEM, MapGrid.NULL, MapGrid.FORWARD, MapGrid.NULL, MapGrid.BACKWARD, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.BACKWARD, MapGrid.NULL, MapGrid.BACKWARD},
            {MapGrid.BLANK, MapGrid.NULL, MapGrid.GET_ITEM, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.FORWARD, MapGrid.NULL, MapGrid.ALL_LOSE_ITEM, MapGrid.NULL, MapGrid.GET_ITEM, MapGrid.NULL, MapGrid.BLANK},
            {MapGrid.BLANK, MapGrid.NULL, MapGrid.RESTART, MapGrid.NULL, MapGrid.BACKWARD, MapGrid.NULL, MapGrid.BACKWARD, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.FORWARD, MapGrid.NULL, MapGrid.FORWARD},
            {MapGrid.BLANK, MapGrid.NULL, MapGrid.RESTART, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.BACKWARD, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.BLANK},
            {MapGrid.GET_ITEM, MapGrid.NULL, MapGrid.RESTART, MapGrid.NULL, MapGrid.FORWARD, MapGrid.NULL, MapGrid.FORWARD, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.BLANK},
            {MapGrid.BLANK, MapGrid.NULL, MapGrid.GET_ITEM, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.FORWARD, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.FORWARD, MapGrid.NULL, MapGrid.FORWARD},
            {MapGrid.BLANK, MapGrid.NULL, MapGrid.GET_ITEM, MapGrid.NULL, MapGrid.BACKWARD, MapGrid.NULL, MapGrid.BACKWARD, MapGrid.NULL, MapGrid.ALL_LOSE_ITEM, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.ALL_LOSE_ITEM},
            {MapGrid.BLANK, MapGrid.NULL, MapGrid.ALL_LOSE_ITEM, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.BACKWARD, MapGrid.NULL, MapGrid.BLANK, MapGrid.NULL, MapGrid.BACKWARD, MapGrid.NULL, MapGrid.BLANK},
            {MapGrid.START, MapGrid.NULL, MapGrid.GET_ITEM, MapGrid.GET_ITEM, MapGrid.RENDEZVOUS, MapGrid.ALL_GET_ITEM, MapGrid.CROSSROAD, MapGrid.BLANK, MapGrid.BLANK, MapGrid.NULL, MapGrid.GET_ITEM, MapGrid.BLANK, MapGrid.GET_ITEM}
    };
    private final int gridWidth = 60;
    private final int gridHeight = 60;
    private final GamePanelPiece[] pieces;

    public GamePanelMap() {
        setPreferredSize(new Dimension(781, 721));
        setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        pieces = new GamePanelPiece[Player.values().length];
        for (int i = 0; i < Player.values().length; i++) {
            pieces[i] = new GamePanelPiece(i, gridWidth, gridHeight);
        }
    }

    public void moveUp(int i) {
        pieces[i].Y--;
    }

    public void moveDown(int i) {
        pieces[i].Y++;
    }

    public void moveLeft(int i) {
        pieces[i].X--;
    }

    public void moveRight(int i) {
        pieces[i].X++;
    }

    public void moveForward(int i) {
        switch (pieces[i].X) {
            case 0, 6, 8, 12 -> {
                if (pieces[i].Y == 0) {
                    moveRight(i);
                } else if (pieces[i].keepDirection) {
                    moveRight(i);
                    pieces[i].keepDirection = false;
                } else {
                    moveUp(i);
                }
            }
            case 2, 4, 10 -> {
                if (pieces[i].Y == 11) {
                    moveRight(i);
                } else if (pieces[i].keepDirection) {
                    moveRight(i);
                    pieces[i].keepDirection = false;
                } else {
                    moveDown(i);
                }
            }
            case 1, 3, 5, 7, 9, 11 -> moveRight(i);
        }
        repaint();
    }

    public void moveBackward(int i) {
        switch (pieces[i].X) {
            case 4, 10 -> moveUp(i);
            case 6, 12 -> moveDown(i);
            case 7 -> moveLeft(i);
        }
        repaint();
    }

    public void backToStart(int i) {
        pieces[i].X = 0;
        pieces[i].Y = 11;
        repaint();
    }

    public void setKeepDirection(int i) {
        pieces[i].keepDirection = true;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        final int row = mapGrids.length; //Y axis grid number
        final int column = mapGrids[0].length; //X axis grid number
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mapGrids[i][j] != MapGrid.NULL) {
                    switch (mapGrids[i][j]) {
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
                    g2.fill(new Rectangle2D.Double(j * gridWidth, i * gridHeight, gridWidth, gridHeight));
                    g2.setPaint(Color.BLACK);
                    g2.draw(new Rectangle2D.Double(j * gridWidth, i * gridHeight, gridWidth, gridHeight));
                }
            }
        }
        for (GamePanelPiece piece : pieces) {
            g2.setPaint(piece.getColor());
            g2.fill(piece.getShape());
            g2.setPaint(Color.BLACK);
            g2.draw(piece.getShape());
        }
    }
}
