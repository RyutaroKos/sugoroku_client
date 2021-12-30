package com.ui.component.dialog;

import com.ui.component.UIKeyword;
import com.ui.component.ComponentFactory;
import com.ui.component.MainFrame;

import javax.swing.*;

public class DialogFactory implements ComponentFactory {
    @Override
    public JDialog getDialog(MainFrame mainFrame, UIKeyword dialogType, Boolean status, String message) {
        return switch (dialogType) {
            case LoginDialog -> new LoginDialog(mainFrame);
            case SignupDialog -> new SignupDialog(mainFrame, status);
            case RequestPrivateMatchDialog -> new RequestPrivateMatchDialog(mainFrame, mainFrame.getMatchingPanel(), message);
            case GameRecordDialog -> new GameRecordDialog(mainFrame, message);
            case ExitLobbyDialog -> new ExitLobbyDialog(mainFrame, mainFrame.getLobbyPanel());
            default -> throw new IllegalArgumentException("Unexpected value: " + dialogType);
        };
    }

    @Override
    public JLabel getLabel(UIKeyword labelType, String label) {
        return null;
    }

    @Override
    public JButton getButton(UIKeyword buttonType, String label) {
        return null;
    }
}
