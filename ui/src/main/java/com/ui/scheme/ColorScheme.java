package com.ui.scheme;

import java.awt.*;

interface innerColorScheme {
    Color getColor();
}

public enum ColorScheme implements innerColorScheme {
    LIGHT_ORANGE {
        @Override
        public Color getColor() {
            return new Color(255, 219, 182);
        }
    },
    LIGHT_BRICK {
        @Override
        public Color getColor() {
            return new Color(255, 170, 149);
        }
    },
    LIGHT_YELLOW {
        @Override
        public Color getColor() {
            return new Color(255, 255, 166);
        }
    },
    LIGHT_GOLD {
        @Override
        public Color getColor() {
            return new Color(255, 245, 206);
        }
    },
    LIGHT_RED {
        @Override
        public Color getColor() {
            return new Color(255, 215, 215);
        }
    },
    LIGHT_BLUE {
        @Override
        public Color getColor() {
            return new Color(222, 230, 239);
        }
    },
    LIGHT_INDIGO {
        @Override
        public Color getColor() {
            return new Color(222, 220, 230);
        }
    }
}
