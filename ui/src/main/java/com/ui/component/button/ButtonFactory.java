package com.ui.component.button;

import com.ui.component.ComponentFactory;

import javax.swing.*;

/**
 * ボタンを生成するためのボタンファクトリークラス。
 * ボタンの配属先によって分類、
 * トップ、マッチング、ロビー、ゲームパネルや、ダイアログなど、
 * 必要に応じて追加可能。
 */

public class ButtonFactory implements ComponentFactory {
    @Override
    public JButton getButton(String panel, String label) {
        switch (panel) {
            case "top":
                return new TopPanelButton(label);
            case "matching":
                return new MatchingPanelButton(label);
            case "lobby":
                return new LobbyPanelButton(label);
            case "game": return null; //TODO: ゲームパネルボタンクラスの作成が必要
            case "dialog": return new DialogButton(label);
            default: return null;
        }
    }

    //ボタンファクトリーであるため、ボタン以外の生成メソッドはnullのまま
    @Override
    public JLabel getLabel(String panel, String label) {
        return null;
    }
}
