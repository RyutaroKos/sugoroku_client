package com.ui.scheme;

import java.awt.*;

interface innerLayoutScheme {
    GridBagConstraints getLayout();
}

public enum LayoutScheme implements innerLayoutScheme {
    DIALOG_MESSAGE {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 50, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    DIALOG_BUTTONHOLDER {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    DIALOG_POSITIVEBUTTON {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    DIALOG_NEGATIVEBUTTON {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    TOP_LOGO {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    TOP_NAMELABEL {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 5, 0);
            return gbc;
        }
    },
    TOP_NAMEINPUT {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 5, 0);
            return gbc;
        }
    },
    TOP_PASSWORDLABEL {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            return gbc;
        }
    },
    TOP_PASSWORDINPUT {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            return gbc;
        }
    },
    TOP_INPUTFIELD {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 0, 100, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    TOP_LOGINBUTTON {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 0, 50);
            return gbc;
        }
    },
    TOP_SIGNUPBUTTON {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 50, 0, 0);
            return gbc;
        }
    },
    TOP_BUTTONAREA {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    MATCHING_SCROLLPANEL {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.insets = new Insets(0, 0, 0, 150);
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    MATCHING_BUTTONAREA {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    MATCHING_BUTTON {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            return gbc;
        }
    },
    MATCHING_LABEL {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(10, 0, 0, 0);
            gbc.anchor = GridBagConstraints.NORTHWEST;
            return gbc;
        }
    },
    LOBBY_TOP {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.insets = new Insets(0, 0, 70, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    LOBBY_EXITBUTTON {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridheight = 2;
            gbc.insets = new Insets(0, 15, 0, 0);
            gbc.anchor = GridBagConstraints.WEST;
            return gbc;
        }
    },
    LOBBY_TYPEBANNER {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.insets = new Insets(0, 0, 2, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    LOBBY_IDBANNER {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.insets = new Insets(2, 0, 0, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    LOBBY_STARTBUTTON {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 0;
            gbc.gridheight = 2;
            gbc.insets = new Insets(0, 0, 0, 15);
            gbc.anchor = GridBagConstraints.EAST;
            return gbc;
        }
    },
    LOBBY_PLAYERLIST {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 0, 0, 80);
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    LOBBY_CHATPANEL {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 80, 0, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    LOBBY_BOTTOMPANEL_LABEL {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 20, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    LOBBY_BOTTOMPANEL_TEXTAREA {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 0, 0, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    LOBBY_CHATINPUTFIELD {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.insets = new Insets(10, 20, 0, 20);
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    LOBBY_CHATINPUT {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 0, 6);
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
    LOBBT_SENDCHAT {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    }
}
