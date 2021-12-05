package com.ui.component.dialog;

import com.ui.component.MainFrame;
import com.ui.component.button.ButtonFactory;
import com.ui.scheme.ColorScheme;
import com.ui.scheme.FontScheme;
import com.ui.scheme.LayoutScheme;

import javax.swing.*;
import java.awt.*;

public class AppDialog extends JDialog {
    JLabel dialogMessage;
    JButton positiveButton;
    JButton negativeButton;
    Container contentPane;
    Container buttonHolder;

    AppDialog(MainFrame mainFrame) {
        super(mainFrame, true);
        contentPane = getContentPane();
        contentPane.setBackground(ColorScheme.LIGHT_GOLD.getColor());
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(mainFrame);
        contentPane.setLayout(new GridBagLayout());

        dialogMessage = new JLabel();
        dialogMessage.setFont(FontScheme.DIALOG_MESSAGE.getFont());
        dialogMessage.setHorizontalAlignment(SwingConstants.CENTER);
        ButtonFactory buttonFactory = new ButtonFactory();
        positiveButton = buttonFactory.getButton("dialog", "はい");
        negativeButton = buttonFactory.getButton("dialog", "いいえ");
        positiveButton.addActionListener(actionEvent -> dispose());
        negativeButton.addActionListener(actionEvent -> dispose());
        buttonHolder = new Container();
        buttonHolder.setLayout(new GridLayout(1, 2, 50, 0));
        buttonHolder.add(positiveButton);

        contentPane.add(dialogMessage, LayoutScheme.DIALOG_MESSAGE.getLayout());
        contentPane.add(buttonHolder, LayoutScheme.DIALOG_BUTTONHOLDER.getLayout());
    }
}
