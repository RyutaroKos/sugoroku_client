package com.ui.component.dialog;

import com.ui.component.MainFrame;

import javax.swing.*;
import java.util.Objects;

public class RollDiceDialog extends AppDialog {
    RollDiceDialog(MainFrame mainFrame, int dots) {
        super(mainFrame);
        setTitle("サイコロの出目");
        switch (dots) {
            case 1 -> dialogMessage.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("dice-1.png"))));
            case 2 -> dialogMessage.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("dice-2.png"))));
            case 3 -> dialogMessage.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("dice-3.png"))));
            case 4 -> dialogMessage.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("dice-4.png"))));
            case 5 -> dialogMessage.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("dice-5.png"))));
            case 6 -> dialogMessage.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("dice-6.png"))));
            default -> dialogMessage.setText("Large than 6.");
        }
    }

    public static JDialog getDialog(MainFrame mainFrame, int dots) {
        return new RollDiceDialog(mainFrame, dots);
    }
}
