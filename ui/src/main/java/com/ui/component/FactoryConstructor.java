package com.ui.component;

import com.ui.component.button.ButtonFactory;
import com.ui.component.label.LabelFactory;

/**
 * UI的なコンポーネントを生成するファクトリーを選ぶためのクラス。
 * 現時点での実装：ラベルファクトリー、ボタンファクトリー。
 * 後ほど追加可能：ダイアログファクトリーなど。
 */

public class FactoryConstructor {
    protected static ComponentFactory getFactory(String type) throws FactoryNotDefinedException {
        switch (type) {
            case "label":
                return new LabelFactory();
            case "button":
                return new ButtonFactory();
            default:
                throw new FactoryNotDefinedException();
        }
    }

    public static class FactoryNotDefinedException extends Exception {
        FactoryNotDefinedException() {
            super();
        }
    }
}
