package com.ui.component.button;

import com.ui.component.UIKeyword;
import com.ui.component.ComponentFactory;
import com.ui.component.MainFrame;

import javax.swing.*;

/**
 * ボタンを生成するためのボタンファクトリークラス。
 * ボタンの配属先によって分類、
 * トップ、マッチング、ロビー、ゲームパネルや、ダイアログなど、
 * 必要に応じて追加可能。
 */

public class ButtonFactory implements ComponentFactory {
    @Override
    public JDialog getDialog(MainFrame mainFrame, UIKeyword dialog, Boolean status, String message) {
        return null;
    }

    @Override
    public JLabel getLabel(UIKeyword panel, String label) {
        return null;
    }

    @Override
    public JButton getButton(UIKeyword panel, String label) {
        return switch (panel) {
            case TopPanel -> new TopPanelButton(label);
            case MatchingPanel -> new MatchingPanelButton(label);
            case LobbyPanel -> new LobbyPanelButton(label);
            case GamePanel -> null; //TODO: ゲームパネルボタンクラスの作成が必要
            case Dialog -> new DialogButton(label);
            default -> null;
        };
    }
}
