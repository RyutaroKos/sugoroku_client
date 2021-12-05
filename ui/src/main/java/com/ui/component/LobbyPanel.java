package com.ui.component;

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
    JPanel lobbyBannerPane;
    JPanel playerListPane;
    JPanel chatPane;
    JLabel typeBanner;
    JLabel idBanner;
    JButton exitButton;
    JButton startButton;
    JButton sendMessageButton;
    JTextArea playerListArea;
    JTextArea chatArea;
    JScrollPane chatScrollPane;
    JTextField messageInput;
    Container messageInputPane;
    ComponentFactory componentFactory;

    LobbyPanel(MainFrame parentFrame, String lobbyType, String ID) {
        setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        setLayout(new GridBagLayout());

        this.parentFrame = parentFrame;
        lobbyBannerPane = LobbyPanelBanner.getPanel();
        playerListPane = LobbyPanelBottom.getPanel("参加者");
        chatPane = LobbyPanelBottom.getPanel("フリーチャット");
        try {
            componentFactory = FactoryConstructor.getFactory("label");
            typeBanner = componentFactory.getLabel("lobby", lobbyType);
            idBanner = componentFactory.getLabel("lobby", ID);
            componentFactory = FactoryConstructor.getFactory("button");
            exitButton = componentFactory.getButton("lobby", "退室");
            startButton = componentFactory.getButton("lobby", "開始");
            sendMessageButton = componentFactory.getButton("lobby", "送信");
        } catch (Exception e) {
            e.printStackTrace();
        }
        playerListArea = new JTextArea();
        chatArea = new JTextArea();
        chatScrollPane = new JScrollPane(chatArea);
        messageInput = new JTextField();
        messageInputPane = new Container();

        setLobbyBanner(lobbyType, ID);
        exitButton.addActionListener(new ExitLobbyAction());
        startButton.addActionListener(new StartGameAction());
        playerListArea.setEditable(false);
        playerListArea.setLineWrap(true);
        playerListArea.setBorder(new LineBorder(Color.BLACK, 1, false));
        playerListArea.setBackground(ColorScheme.LIGHT_GOLD.getColor());
        playerListArea.setPreferredSize(new Dimension(350, 500));
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setBorder(new LineBorder(Color.BLACK, 1, false));
        chatArea.setBackground(Color.WHITE);
        chatScrollPane.setPreferredSize(new Dimension(350, 455));
        chatScrollPane.setBorder(new LineBorder(Color.BLACK, 0, false));
        messageInput.setPreferredSize(new Dimension(265, 40));
        messageInput.setBorder(new LineBorder(Color.BLACK, 1 , false));
        messageInput.setFont(FontScheme.LOBBY_BOTTOM_BUTTON.getFont());
        messageInputPane.setLayout(new GridBagLayout());

        lobbyBannerPane.add(exitButton, LayoutScheme.LOBBY_EXITBUTTON.getLayout());
        lobbyBannerPane.add(typeBanner, LayoutScheme.LOBBY_TYPEBANNER.getLayout());
        lobbyBannerPane.add(idBanner, LayoutScheme.LOBBY_IDBANNER.getLayout());
        lobbyBannerPane.add(startButton, LayoutScheme.LOBBY_STARTBUTTON.getLayout());
        playerListPane.add(playerListArea, LayoutScheme.LOBBY_BOTTOMPANEL_TEXTAREA.getLayout());
        messageInputPane.add(messageInput, LayoutScheme.LOBBY_CHATINPUT.getLayout());
        messageInputPane.add(sendMessageButton, LayoutScheme.LOBBT_SENDCHAT.getLayout());
        chatPane.add(chatScrollPane, LayoutScheme.LOBBY_BOTTOMPANEL_TEXTAREA.getLayout());
        chatPane.add(messageInputPane, LayoutScheme.LOBBY_CHATINPUTFIELD.getLayout());
        add(lobbyBannerPane, LayoutScheme.LOBBY_TOP.getLayout());
        add(playerListPane, LayoutScheme.LOBBY_PLAYERLIST.getLayout());
        add(chatPane, LayoutScheme.LOBBY_CHATPANEL.getLayout());
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
