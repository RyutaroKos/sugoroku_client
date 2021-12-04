package com.ui.component;

import com.ui.component.button.LobbyPanelButton;
import com.ui.component.dialog.ExitLobbyDialog;
import com.ui.scheme.*;
import com.ui.component.subpanel.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyPanel extends JPanel {
    MainFrame parentFrame;
    JPanel lobbyTop;
    JPanel lobbyLeft;
    JPanel lobbyRight;
    JButton exitButton;
    JButton startButton;
    JButton sendMessageButton;
    JLabel typeBanner;
    JLabel idBanner;
    JTextArea playerListArea;
    JTextArea chatArea;
    JScrollPane chatScrollPane;
    JTextField chatInputField;

    LobbyPanel(MainFrame parentFrame, String lobbyType, String ID) {
        setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        setLayout(new GridBagLayout());
        this.parentFrame = parentFrame;

        lobbyTop = LobbyPanelTop.getPanel();
        lobbyLeft = LobbyPanelBottom.getPanel("参加者");
        lobbyRight = LobbyPanelBottom.getPanel("フリーチャット");
        exitButton = LobbyPanelButton.getButton("退室");
        startButton = LobbyPanelButton.getButton("開始");
        sendMessageButton = LobbyPanelButton.getButton("送信");
        typeBanner = new JLabel();
        idBanner = new JLabel();

        typeBanner.setFont(FontScheme.LOBBY_BANNER.getFont());
        idBanner.setFont(FontScheme.LOBBY_BANNER.getFont());
        setLobbyBanner(lobbyType, ID);
        exitButton.addActionListener(new ExitLobbyAction());
        startButton.addActionListener(new StartGameAction());

        lobbyTop.setLayout(new GridBagLayout());
        lobbyTop.add(exitButton, LayoutScheme.LOBBY_EXITBUTTON.getLayout());
        lobbyTop.add(typeBanner, LayoutScheme.LOBBY_TYPEBANNER.getLayout());
        lobbyTop.add(idBanner, LayoutScheme.LOBBY_IDBANNER.getLayout());
        lobbyTop.add(startButton, LayoutScheme.LOBBY_STARTBUTTON.getLayout());

        playerListArea = new JTextArea();
        playerListArea.setEditable(false);
        playerListArea.setLineWrap(true);
        playerListArea.setBorder(new LineBorder(Color.BLACK, 1, false));
        playerListArea.setBackground(ColorScheme.LIGHT_GOLD.getColor());
        playerListArea.setPreferredSize(new Dimension(350, 500));
        lobbyLeft.add(playerListArea, LayoutScheme.LOBBY_BOTTOMPANEL_TEXTAREA.getLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setBorder(new LineBorder(Color.BLACK, 1, false));
        chatArea.setBackground(Color.WHITE);
        chatScrollPane = new JScrollPane(chatArea);
        chatScrollPane.setPreferredSize(new Dimension(350, 455));
        chatScrollPane.setBorder(new LineBorder(Color.BLACK, 0, false));
        chatInputField = new JTextField();
        chatInputField.setPreferredSize(new Dimension(265, 40));
        chatInputField.setBorder(new LineBorder(Color.BLACK, 1 , false));
        chatInputField.setFont(FontScheme.LOBBY_BOTTOM_BUTTON.getFont());
        Container inputField = new Container();
        inputField.setLayout(new GridBagLayout());
        inputField.add(chatInputField, LayoutScheme.LOBBY_CHATINPUT.getLayout());
        inputField.add(sendMessageButton, LayoutScheme.LOBBT_SENDCHAT.getLayout());
        lobbyRight.add(chatScrollPane, LayoutScheme.LOBBY_BOTTOMPANEL_TEXTAREA.getLayout());
        lobbyRight.add(inputField, LayoutScheme.LOBBY_CHATINPUTFIELD.getLayout());

        add(lobbyTop, LayoutScheme.LOBBY_TOP.getLayout());
        add(lobbyLeft, LayoutScheme.LOBBY_PLAYERLIST.getLayout());
        add(lobbyRight, LayoutScheme.LOBBY_CHATPANEL.getLayout());
    }

    private void setLobbyBanner(String lobbyType, String ID) {
        if (lobbyType.equals("random")) {
            typeBanner.setText("ランダムロビー");
        } else {
            typeBanner.setText("プライベートロビー");
        }
        idBanner.setText("ID: " + ID);
    }

    private LobbyPanel getLobbyPanel() {
        return this;
    }

    public void exitLobby() {
        //TODO: add exit lobby action
    }

    class ExitLobbyAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ExitLobbyDialog.getDialog(parentFrame, getLobbyPanel()).setVisible(true);
        }
    }

    class StartGameAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: add start game action

        }
    }

    class SendMessageAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
}
