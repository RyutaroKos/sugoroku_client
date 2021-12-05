package com.ui.scheme;

import java.awt.*;

interface innerFontScheme {
    Font getFont();
}

public enum FontScheme implements innerFontScheme {
    DIALOG_MESSAGE {
        @Override
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        }
    },
    DIALOG_BUTTON {
        @Override
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.PLAIN, 20);
        }
    },
    TOP_LABEL {
        @Override
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.BOLD, 20);
        }
    },
    TOP_TEXTFIELD {
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
    },
    LOBBY_BANNER {
        @Override
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.PLAIN, 24);
        }
    },
    LOBBY_BANNER_BUTTON {
        @Override
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.PLAIN, 24);
        }
    },
    LOBBY_BODYPANEL_BUTTON {
        @Override
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.PLAIN, 16);
        }
    },
    LOBBY_BODYPANEL_TITLE {
        @Override
        public Font getFont() {
            return new Font(Font.SANS_SERIF, Font.PLAIN, 32);
        }
    }
}
