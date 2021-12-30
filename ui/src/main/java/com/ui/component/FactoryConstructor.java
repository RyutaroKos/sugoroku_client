package com.ui.component;

import com.ui.component.button.ButtonFactory;
import com.ui.component.dialog.DialogFactory;
import com.ui.component.label.LabelFactory;

/**
 * UI的なコンポーネントを生成するファクトリーを選ぶためのクラス。
 * 現時点での実装：DialogFactory、LabelFactoryとButtonFactory、
 * 検討中の実装：SubComponentFactory
 */

public class FactoryConstructor {
    public static ComponentFactory getFactory(UIKeyword componentType) {
        return switch (componentType) {
            case Dialog -> new DialogFactory();
            case Label -> new LabelFactory();
            case Button -> new ButtonFactory();
            default -> throw new IllegalArgumentException("Unexpected value: " + componentType);
        };
    }
}
