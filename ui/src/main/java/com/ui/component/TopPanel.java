package com.ui.component;

import com.ui.component.dialog.LoginDialog;
import com.ui.component.dialog.SignupDialog;
import com.ui.scheme.*;
import com.ui.component.button.TopPanelButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TopPanel extends JPanel {
    MainFrame parentFrame;
    JLabel logo;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JTextField usernameInput;
    JPasswordField passwordInput;
    JButton loginButton;
    JButton signupButton;
    Container inputField;
    Container buttonArea;

    TopPanel(MainFrame parentFrame) {
        setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        setLayout(new GridBagLayout());

        this.parentFrame = parentFrame;

        try {
            logo = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("logo.png"))));
            this.add(logo, LayoutScheme.TOP_LOGO.getLayout());
        } catch (Exception e) {
            System.err.println("Failed to load logo: " + e);
        }

        usernameLabel = new JLabel("ユーザー名：");
        passwordLabel = new JLabel("パスワード：");
        usernameInput = new JTextField(10);
        passwordInput = new JPasswordField(10);
        loginButton = TopPanelButton.getButton("ログイン");
        signupButton = TopPanelButton.getButton("初回登録");
        inputField = new Container();
        buttonArea = new Container();

        usernameLabel.setFont(FontScheme.TOP_INPUTFIELD_KANJI.getFont());
        passwordLabel.setFont(FontScheme.TOP_INPUTFIELD_KANJI.getFont());
        usernameInput.setFont(FontScheme.TOP_INPUTFIELD_ALPHABET.getFont());
        passwordInput.setFont(FontScheme.TOP_INPUTFIELD_ALPHABET.getFont());
        passwordInput.setEchoChar('*');

        inputField.setLayout(new GridBagLayout());
        inputField.add(usernameLabel, LayoutScheme.TOP_NAMELABEL.getLayout());
        inputField.add(usernameInput, LayoutScheme.TOP_NAMEINPUT.getLayout());
        inputField.add(passwordLabel, LayoutScheme.TOP_PASSWORDLABEL.getLayout());
        inputField.add(passwordInput, LayoutScheme.TOP_PASSWORDINPUT.getLayout());
        add(inputField, LayoutScheme.TOP_INPUTFIELD.getLayout());

        loginButton.addActionListener(new loginAction());
        signupButton.addActionListener(new signupAction());

        buttonArea.setLayout(new GridBagLayout());
        buttonArea.add(loginButton, LayoutScheme.TOP_LOGINBUTTON.getLayout());
        buttonArea.add(signupButton, LayoutScheme.TOP_SIGNUPBUTTON.getLayout());
        add(buttonArea, LayoutScheme.TOP_BUTTONAREA.getLayout());
    }

    class loginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: add login action

            if (false) {
                LoginDialog.getDialog(parentFrame).setVisible(true);
            } else {
                parentFrame.changePanel(parentFrame.matchingPanel);
            }
        }
    }

    class signupAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: add signup action

            SignupDialog.getDialog(parentFrame, false).setVisible(true);
        }
    }
}
