package com.ui.component.dialog;

import com.ui.component.LobbyPanel;
import com.ui.component.MainFrame;

import javax.swing.*;

public class ExitLobbyDialog extends AppDialog {
    ExitLobbyDialog(MainFrame mainFrame, LobbyPanel lobbyPanel) {
        super(mainFrame);
        setTitle("退室確認");
        dialogMessage.setText("このロビーから退室する？");
        positiveButton.addActionListener(actionEvent -> {
            lobbyPanel.requestExitLobby();
            mainFrame.changePanel(mainFrame.getMatchingPanel());
        });
        buttonHolder.add(negativeButton);
    }

    public static JDialog getDialog(MainFrame mainFrame, LobbyPanel lobbyPanel) {
        return new ExitLobbyDialog(mainFrame, lobbyPanel);
    }
}
