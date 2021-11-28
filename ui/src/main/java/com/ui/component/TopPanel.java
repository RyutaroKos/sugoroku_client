package com.ui.component;

import com.ui.scheme.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;

public class TopPanel extends JPanel {
    TopPanel() {
        this.setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        this.setLayout(new GridBagLayout());

        JLabel logo;
        try {
            logo = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("logo.png"))));
            this.add(logo, LayoutScheme.TOP_LOGO.getLayout());
        } catch (Exception e) {
            System.err.println(e);
        }

        JLabel usernameLabel = new JLabel("ユーザー名：");
        usernameLabel.setFont(FontScheme.TOP_INPUTFIELD_KANJI.getFont());
        JTextField usernameInput = new JTextField(10);
        usernameInput.setFont(FontScheme.TOP_INPUTFIELD_ALPHABET.getFont());
        JLabel passwordLabel = new JLabel("パスワード：");
        passwordLabel.setFont(FontScheme.TOP_INPUTFIELD_KANJI.getFont());
        JPasswordField passwordInput = new JPasswordField(10);
        passwordInput.setFont(FontScheme.TOP_INPUTFIELD_ALPHABET.getFont());
        passwordInput.setEchoChar('*');
        Container inputField = new Container();
        inputField.setLayout(new GridBagLayout());
        inputField.add(usernameLabel, LayoutScheme.TOP_NAMELABEL.getLayout());
        inputField.add(usernameInput, LayoutScheme.TOP_NAMEINPUT.getLayout());
        inputField.add(passwordLabel, LayoutScheme.TOP_PASSWORDLABEL.getLayout());
        inputField.add(passwordInput, LayoutScheme.TOP_PASSWORDINPUT.getLayout());
        this.add(inputField, LayoutScheme.TOP_INPUTFIELD.getLayout());

        JButton loginButton = new JButton("ログイン");
        loginButton.setFont(FontScheme.TOP_BUTTONFIELD.getFont());
        loginButton.setBackground(ColorScheme.LIGHT_BRICK.getColor());
        loginButton.addActionListener(new loginAction());
        JButton signupButton = new JButton("初回登録");
        signupButton.setFont(FontScheme.TOP_BUTTONFIELD.getFont());
        signupButton.setBackground(ColorScheme.LIGHT_YELLOW.getColor());
        signupButton.addActionListener(new signupAction());
        Container buttonField = new Container();
        buttonField.setLayout(new GridBagLayout());
        buttonField.add(loginButton, LayoutScheme.TOP_LOGINBUTTON.getLayout());
        buttonField.add(signupButton, LayoutScheme.TOP_SIGNUPBUTTON.getLayout());
        this.add(buttonField, LayoutScheme.TOP_BUTTONFIELD.getLayout());
    }

    class loginAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //TODO: add login action
        }
    }

    class signupAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //TODO: add signup action
        }
    }
}
