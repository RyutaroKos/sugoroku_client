package com.ui.component;

import javax.swing.*;

public interface ComponentFactory {
    JLabel getLabel(String panel, String label);
    JButton getButton(String panel, String label);
}
