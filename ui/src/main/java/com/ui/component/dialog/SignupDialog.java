package com.ui.component.dialog;

import com.ui.component.MainFrame;

public class SignupDialog extends AppDialog {
    SignupDialog(MainFrame mainFrame, boolean bool) {
        super(mainFrame);
        if (bool) {
            dialogMessage.setText("ユーザー登録は成功しました");
        } else {
            dialogMessage.setText("同じ名前のユーザーはすでに存在しています");
        }
    }
}
