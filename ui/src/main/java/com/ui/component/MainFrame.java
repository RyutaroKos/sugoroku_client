package com.ui.component;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    Container container;
    TopPanel topPanel;
    MatchingPanel matchingPanel;

    MainFrame(String title) {
        super(title);
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        container = this.getContentPane();
        topPanel = new TopPanel(this);
        matchingPanel = new MatchingPanel(this);
    }

    public void init() {
        container.add(topPanel);
        container.validate();
        container.repaint();
        container.setVisible(true);
    }

    public void changePanel(JPanel nextPanel) {
        container.removeAll();
        container.add(nextPanel);
        container.validate();
        container.repaint();
    }

    public static MainFrame createFrame(String title) {
        return new MainFrame(title);
    }
}
