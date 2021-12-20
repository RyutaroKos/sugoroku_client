package com.ui.component.dialog;

import com.data.Flag;
import com.data.Request;
import com.data.buffer.RequestBuffer;
import com.ui.component.MainFrame;
import com.ui.scheme.LayoutScheme;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RequestPrivateMatchDialog extends AppDialog {
    MainFrame parentFrame;
    JTextField privateMatchIDField;

    RequestPrivateMatchDialog(MainFrame mainFrame, String label) {
        super(mainFrame);
        dialogMessage.setText(label);
        parentFrame = mainFrame;

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

    private void privateMatch() {
        JSONObject privateMatchRequest = RequestBuffer.getInstance().getRequestObject();
        privateMatchRequest.put(Flag.Request.toString(), Request.PRIVATE_MATCH);
        privateMatchRequest.put(Flag.LobbyID.toString(), privateMatchIDField.getText());
        RequestBuffer.getInstance().registerRequest(privateMatchRequest);
    }

    public static RequestPrivateMatchDialog getDialog(MainFrame mainFrame, String label) {
        return new RequestPrivateMatchDialog(mainFrame, label);
    }

    class requestPrivateMatchAction implements ActionListener {
        //TODO: 実装に合わせて調整する必要ある

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String id = privateMatchIDField.getText();
            privateMatch();
            parentFrame.changePanel(parentFrame.getLobbyPanel("private", id));
        }
    }
}
