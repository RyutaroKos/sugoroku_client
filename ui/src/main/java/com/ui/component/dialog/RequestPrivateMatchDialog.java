package com.ui.component.dialog;

import com.ui.component.MainFrame;
import com.ui.component.MatchingPanel;
import com.ui.scheme.LayoutScheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RequestPrivateMatchDialog extends AppDialog {
    MainFrame parentFrame;
    MatchingPanel parentPanel;
    JTextField privateMatchIDField;

    RequestPrivateMatchDialog(MainFrame mainFrame, MatchingPanel matchingPanel, String label) {
        super(mainFrame);
        dialogMessage.setText(label);
        parentFrame = mainFrame;
        parentPanel = matchingPanel;

        privateMatchIDField = new JTextField(10);
        privateMatchIDField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        privateMatchIDField.setHorizontalAlignment(JTextField.CENTER);
        privateMatchIDField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isAlphabetic(e.getKeyChar())
                    && !Character.isDigit(e.getKeyChar())
                    || privateMatchIDField.getText().length() >= 4) {
                    e.consume(); //IDの長さ上限は4
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                positiveButton.setEnabled(privateMatchIDField.getText().length() > 3); //IDの長さが4より短い場合、確認ボタンを無効化
            }
        });
        positiveButton.setEnabled(false); //確認ボタンの初期化（無効）
        positiveButton.addActionListener(new requestPrivateMatchAction());
        contentPane.add(privateMatchIDField, LayoutScheme.DIALOG_TEXTFIELD.getLayout());
    }

    public static RequestPrivateMatchDialog getDialog(MainFrame mainFrame, MatchingPanel matchingPanel, String label) {
        return new RequestPrivateMatchDialog(mainFrame, matchingPanel, label);
    }

    class requestPrivateMatchAction implements ActionListener {
        //TODO: 実装に合わせて調整する必要ある

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String id = privateMatchIDField.getText();
            parentPanel.privateMatch(id);
            parentFrame.changePanel(parentFrame.getLobbyPanel("private", id));
        }
    }
}
