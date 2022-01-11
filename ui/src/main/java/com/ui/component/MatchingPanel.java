package com.ui.component;

import com.data.Protocol;
import com.data.Request;
import com.data.buffer.RequestBuffer;
import com.ui.component.dialog.RequestPrivateMatchDialog;
import com.ui.scheme.*;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * ログイン成功後表示する第二の画面：マッチングパネル
 */

public class MatchingPanel extends JPanel {
    MainFrame parentFrame;
    JTextArea textArea;
    JScrollPane scrollPane;
    JLabel randomMatchLabel;
    JLabel privateMatchLabel;
    JLabel checkRecordLabel;
    JButton randomMatchButton;
    JButton privateMatchButton;
    JButton checkRecordButton;
    Container randomMatchPane;
    Container privateMatchPane;
    Container checkRecordPane;
    Container buttonHolder;

    MatchingPanel(MainFrame mainFrame) {
        setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        setLayout(new GridBagLayout());

        parentFrame = mainFrame;
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        randomMatchButton = FactoryConstructor.getFactory(UIKeyword.Button).getButton(UIKeyword.MatchingPanelButton, "ランダムマッチ");
        privateMatchButton = FactoryConstructor.getFactory(UIKeyword.Button).getButton(UIKeyword.MatchingPanelButton, "プライベートマッチ");
        checkRecordButton = FactoryConstructor.getFactory(UIKeyword.Button).getButton(UIKeyword.MatchingPanelButton, "対戦成績確認");
        randomMatchLabel = FactoryConstructor.getFactory(UIKeyword.Label).getLabel(UIKeyword.MatchingPanelLabel, "※世界中のプレイヤーと対戦しよう");
        privateMatchLabel = FactoryConstructor.getFactory(UIKeyword.Label).getLabel(UIKeyword.MatchingPanelLabel, "※友だちとプライベートで対戦しよう");
        checkRecordLabel = FactoryConstructor.getFactory(UIKeyword.Label).getLabel(UIKeyword.MatchingPanelLabel, "※自分の対戦成績を確認しよう");
        randomMatchPane = new Container();
        privateMatchPane = new Container();
        checkRecordPane = new Container();
        buttonHolder = new Container();

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("game_rule.txt"); //ゲームルールの編集はこちら、場所はmainのresourcesフォルダ
            String str = new String(Objects.requireNonNull(inputStream).readAllBytes(), StandardCharsets.UTF_8);
            textArea.setText(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setFont(FontScheme.MATCHING_LABEL.getFont());
        textArea.setBackground(ColorScheme.LIGHT_GOLD.getColor());
        scrollPane.setPreferredSize(new Dimension(400, 600));
        scrollPane.setBorder(new LineBorder(Color.BLACK, 1, false));
        randomMatchButton.addActionListener(actionEvent -> randomMatchAction());
        privateMatchButton.addActionListener(actionEvent -> privateMatchAction());
        checkRecordButton.addActionListener(actionEvent -> checkRecordAction());
        randomMatchPane.setLayout(new GridBagLayout());
        privateMatchPane.setLayout(new GridBagLayout());
        checkRecordPane.setLayout(new GridBagLayout());
        buttonHolder.setLayout(new GridLayout(3, 1));

        randomMatchPane.add(randomMatchButton, LayoutScheme.MATCHING_BUTTON.getLayout());
        randomMatchPane.add(randomMatchLabel, LayoutScheme.MATCHING_LABEL.getLayout());
        privateMatchPane.add(privateMatchButton, LayoutScheme.MATCHING_BUTTON.getLayout());
        privateMatchPane.add(privateMatchLabel, LayoutScheme.MATCHING_LABEL.getLayout());
        checkRecordPane.add(checkRecordButton, LayoutScheme.MATCHING_BUTTON.getLayout());
        checkRecordPane.add(checkRecordLabel, LayoutScheme.MATCHING_LABEL.getLayout());
        buttonHolder.add(randomMatchPane);
        buttonHolder.add(privateMatchPane);
        buttonHolder.add(checkRecordPane);
        add(scrollPane, LayoutScheme.MATCHING_SCROLLPANEL.getLayout());
        add(buttonHolder, LayoutScheme.MATCHING_BUTTONHOLDER.getLayout());
    }

    private void randomMatchAction() {
        JSONObject randomMatchRequest = RequestBuffer.getInstance().getRequestObject();
        randomMatchRequest.put(Protocol.Request.toString(), Request.RANDOM_MATCH);
        RequestBuffer.getInstance().registerRequest(randomMatchRequest);
    }

    private void privateMatchAction() {
        RequestPrivateMatchDialog.getDialog(parentFrame, this).setVisible(true);
    }

    public void requestPrivateMatch(String privateMatchID) {
        JSONObject privateMatchRequest = RequestBuffer.getInstance().getRequestObject();
        privateMatchRequest.put(Protocol.Request.toString(), Request.PRIVATE_MATCH);
        privateMatchRequest.put(Protocol.LobbyID.toString(), privateMatchID);
        RequestBuffer.getInstance().registerRequest(privateMatchRequest);
    }

    private void checkRecordAction() {
        JSONObject checkRecordRequest = RequestBuffer.getInstance().getRequestObject();
        checkRecordRequest.put(Protocol.Request.toString(), Request.CHECK_RECORD);
        RequestBuffer.getInstance().registerRequest(checkRecordRequest);
    }
}
