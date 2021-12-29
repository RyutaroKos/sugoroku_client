package com.ui.component.dialog;

import com.ui.component.UIKeyword;
import com.ui.component.MainFrame;
import com.ui.component.button.ButtonFactory;
import com.ui.scheme.ColorScheme;
import com.ui.scheme.FontScheme;
import com.ui.scheme.LayoutScheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * アプリケーションダイアログを定義するための親ダイアログクラス。
 * 他のダイアログは全部このクラスを継承。
 * デフォルトコンポーネントとして、
 * 1つのメッセージ（JLabel）と2つのボタン（JButton、”はい”、または”いいえ”）を保持。
 * 必要に応じて各子ダイアログクラスでコンポーネントを追加削減や、
 * ボタンのアクションを調整可能。
 */

public class AppDialog extends JDialog {
    JLabel dialogMessage;
    JButton positiveButton;
    JButton negativeButton;
    Container contentPane;
    Container buttonHolder;
    ActionListener disposeDialogListener;

    AppDialog(MainFrame mainFrame) {
        super(mainFrame, true);
        contentPane = getContentPane();
        contentPane.setBackground(ColorScheme.LIGHT_GOLD.getColor());
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(mainFrame);
        contentPane.setLayout(new GridBagLayout());

        dialogMessage = new JLabel();
        dialogMessage.setFont(FontScheme.DIALOG_MESSAGE.getFont());
        dialogMessage.setHorizontalAlignment(SwingConstants.CENTER);
        ButtonFactory buttonFactory = new ButtonFactory();
        positiveButton = buttonFactory.getButton(UIKeyword.Dialog, "はい");
        negativeButton = buttonFactory.getButton(UIKeyword.Dialog, "いいえ");
        disposeDialogListener = actionEvent -> dispose();
        positiveButton.addActionListener(disposeDialogListener);
        negativeButton.addActionListener(disposeDialogListener);
        buttonHolder = new Container();
        buttonHolder.setLayout(new GridLayout(1, 2, 50, 0));
        buttonHolder.add(positiveButton);

        contentPane.add(dialogMessage, LayoutScheme.DIALOG_MESSAGE.getLayout());
        contentPane.add(buttonHolder, LayoutScheme.DIALOG_BUTTONHOLDER.getLayout());
    }
}
