
package com.ui.component;

import com.data.Flag;
import com.data.Request;
import com.data.buffer.RequestBuffer;
import com.ui.component.dialog.GameRecordDialog;
import com.ui.component.dialog.RequestPrivateMatchDialog;
import com.ui.scheme.*;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    ComponentFactory componentFactory;

    MatchingPanel(MainFrame parentFrame) {
        setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        setLayout(new GridBagLayout());

        this.parentFrame = parentFrame;
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        try {
            componentFactory = FactoryConstructor.getFactory("label");
            randomMatchLabel = componentFactory.getLabel("matching", "※世界中のプレイヤーと対戦しよう");
            privateMatchLabel = componentFactory.getLabel("matching", "※友だちとプライベートで対戦しよう");
            checkRecordLabel = componentFactory.getLabel("matching", "※自分の対戦成績を確認しよう");
            componentFactory = FactoryConstructor.getFactory("button");
            randomMatchButton = componentFactory.getButton("matching", "ランダムマッチ");
            privateMatchButton = componentFactory.getButton("matching", "プライベートマッチ");
            checkRecordButton = componentFactory.getButton("matching", "対戦成績確認");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        randomMatchButton.addActionListener(new RandomMatchAction());
        privateMatchButton.addActionListener(new PrivateMatchAction());
        checkRecordButton.addActionListener(new CheckRecordAction());
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

    private MatchingPanel getCurrentPanel() {
        return this;
    }

    private void randomMatch() {
        JSONObject randomMatchRequest = RequestBuffer.getInstance().getRequestObject();
        randomMatchRequest.put(Flag.Request.toString(), Request.RANDOM_MATCH);
        RequestBuffer.getInstance().registerRequest(randomMatchRequest);
    }

    public void privateMatch(String privateMatchID) {
        JSONObject privateMatchRequest = RequestBuffer.getInstance().getRequestObject();
        privateMatchRequest.put(Flag.Request.toString(), Request.PRIVATE_MATCH);
        privateMatchRequest.put(Flag.LobbyID.toString(), privateMatchID);
        RequestBuffer.getInstance().registerRequest(privateMatchRequest);
    }

    private void checkRecord() {
        JSONObject checkRecordRequest = RequestBuffer.getInstance().getRequestObject();
        checkRecordRequest.put(Flag.Request.toString(), Request.CHECK_RECORD);
        RequestBuffer.getInstance().registerRequest(checkRecordRequest);
    }

    /**
     * ランダムマッチボタンに合わせたランダムマッチングアクションクラス
     */
    class RandomMatchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: 具体的なランダムマッチング処理が必要

            //効果展示用、実装に合わせて調整する必要がある
            randomMatch();
            parentFrame.changePanel(parentFrame.getLobbyPanel("random", "xb23"));
        }
    }

    /**
     * プライベートマッチボタンに合わせたプライベートマッチングアクションクラス
     */
    class PrivateMatchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: 具体的なプライベートマッチング処理が必要

            //効果展示用、実装に合わせて調整する必要がある
            RequestPrivateMatchDialog.getDialog(parentFrame, getCurrentPanel(), "<html>プライベートロビーIDを入力ください<br>（4桁半角英数字）</html>").setVisible(true);
        }
    }

    /**
     * 対戦成績確認ボタンに合わせた成績確認アクションクラス
     */
    class CheckRecordAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: 具体的な成績確認処理が必要

            //効果展示用、実装に合わせて調整する必要がある
            checkRecord();
            GameRecordDialog.getDialog(parentFrame, "ここで戦績を確認できます").setVisible(true);
        }
    }
}
