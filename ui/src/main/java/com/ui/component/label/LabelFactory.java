package com.ui.component.label;

import com.ui.component.ComponentFactory;

import javax.swing.*;

public class LabelFactory implements ComponentFactory {
    @Override
    public JLabel getLabel(String panel, String label) {
        switch (panel) {
            case "top":
                return new TopPanelLabel(label);
            case "matching":
                return new MatchingPanelLabel(label);
            case "lobby":
                return new LobbyPanelLabel();
            default:
                return null;
        }
    }

    @Override
    public JButton getButton(String panel, String label) {
        return null;
    }
}
