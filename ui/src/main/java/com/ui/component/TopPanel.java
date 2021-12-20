package com.ui.component;

import com.data.Flag;
import com.data.Request;
import com.data.buffer.RequestBuffer;
import com.ui.component.dialog.LoginDialog;
import com.ui.component.dialog.SignupDialog;
import com.ui.scheme.*;
import org.json.JSONObject;

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

    private void login() {
        JSONObject loginRequest = RequestBuffer.getInstance().getRequestObject();
        loginRequest.put(Flag.Request.toString(), Request.LOGIN);
        loginRequest.put(Flag.Username.toString(), String.valueOf(usernameInput.getText()));
        loginRequest.put(Flag.Password.toString(), String.valueOf(passwordInput.getPassword()));
        RequestBuffer.getInstance().registerRequest(loginRequest);
    }

    private void signup() {
        JSONObject signupRequest = RequestBuffer.getInstance().getRequestObject();
        signupRequest.put(Flag.Request.toString(), Request.SIGNUP);
        signupRequest.put(Flag.Username.toString(), String.valueOf(usernameInput.getText()));
        signupRequest.put(Flag.Password.toString(), String.valueOf(passwordInput.getPassword()));
        RequestBuffer.getInstance().registerRequest(signupRequest);
    }

    /**
     * ログインボタンに合わせたログインアクションクラス
     */
    class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: 具体的なログイン処理が必要

            //効果展示用、実装に合わせて調整する必要がある
            login();
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
            signup();
            SignupDialog.getDialog(parentFrame, false).setVisible(true);
        }
    }
}
