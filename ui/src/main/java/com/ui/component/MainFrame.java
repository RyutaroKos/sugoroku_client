package com.ui.component;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    private Container container;
    private TopPanel topPanel;

    MainFrame(String title) {
        super(title);
        this.setVisible(true);
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.container = getContentPane();
        this.topPanel = new TopPanel();
    }

    public void init() {
        this.container.add(this.topPanel);
        this.container.validate();
        this.container.repaint();
    }

    public static MainFrame createFrame(String title) {
        return new MainFrame(title);
    }
}
