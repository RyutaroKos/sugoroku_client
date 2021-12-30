package com.ui.component.label;

import com.ui.scheme.FontScheme;

import javax.swing.*;

public class TopPanelLabel extends JLabel {
    TopPanelLabel(String text) {
        super(text);
        setFont(FontScheme.TOP_LABEL.getFont());
    }
}
