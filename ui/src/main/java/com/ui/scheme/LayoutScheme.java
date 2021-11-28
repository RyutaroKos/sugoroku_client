package com.ui.scheme;

import java.awt.*;

interface innerLayoutScheme {
    GridBagConstraints getLayout();
}

public enum LayoutScheme implements innerLayoutScheme {
    TOP_LOGO {
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
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 5, 0);
            return gbc;
        }
    },
    TOP_NAMEINPUT {
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 5, 0);
            return gbc;
        }
    },
    TOP_PASSWORDLABEL {
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            return gbc;
        }
    },
    TOP_PASSWORDINPUT {
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            return gbc;
        }
    },
    TOP_INPUTFIELD {
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
        public GridBagConstraints getLayout() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            return gbc;
        }
    },
}
