package com.ui.component.dialog;

import com.ui.component.MainFrame;

import javax.swing.*;

public class GameRecordDialog extends AppDialog {
    GameRecordDialog(MainFrame mainFrame, String gameRecord) {
        super(mainFrame);
        setTitle("戦績確認");
        dialogMessage.setText(gameRecord);
    }

    public static JDialog getDialog(MainFrame mainFrame, String gameRecord) {
        return new GameRecordDialog(mainFrame, gameRecord);
    }
}
