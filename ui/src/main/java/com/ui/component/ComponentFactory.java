package com.ui.component;

import javax.swing.*;

/**
 * コンポーネントファクトリーインターフェイス、
 * 各種類のコンポーネントファクトリーはこのインターフェイスのメソッドを実装。
 * 新種類のコンポーネントファクトリーを追加する場合、
 * このインターフェイスは要拡張。
 */

public interface ComponentFactory {
    JDialog getDialog(MainFrame mainFrame, UIKeyword dialog, Boolean status, String message);
    JLabel getLabel(UIKeyword panel, String label);
    JButton getButton(UIKeyword panel, String label);
}
