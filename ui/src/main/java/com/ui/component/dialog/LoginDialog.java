package com.ui.component.dialog;

import com.ui.component.MainFrame;

public class LoginDialog extends AppDialog {
    LoginDialog(MainFrame mainFrame) {
        super(mainFrame);
        dialogMessage.setText("<html>ユーザー名、<br>またはパスワードが間違っています</html>");
    }
}
