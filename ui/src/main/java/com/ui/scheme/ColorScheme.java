package com.ui.scheme;

import java.awt.*;

/**
 * 色をピックアップするためのライブラリクラス。
 * 必要に応じて追加可能。
 */

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
    LIGHT_GREEN {
        @Override
        public Color getColor() {
            return new Color(226, 240, 217);
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
    },
    LIGHT_GRAY {
        @Override
        public Color getColor() {
            return new Color(238, 238, 238);
        }
    },
    RED {
        @Override
        public Color getColor() {
            return new Color(255, 109, 109);
        }
    },
    YELLOW {
        @Override
        public Color getColor() {
            return new Color(255, 255, 109);
        }
    },
    GREEN {
        @Override
        public Color getColor() {
            return new Color(119, 188, 101);
        }
    },
    GOLD {
        @Override
        public Color getColor() {
            return new Color(255, 212, 40);
        }
    },
    PURPLE {
        @Override
        public Color getColor() {
            return new Color(161, 70, 126);
        }
    },
    INDIGO {
        @Override
        public Color getColor() {
            return new Color(142, 134, 174);
        }
    },
    DARK_BLUE {
        @Override
        public Color getColor() {
            return new Color(0, 112, 192);
        }
    },
    DARK_RED {
        @Override
        public Color getColor() {
            return new Color(241, 13, 12);
        }
    },
    DARK_GREEN {
        @Override
        public Color getColor() {
            return new Color(84, 130, 53);
        }
    },
    DARK_GRAY {
        @Override
        public Color getColor() {
            return new Color(51, 51, 51);
        }
    }
}
