package com.example.app;

import com.ui.component.MainFrame;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * クライアントのメインクラス
 */

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

        MainFrame mainFrame = MainFrame.getMainFrame(appTitle);
        CommandManager commandManager = new CommandManager(mainFrame);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(commandManager);
        executor.shutdown();
    }
}
