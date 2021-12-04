package com.ui.component.dialog;

import com.ui.component.MainFrame;

public class GameRecordDialog extends AppDialog {
    GameRecordDialog(MainFrame mainFrame, String str) {
        super(mainFrame);
        dialogMessage.setText(str);
    }

    public static GameRecordDialog getDialog(MainFrame mainFrame, String str) {
        return new GameRecordDialog(mainFrame, str);
    }
}
