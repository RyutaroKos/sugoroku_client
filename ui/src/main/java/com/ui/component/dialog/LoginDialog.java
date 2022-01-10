package com.ui.component.dialog;

import com.ui.component.MainFrame;

import javax.swing.*;

public class LoginDialog extends AppDialog {
    LoginDialog(MainFrame mainFrame) {
        super(mainFrame);
        setTitle("ログイン失敗");
        dialogMessage.setText("<html>ユーザー名、<br>またはパスワードが間違っている</html>");
    }

    public static JDialog getDialog(MainFrame mainFrame) {
        return new LoginDialog(mainFrame);
    }
}
