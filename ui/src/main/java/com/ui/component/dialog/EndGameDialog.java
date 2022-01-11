package com.ui.component.dialog;

import com.data.buffer.GameBuffer;
import com.ui.component.MainFrame;

import javax.swing.*;

public class EndGameDialog extends AppDialog {
    EndGameDialog(MainFrame mainFrame, String playerName) {
        super(mainFrame);
        setTitle("ゲーム終了");
        if (playerName.equals(GameBuffer.getInstance().getUsername())) {
            dialogMessage.setText("おめでとう！あなたの勝利！");
        } else {
            dialogMessage.setText("残念．．．あなたの敗北．．．");
        }
    }

    public static JDialog getDialog(MainFrame mainFrame, String playerName) {
        return new EndGameDialog(mainFrame, playerName);
    }
}
