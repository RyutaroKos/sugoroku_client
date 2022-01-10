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
    public JLabel getLabel(UIKeyword labelType, String text) {
        return switch (labelType) {
            case TopPanelLabel -> new TopPanelLabel(text);
            case MatchingPanelLabel -> new MatchingPanelLabel(text);
            case LobbyPanelLabel -> new LobbyPanelLabel();
            case GamePanelMapLabel -> new GamePanelMapLabel(text);
            case GamePanelMapExampleLabel -> new GamePanelMapExampleLabel(text);
            default -> throw new IllegalArgumentException("Unexpected value: " + labelType);
        };
    }

    @Override
    public JButton getButton(UIKeyword buttonType, String label) {
        return null;
    }
}
