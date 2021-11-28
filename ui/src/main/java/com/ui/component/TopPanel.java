package com.ui.component;

import com.ui.scheme.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

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
    Container buttonField;

    TopPanel(MainFrame parentFrame) {
        this.setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        this.setLayout(new GridBagLayout());

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
        loginButton = new JButton("ログイン");
        signupButton = new JButton("初回登録");
        inputField = new Container();
        buttonField = new Container();

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
        this.add(inputField, LayoutScheme.TOP_INPUTFIELD.getLayout());

        loginButton.setFont(FontScheme.TOP_BUTTONFIELD.getFont());
        loginButton.setBackground(ColorScheme.LIGHT_BRICK.getColor());
        loginButton.addActionListener(new loginAction());
        signupButton.setFont(FontScheme.TOP_BUTTONFIELD.getFont());
        signupButton.setBackground(ColorScheme.LIGHT_YELLOW.getColor());
        signupButton.addActionListener(new signupAction());

        buttonField.setLayout(new GridBagLayout());
        buttonField.add(loginButton, LayoutScheme.TOP_LOGINBUTTON.getLayout());
        buttonField.add(signupButton, LayoutScheme.TOP_SIGNUPBUTTON.getLayout());
        this.add(buttonField, LayoutScheme.TOP_BUTTONFIELD.getLayout());
    }

    class loginAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //TODO: add login action

            parentFrame.changePanel(parentFrame.matchingPanel);
        }
    }

    class signupAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //TODO: add signup action
        }
    }
}
