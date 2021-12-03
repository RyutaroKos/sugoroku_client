package com.ui.component.dialog;

import com.ui.component.MainFrame;

public class LoginDialog extends GameDialog {
    LoginDialog(MainFrame mainFrame) {
        super(mainFrame);
        dialogMessage.setText("<html>ユーザー名、<br>またはパスワードが間違っています</html>");
    }

    public static LoginDialog getDialog(MainFrame mainFrame) {
        return new LoginDialog(mainFrame);
    }
}
