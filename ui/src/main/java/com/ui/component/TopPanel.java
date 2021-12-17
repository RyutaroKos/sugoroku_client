package com.ui.component;

import com.ui.component.dialog.LoginDialog;
import com.ui.component.dialog.SignupDialog;
import com.ui.scheme.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * クライアント起動後の最初画面：トップパネル
 */

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
    Container buttonHolder;
    ComponentFactory componentFactory;

    TopPanel(MainFrame parentFrame) {
        setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        setLayout(new GridBagLayout());

        this.parentFrame = parentFrame;
        try {
            logo = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("logo.png"))));
            componentFactory = FactoryConstructor.getFactory("label");
            usernameLabel = componentFactory.getLabel("top", "ユーザー名：");
            passwordLabel = componentFactory.getLabel("top", "パスワード：");
            componentFactory = FactoryConstructor.getFactory("button");
            loginButton = componentFactory.getButton("top", "ログイン");
            signupButton = componentFactory.getButton("top", "初回登録");
        } catch (Exception e) {
            e.printStackTrace();
        }
        usernameInput = new JTextField(10);
        passwordInput = new JPasswordField(10);
        inputField = new Container();
        buttonHolder = new Container();

        usernameInput.setFont(FontScheme.TOP_TEXTFIELD.getFont());
        passwordInput.setFont(FontScheme.TOP_TEXTFIELD.getFont());
        passwordInput.setEchoChar('･');
        loginButton.addActionListener(new LoginAction());
        signupButton.addActionListener(new SignupAction());
        inputField.setLayout(new GridBagLayout());
        buttonHolder.setLayout(new GridBagLayout());

        inputField.add(usernameLabel, LayoutScheme.TOP_NAMELABEL.getLayout());
        inputField.add(usernameInput, LayoutScheme.TOP_NAMEINPUT.getLayout());
        inputField.add(passwordLabel, LayoutScheme.TOP_PASSWORDLABEL.getLayout());
        inputField.add(passwordInput, LayoutScheme.TOP_PASSWORDINPUT.getLayout());
        buttonHolder.add(loginButton, LayoutScheme.TOP_LOGINBUTTON.getLayout());
        buttonHolder.add(signupButton, LayoutScheme.TOP_SIGNUPBUTTON.getLayout());
        add(logo, LayoutScheme.TOP_LOGO.getLayout());
        add(inputField, LayoutScheme.TOP_INPUTFIELD.getLayout());
        add(buttonHolder, LayoutScheme.TOP_BUTTONHOLDER.getLayout());
    }

    /**
     * ログインボタンに合わせたログインアクションクラス
     */
    class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: 具体的なログイン処理が必要

            //効果展示用、実装に合わせて調整する必要がある
            if (false) {
                LoginDialog.getDialog(parentFrame).setVisible(true);
            } else {
                parentFrame.changePanel(parentFrame.getMatchingPanel());
            }
        }
    }

    /**
     * 初回登録ボタンに合わせたサインアップアクションクラス
     */
    class SignupAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: 具体的な初回登録処理が必要

            //効果展示用、実装に合わせて調整する必要がある
            SignupDialog.getDialog(parentFrame, false).setVisible(true);
        }
    }
}
