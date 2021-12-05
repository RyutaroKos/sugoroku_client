package com.ui.component;

import javax.swing.*;

public interface ComponentFactory {
    JLabel getLabel(String type, String label);
    JButton getButton(String type, String label);
}
