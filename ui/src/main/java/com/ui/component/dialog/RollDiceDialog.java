package com.ui.component.dialog;

import com.ui.component.MainFrame;

public class RollDiceDialog extends AppDialog {
    RollDiceDialog(MainFrame mainFrame, int dots) {
        super(mainFrame);
        dialogMessage.setText("サイコロ点数：" + dots);
    }
}
