package com.ui.component.label;

import com.ui.component.ComponentFactory;

import javax.swing.*;

public class LabelFactory implements ComponentFactory {
    @Override
    public JLabel getLabel(String type, String label) {
        switch (type) {
            case "top":
                return new TopPanelLabel(label);
            case "matching":
                return new MatchingPanelLabel(label);
        }
        return null;
    }

    @Override
    public JButton getButton(String type, String label) {
        return null;
    }
}
