package com.ui.component.dialog;

import com.ui.component.MainFrame;

import javax.swing.*;

public class SignupDialog extends AppDialog {
    SignupDialog(MainFrame mainFrame, boolean status) {
        super(mainFrame);
        if (status) {
            setTitle("初回登録成功");
            dialogMessage.setText("ユーザー登録は成功した");
        } else {
            setTitle("初回登録失敗");
            dialogMessage.setText("同じ名前のユーザーはすでに存在している");
        }
    }

    public static JDialog getDialog(MainFrame mainFrame, boolean status) {
        return new SignupDialog(mainFrame, status);
    }
}
