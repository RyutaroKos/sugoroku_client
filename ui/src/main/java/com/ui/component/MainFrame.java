package com.ui.component;

import javax.swing.*;

public class MainFrame extends JFrame {
    private TopPanel topPanel;

    MainFrame(String title) {
        super(title);
        this.setVisible(true);
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.topPanel = new TopPanel();
    }

    public void init() {
        this.add(this.topPanel);
        this.validate();
        this.repaint();
    }

    public static MainFrame createFrame(String title) {
        return new MainFrame(title);
    }
}
