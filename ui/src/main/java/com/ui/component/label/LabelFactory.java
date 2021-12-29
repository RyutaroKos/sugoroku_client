package com.ui.component.label;

import com.ui.component.UIKeyword;
import com.ui.component.ComponentFactory;
import com.ui.component.MainFrame;

import javax.swing.*;

/**
 * ラベルを生成するためのラベルファクトリークラス。
 * ラベルの配属先によって分類、
 * トップ、マッチング、ロビー、ゲームパネルや、ダイアログなど、
 * 必要に応じて追加可能。
 */

public class LabelFactory implements ComponentFactory {
    @Override
    public JDialog getDialog(MainFrame mainFrame, UIKeyword dialog, Boolean status, String message) {
        return null;
    }

    @Override
    public JLabel getLabel(UIKeyword panel, String label) {
        return switch (panel) {
            case TopPanel -> new TopPanelLabel(label);
            case MatchingPanel -> new MatchingPanelLabel(label);
            case LobbyPanel -> new LobbyPanelLabel();
            case GamePanel -> new GamePanelMapExampleLabel(label);
            default -> null;
        };
    }

    @Override
    public JButton getButton(UIKeyword panel, String label) {
        return null;
    }
}
