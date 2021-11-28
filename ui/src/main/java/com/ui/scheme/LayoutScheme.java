package com.ui.scheme;

import java.awt.*;

interface innerLayoutScheme {
    GridBagConstraints getLayout();
}

public enum LayoutScheme implements innerLayoutScheme {
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
            gbc.ipadx = 40;
            gbc.ipady = 30;
            gbc.insets = new Insets(0, 0, 0, 100);
            return gbc;
        }
    },
    TOP_SIGNUPBUTTON {
        @Override
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.ipadx = 40;
            gbc.ipady = 30;
            gbc.insets = new Insets(0, 100, 0, 0);
            return gbc;
        }
    },
    TOP_BUTTONFIELD {
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
    }
}
