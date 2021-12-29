package com.ui.component.subcomponent;

import com.ui.scheme.ColorScheme;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class GamePanelPiece {
    int X;
    int Y;
    int index;
    boolean keepDirection;

    public GamePanelPiece(int i) {
        X = 0;
        Y = 11;
        index = i;
        keepDirection = false;
    }

    Color getColor() {
        return switch (index) {
            case 0 -> ColorScheme.RED.getColor();
            case 1 -> ColorScheme.PURPLE.getColor();
            case 2 -> ColorScheme.YELLOW.getColor();
            case 3 -> ColorScheme.GREEN.getColor();
            default -> throw new IllegalStateException("Unexpected value: " + index);
        };
    }

    Shape getShape() {
        return switch (index) {
            case 0 -> new Ellipse2D.Double(5 + X * 60, 5 + Y * 60, 20, 20);
            case 1 -> new Ellipse2D.Double(35 + X * 60, 5 + Y * 60, 20, 20);
            case 2 -> new Ellipse2D.Double(5 + X * 60, 35 + Y * 60, 20, 20);
            case 3 -> new Ellipse2D.Double(35 + X * 60, 35 + Y * 60, 20, 20);
            default -> throw new IllegalStateException("Unexpected value: " + index);
        };
    }
}
