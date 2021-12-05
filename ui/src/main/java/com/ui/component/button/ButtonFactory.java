package com.ui.component.button;

import com.ui.component.ComponentFactory;

import javax.swing.*;

public class ButtonFactory implements ComponentFactory {
    @Override
    public JButton getButton(String panel, String label) {
        switch (panel) {
            case "top":
                return new TopPanelButton(label);
            case "matching":
                return new MatchingPanelButton(label);
            case "lobby":
                return new LobbyPanelButton(label);
            case "game":
                return null; //TODO: create GamePanelButton class
            case "dialog":
                return new DialogButton(label);
            default:
                return null;
        }
    }

    @Override
    public JLabel getLabel(String panel, String label) {
        return null;
    }
}
