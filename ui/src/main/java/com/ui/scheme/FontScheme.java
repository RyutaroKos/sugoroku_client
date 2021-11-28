package com.ui.scheme;

import java.awt.*;

interface innerFontScheme {
    Font getFont();
}

public enum FontScheme implements innerFontScheme {
    TOP_INPUTFIELD_KANJI {
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.BOLD, 20);
        }
    },
    TOP_INPUTFIELD_ALPHABET {
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.PLAIN, 20);
        }
    },
    TOP_BUTTONFIELD {
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.PLAIN, 36);
        }
    }
}
