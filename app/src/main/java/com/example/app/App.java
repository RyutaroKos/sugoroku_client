package com.example.app;

import com.ui.component.MainFrame;

import javax.swing.*;

public class App {
    private static final String appTitle = "Sugoroku";

    public static void main(String[] args) {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Nimbus look and feel not found, using default look and feel instead.");
        }

        MainFrame.createFrame(appTitle);

        System.out.println("This is the main branch.");
        System.out.println("This is the main content.");
        System.out.println("This is the test branch.");
        System.exit(0);
    }
}
