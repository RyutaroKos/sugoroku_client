package com.ui.component;

import javax.swing.*;

/**
 * コンポーネントファクトリーインターフェイス、
 * 各種類のコンポーネントファクトリーはこのインターフェイスのメソッドを実装。
 * 新種類のコンポーネントファクトリーを追加する場合、
 * このインターフェイスは要拡張。
 */

public interface ComponentFactory {
    JLabel getLabel(UIKeyword labelType, String text);
    JButton getButton(UIKeyword buttonType, String text);
}
