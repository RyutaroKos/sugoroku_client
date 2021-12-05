package com.ui.component;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    Container contentPane;
    TopPanel topPanel;
    MatchingPanel matchingPanel;

    MainFrame(String title) {
        super(title);
        setMinimumSize(new Dimension(1280, 960));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        contentPane = getContentPane();
        topPanel = new TopPanel(this);
        matchingPanel = new MatchingPanel(this);

        init();
    }

    public void init() {
        contentPane.add(topPanel);
        pack();
        setVisible(true);
    }

    public MatchingPanel getMatchingPanel() {
        return matchingPanel;
    }

    public void changePanel(JPanel nextPanel) {
        contentPane.removeAll();
        contentPane.add(nextPanel);
        contentPane.validate();
        contentPane.repaint();
    }

    public static MainFrame createFrame(String title) {
        return new MainFrame(title);
    }
}
