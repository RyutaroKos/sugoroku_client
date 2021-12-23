package com.ui.component;

import com.data.Protocol;
import com.data.Request;
import com.data.buffer.GameBuffer;
import com.data.buffer.RequestBuffer;
import com.ui.scheme.*;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
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

    TopPanel(MainFrame mainFrame) {
        setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        setLayout(new GridBagLayout());

        parentFrame = mainFrame;
        try {
            logo = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("logo.png"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        usernameLabel = FactoryConstructor.getFactory(UIKeyword.Label).getLabel(UIKeyword.TopPanel, "ユーザー名：");
        passwordLabel = FactoryConstructor.getFactory(UIKeyword.Label).getLabel(UIKeyword.TopPanel, "パスワード：");
        loginButton = FactoryConstructor.getFactory(UIKeyword.Button).getButton(UIKeyword.TopPanel, "ログイン");
        signupButton = FactoryConstructor.getFactory(UIKeyword.Button).getButton(UIKeyword.TopPanel, "初回登録");
        usernameInput = new JTextField(10);
        passwordInput = new JPasswordField(10);
        inputField = new Container();
        buttonHolder = new Container();

        usernameInput.setFont(FontScheme.TOP_TEXTFIELD.getFont());
        passwordInput.setFont(FontScheme.TOP_TEXTFIELD.getFont());
        passwordInput.setEchoChar('･');
        loginButton.addActionListener(actionEvent -> login());
        signupButton.addActionListener(actionEvent -> signup());
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
        GameBuffer.getInstance().setUsername(usernameInput.getText());
        JSONObject loginRequest = RequestBuffer.getInstance().getRequestObject();
        loginRequest.put(Protocol.Request.toString(), Request.LOGIN);
        loginRequest.put(Protocol.Username.toString(), usernameInput.getText());
        loginRequest.put(Protocol.Password.toString(), String.valueOf(passwordInput.getPassword()));
        RequestBuffer.getInstance().registerRequest(loginRequest);
    }

    private void signup() {
        JSONObject signupRequest = RequestBuffer.getInstance().getRequestObject();
        signupRequest.put(Protocol.Request.toString(), Request.SIGNUP);
        signupRequest.put(Protocol.Username.toString(), usernameInput.getText());
        signupRequest.put(Protocol.Password.toString(), String.valueOf(passwordInput.getPassword()));
        RequestBuffer.getInstance().registerRequest(signupRequest);
    }
}
