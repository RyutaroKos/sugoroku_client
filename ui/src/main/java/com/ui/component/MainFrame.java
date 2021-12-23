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
    MatchingPanel matchingPanel;
    LobbyPanel lobbyPanel;
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

        setMatchingPanel();
        contentPane.add(matchingPanel); //TODO: under test
        pack();
        setVisible(true);
    }

    public void setMatchingPanel() {
        matchingPanel = new MatchingPanel(this);
    }

    public MatchingPanel getMatchingPanel() {
        return matchingPanel;
    }

    public void setLobbyPanel(String lobbyType, String lobbyID) {
        lobbyPanel = new LobbyPanel(this, lobbyType, lobbyID);
    }

    public LobbyPanel getLobbyPanel() {
        return lobbyPanel;
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
        return new MainFrame(title);
    }
}
