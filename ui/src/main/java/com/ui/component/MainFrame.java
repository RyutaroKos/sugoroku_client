package com.ui.component;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    Container container;
    TopPanel topPanel;
    MatchingPanel matchingPanel;

    MainFrame(String title) {
        super(title);
        setMinimumSize(new Dimension(1280, 960));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        container = getContentPane();
        topPanel = new TopPanel(this);
        matchingPanel = new MatchingPanel(this);

        init();
    }

    public void init() {
        container.add(topPanel);
        setVisible(true);
    }

    public void changePanel(JComponent nextPanel) {
        container.removeAll();
        container.add(nextPanel);
        container.validate();
        container.repaint();
    }

    public static MainFrame createFrame(String title) {
        return new MainFrame(title);
    }
}
