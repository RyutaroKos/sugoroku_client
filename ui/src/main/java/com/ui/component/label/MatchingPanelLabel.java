package com.ui.component.label;

import com.ui.scheme.FontScheme;

import javax.swing.*;

public class MatchingPanelLabel extends JLabel {
    MatchingPanelLabel(String label) {
        super(label);
        setFont(FontScheme.MATCHING_LABEL.getFont());
    }
}
