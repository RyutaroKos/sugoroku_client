package com.ui.component.label;

import com.ui.scheme.*;

import javax.swing.*;

public class MatchingPanelLabel extends JLabel {
    MatchingPanelLabel(String string) {
        super(string);
        this.setFont(FontScheme.MATCHING_LABEL.getFont());
    }

    public static MatchingPanelLabel getLabel(String string) {
        return new MatchingPanelLabel(string);
    }
}
