package com.ui.component;

import com.data.buffer.CommandBuffer;
import com.data.buffer.DataBuffer;
import com.ui.component.dialog.ExitLobbyDialog;
import com.ui.scheme.*;
import com.ui.component.subpanel.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * マッチング成功後表示する第三の画面：ロビーパネル。
 * 現時点ではまだ雛形、
 * プレイヤーリストや、チャット内容の表示は未実装。
 * ArrayList<UserList>、ArrayList<ChatList>などが必要かも。
 */

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
        playerListPane = LobbyPanelBody.getPanel("参加者");
        chatPane = LobbyPanelBody.getPanel("フリーチャット");
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
        messageInput.setFont(FontScheme.LOBBY_BODYPANEL_BUTTON.getFont());
        sendMessageButton.addActionListener(new SendMessageAction());
        messageInputPane.setLayout(new GridBagLayout());

        lobbyBannerPane.add(exitButton, LayoutScheme.LOBBY_EXITBUTTON.getLayout());
        lobbyBannerPane.add(typeBanner, LayoutScheme.LOBBY_TYPEBANNER.getLayout());
        lobbyBannerPane.add(idBanner, LayoutScheme.LOBBY_IDBANNER.getLayout());
        lobbyBannerPane.add(startButton, LayoutScheme.LOBBY_STARTBUTTON.getLayout());
        playerListPane.add(playerListArea, LayoutScheme.LOBBY_BODYPANEL_TEXTAREA.getLayout());
        messageInputPane.add(messageInput, LayoutScheme.LOBBY_CHATINPUT.getLayout());
        messageInputPane.add(sendMessageButton, LayoutScheme.LOBBY_SENDCHAT.getLayout());
        chatPane.add(chatScrollPane, LayoutScheme.LOBBY_BODYPANEL_TEXTAREA.getLayout());
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

    private LobbyPanel getCurrentLobby() {
        return this;
    }

    public void exitLobby() {
        //TODO: 具体的な退室処理が必要
        CommandBuffer.getInstance().registerCommand("EXIT_LOBBY");
    }

    public void startGame() {
        CommandBuffer.getInstance().registerCommand("START_GAME");
    }

    public void sendMessage() {
        CommandBuffer.getInstance().registerCommand("SEND_CHAT");
        DataBuffer.getInstance().setMessage(messageInput.getText());
    }

    /**
     * 退室ボタンに合わせた退室アクションクラス
     */
    class ExitLobbyAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: 具体的な退室処理が必要

            //効果展示用、実装に合わせて調整する必要がある
            ExitLobbyDialog.getDialog(parentFrame, getCurrentLobby()).setVisible(true);
        }
    }

    /**
     * 開始ボタンに合わせたゲーム開始アクションクラス
     */
    class StartGameAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: 具体的なゲーム開始処理が必要

            startGame();
        }
    }

    /**
     * 送信ボタンに合わせたメッセージ送信アクションクラス
     */
    class SendMessageAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: 具体的なチャット送信処理が必要

            sendMessage();
        }
    }
}
