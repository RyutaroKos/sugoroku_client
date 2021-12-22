package com.ui.component.dialog;

import com.ui.component.MainFrame;

public class GameRecordDialog extends AppDialog {
    GameRecordDialog(MainFrame mainFrame, String gameRecord) {
        super(mainFrame);
        dialogMessage.setText(gameRecord);
    }
}
