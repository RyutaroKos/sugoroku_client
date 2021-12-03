package com.ui.component.dialog;

import com.ui.component.MainFrame;

import javax.swing.*;

public class SignupDialog extends GameDialog {
    SignupDialog(MainFrame mainFrame, boolean bool) {
        super(mainFrame);
        if (bool) {
            dialogMessage.setText("ユーザー登録は成功しました");
        } else {
            dialogMessage.setText("同じ名前のユーザーはすでに存在しています");
        }
    }

    public static JDialog getDialog(MainFrame mainFrame, boolean bool) {
        return new SignupDialog(mainFrame, bool);
    }
}
