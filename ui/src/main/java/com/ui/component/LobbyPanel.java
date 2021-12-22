package com.ui.component;

import com.data.Protocol;
import com.data.Request;
import com.data.buffer.RequestBuffer;
import com.ui.scheme.*;
import com.ui.component.subpanel.*;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayDeque;

/**
 * マッチング成功後表示する第三の画面：ロビーパネル。
 * 現時点ではまだ雛形、
 * プレイヤーリストや、チャット内容の表示は未実装。
 * ArrayList<UserList>、ArrayList<ChatList>などが必要かも。
 */

public class LobbyPanel extends JPanel { //TODO: add player list and chat record
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

    LobbyPanel(MainFrame mainFrame, String lobbyType, String ID) {
        setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        setLayout(new GridBagLayout());

        parentFrame = mainFrame;
        lobbyBannerPane = LobbyPanelBanner.getPanel();
        playerListPane = LobbyPanelBody.getPanel("参加者");
        chatPane = LobbyPanelBody.getPanel("フリーチャット");
        typeBanner = FactoryConstructor.getFactory(UIKeyword.Label).getLabel(UIKeyword.LobbyPanel, lobbyType);
        idBanner = FactoryConstructor.getFactory(UIKeyword.Label).getLabel(UIKeyword.LobbyPanel, ID);
        exitButton = FactoryConstructor.getFactory(UIKeyword.Button).getButton(UIKeyword.LobbyPanel, "退室");
        startButton = FactoryConstructor.getFactory(UIKeyword.Button).getButton(UIKeyword.LobbyPanel, "開始");
        sendMessageButton = FactoryConstructor.getFactory(UIKeyword.Button).getButton(UIKeyword.LobbyPanel, "送信");
        playerListArea = new JTextArea();
        chatArea = new JTextArea();
        chatScrollPane = new JScrollPane(chatArea);
        messageInput = new JTextField();
        messageInputPane = new Container();

        typeBanner.setText(switch (UIKeyword.valueOf(lobbyType)) {
            case RandomLobby -> "ランダムロビー";
            case PrivateLobby -> "プライベートロビー";
            default -> null;
        });
        idBanner.setText("ID: " + ID);
        exitButton.addActionListener(actionEvent -> exitLobbyAction());
        startButton.addActionListener(actionEvent -> startGameAction());
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
        sendMessageButton.addActionListener(actionEvent -> sendChatAction());
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

    private void exitLobbyAction() {
        FactoryConstructor.getFactory(UIKeyword.Dialog).getDialog(parentFrame, UIKeyword.ExitLobbyDialog, null, null);
    }

    public void requestExitLobby() {
        JSONObject exitLobbyRequest = RequestBuffer.getInstance().getRequestObject();
        exitLobbyRequest.put(Protocol.Request.toString(), Request.EXIT_LOBBY);
        RequestBuffer.getInstance().registerRequest(exitLobbyRequest);
    }

    private void startGameAction() {
        JSONObject startGameRequest = RequestBuffer.getInstance().getRequestObject();
        startGameRequest.put(Protocol.Request.toString(), Request.START_GAME);
        RequestBuffer.getInstance().registerRequest(startGameRequest);
    }

    private void sendChatAction() {
        JSONObject sendChatRequest = RequestBuffer.getInstance().getRequestObject();
        sendChatRequest.put(Protocol.Request.toString(), Request.SEND_CHAT);
        sendChatRequest.put(Protocol.Message.toString(), messageInput.getText());
        RequestBuffer.getInstance().registerRequest(sendChatRequest);
    }
}
