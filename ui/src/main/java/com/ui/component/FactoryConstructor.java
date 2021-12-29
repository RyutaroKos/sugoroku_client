package com.ui.component;

import com.ui.component.button.ButtonFactory;
import com.ui.component.dialog.DialogFactory;
import com.ui.component.label.LabelFactory;

/**
 * UI的なコンポーネントを生成するファクトリーを選ぶためのクラス。
 * 現時点での実装：ラベルファクトリー、ボタンファクトリー。
 * 後ほど追加可能：ダイアログファクトリーなど。
 */

public class FactoryConstructor {
    public static ComponentFactory getFactory(UIKeyword uiKeyword) {
        return switch (uiKeyword) {
            case Dialog -> new DialogFactory();
            case Label -> new LabelFactory();
            case Button -> new ButtonFactory();
            default -> null;
        };
    }
}
