package com.ui.component.subcomponent;

import com.ui.scheme.ColorScheme;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class GamePanelPiece {
    int X; //grid X
    int Y; //grid Y
    int index;
    int gridWidth;
    int gridHeight;
    boolean keepDirection;

    public GamePanelPiece(int i, int width, int height) {
        X = 0;
        Y = 11;
        index = i;
        gridWidth = width;
        gridHeight = height;
        keepDirection = false;
    }

    Color getColor() {
        return switch (index) {
            case 0 -> ColorScheme.RED.getColor(); //player 1
            case 1 -> ColorScheme.PURPLE.getColor(); //player 2
            case 2 -> ColorScheme.YELLOW.getColor(); //player 3
            case 3 -> ColorScheme.GREEN.getColor(); //player 4
            default -> throw new IllegalStateException("Unexpected value: " + index);
        };
    }

    Shape getShape() {
        return switch (index) { //inside single grid
            case 0 -> new Ellipse2D.Double(5 + X * gridWidth, 5 + Y * gridHeight, 20, 20); //left top corner
            case 1 -> new Ellipse2D.Double(35 + X * gridWidth, 5 + Y * gridHeight, 20, 20); //right top corner
            case 2 -> new Ellipse2D.Double(5 + X * gridWidth, 35 + Y * gridHeight, 20, 20); //left bottom corner
            case 3 -> new Ellipse2D.Double(35 + X * gridWidth, 35 + Y * gridHeight, 20, 20); //right bottom corner
            default -> throw new IllegalStateException("Unexpected value: " + index);
        };
    }
}
