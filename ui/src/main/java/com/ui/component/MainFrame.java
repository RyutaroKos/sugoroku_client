package com.ui.component;

import javax.swing.*;

public class MainFrame extends JFrame {
    private TopPanel topPanel;

    MainFrame(String title) {
        super(title);
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        topPanel = new TopPanel();
    }

    public void init() {
        this.add(topPanel);
        this.validate();
        this.repaint();
        this.setVisible(true);
    }

    public static MainFrame createFrame(String title) {
        return new MainFrame(title);
    }
}
