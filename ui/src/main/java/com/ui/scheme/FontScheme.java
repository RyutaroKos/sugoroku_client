package com.ui.scheme;

import java.awt.*;

interface innerFontScheme {
    Font getFont();
}

public enum FontScheme implements innerFontScheme {
    TOP_INPUTFIELD_KANJI {
        @Override
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.BOLD, 20);
        }
    },
    TOP_INPUTFIELD_ALPHABET {
        @Override
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.PLAIN, 20);
        }
    },
    TOP_BUTTON {
        @Override
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.PLAIN, 36);
        }
    },
    MATCHING_BUTTON {
        @Override
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.PLAIN, 32);
        }
    },
    MATCHING_LABEL {
        @Override
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.PLAIN, 16);
        }
    }
}
