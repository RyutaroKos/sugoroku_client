package com.ui.component.dialog;

import com.ui.component.LobbyPanel;
import com.ui.component.MainFrame;

public class ExitLobbyDialog extends AppDialog {
    ExitLobbyDialog(MainFrame mainFrame, LobbyPanel lobbyPanel) {
        super(mainFrame);
        dialogMessage.setText("退室しますか？");
        positiveButton.addActionListener(actionEvent -> {
            lobbyPanel.requestExitLobby();
            mainFrame.changePanel(mainFrame.getMatchingPanel());
        });
        buttonHolder.add(negativeButton);
    }
}
