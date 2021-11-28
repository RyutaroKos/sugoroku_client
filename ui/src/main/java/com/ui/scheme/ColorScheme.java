package com.ui.scheme;

import java.awt.*;

interface innerColorScheme {
    Color getColor();
}

public enum ColorScheme implements innerColorScheme {
    LIGHT_ORANGE {
        public Color getColor() {
            return new Color(255, 219, 182);
        }
    },
    LIGHT_BRICK {
        public Color getColor() {
            return new Color(255, 170, 149);
        }
    },
    LIGHT_YELLOW {
        public Color getColor() {
            return new Color(255, 255, 166);
        }
    }
}
