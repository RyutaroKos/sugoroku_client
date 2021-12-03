package com.ui.component.dialog;

import com.ui.component.MainFrame;
import com.ui.component.button.DialogButton;
import com.ui.scheme.ColorScheme;
import com.ui.scheme.FontScheme;
import com.ui.scheme.LayoutScheme;

import javax.swing.*;
import java.awt.*;

public class GameDialog extends JDialog {
    JLabel dialogMessage;
    JButton confirmButton;
    Container container;

    GameDialog(MainFrame mainFrame) {
        super(mainFrame, true);
        container = getContentPane();
        container.setBackground(ColorScheme.LIGHT_GOLD.getColor());
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(mainFrame);
        container.setLayout(new GridBagLayout());

        dialogMessage = new JLabel();
        dialogMessage.setFont(FontScheme.DIALOG_MESSAGE.getFont());
        dialogMessage.setHorizontalAlignment(SwingConstants.CENTER);
        confirmButton = DialogButton.getButton("OK");
        confirmButton.addActionListener(actionEvent -> dispose());
        container.add(dialogMessage, LayoutScheme.DIALOG_MESSAGE.getLayout());
        container.add(confirmButton, LayoutScheme.DIALOG_BUTTON.getLayout());
    }
}
