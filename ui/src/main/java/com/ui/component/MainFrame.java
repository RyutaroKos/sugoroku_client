package com.ui.component;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * クライアントの画面を管理するクラス：メインフレーム、
 * デスクトップアプリケーションのウィンドウに相当、
 * メインフレームを閉じる時点でプログラムは終了。
 * すべてのパネルや、ダイアログはメインフレームに依存。
 */

public class MainFrame extends JFrame {
    Container contentPane;

    MainFrame(String title) {
        super(title);
        setMinimumSize(new Dimension(1280, 960)); //画面の最小サイズを制限、画面内のコンポーネントが崩れた場合ここを拡大
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon.png"))).getImage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        contentPane = getContentPane();

        contentPane.add(new TopPanel(this));
        pack();
        setVisible(true);
    }

    public MatchingPanel getMatchingPanel() {
        return new MatchingPanel(this);
    }

    public LobbyPanel getLobbyPanel(String lobbyType, String lobbyID) {
        return new LobbyPanel(this, lobbyType, lobbyID);
    }

    public GamePanel getGamePanel() {
        return null; //TODO: ゲームパネルクラス完成後は要修正
    }

    public void changePanel(JPanel nextPanel) {
        contentPane.removeAll();
        contentPane.add(nextPanel);
        contentPane.validate(); //repaint()の前は必ずvalidate()
        contentPane.repaint();
    }

    public static MainFrame getMainFrame(String title) {
        return new MainFrame(title); //return値は要検討
    }
}
