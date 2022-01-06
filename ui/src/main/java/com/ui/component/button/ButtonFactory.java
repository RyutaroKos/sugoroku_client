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
    	return switch (panel) {
        case "top" -> new TopPanelButton(label);
        case "matching" -> new MatchingPanelButton(label);
        case "lobby" -> new LobbyPanelButton(label);
        case "game" -> null; //TODO: create GamePanelButton class
        case "dialog" -> new DialogButton(label);
        default -> null;
    };
    }

    //ボタンファクトリーであるため、ボタン以外の生成メソッドはnullのまま
    @Override
    public JLabel getLabel(String panel, String label) {
        return null;
    }
}
