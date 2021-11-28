package com.ui.component;

import com.ui.scheme.*;
import com.ui.component.button.MatchingPanelButton;
import com.ui.component.label.MatchingPanelLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatchingPanel extends JPanel {
    MainFrame parentFrame;
    JTextArea textArea;
    JScrollPane scrollPane;
    JButton randomMatchButton;
    JButton privateMatchButton;
    JButton checkRecordButton;
    JLabel randomMatchLabel;
    JLabel privateMatchLabel;
    JLabel checkRecordLabel;
    Container randomField;
    Container privateField;
    Container checkRecordField;
    Container buttonField;

    MatchingPanel(MainFrame parentFrame) {
        this.setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        this.setLayout(new GridBagLayout());

        this.parentFrame = parentFrame;
        textArea = new JTextArea(60, 20);
        scrollPane = new JScrollPane(textArea);
        randomMatchButton = MatchingPanelButton.getButton("ランダムマッチ");
        privateMatchButton = MatchingPanelButton.getButton("プライベートマッチ");
        checkRecordButton = MatchingPanelButton.getButton("対戦成績確認");
        randomMatchLabel = MatchingPanelLabel.getLabel("※世界中のプレイヤーと対戦しよう");
        privateMatchLabel = MatchingPanelLabel.getLabel("※友だちとプライベートで対戦しよう");
        checkRecordLabel = MatchingPanelLabel.getLabel("※自分の対戦成績を確認しよう");
        randomField = new Container();
        privateField = new Container();
        checkRecordField = new Container();
        buttonField = new Container();

        textArea.setBackground(ColorScheme.LIGHT_GOLD.getColor());
        scrollPane.setPreferredSize(new Dimension(400, 600)); //TODO: ウインドウサイズがこれより小さい場合、表示異常が発生
        randomMatchButton.addActionListener(new randomMatchingAction());
        privateMatchButton.addActionListener(new privateMatchingAction());
        checkRecordButton.addActionListener(new checkRecordAction());
        randomField.setLayout(new GridBagLayout());
        privateField.setLayout(new GridBagLayout());
        checkRecordField.setLayout(new GridBagLayout());
        buttonField.setLayout(new GridLayout(3, 1));

        this.add(scrollPane, LayoutScheme.MATCHING_SCROLLPANEL.getLayout());
        randomField.add(randomMatchButton, LayoutScheme.MATCHING_RANDOMBUTTON.getLayout());
        randomField.add(randomMatchLabel, LayoutScheme.MATCHING_RANDOMLABEL.getLayout());
        privateField.add(privateMatchButton, LayoutScheme.MATCHING_PRIVATEBUTTON.getLayout());
        privateField.add(privateMatchLabel, LayoutScheme.MATCHING_PRIVATELABEL.getLayout());
        checkRecordField.add(checkRecordButton, LayoutScheme.MATCHING_CHECKRECORDBUTTON.getLayout());
        checkRecordField.add(checkRecordLabel, LayoutScheme.MATCHING_CHECKRECORDLABEL.getLayout());
        buttonField.add(randomField);
        buttonField.add(privateField);
        buttonField.add(checkRecordField);
        this.add(buttonField, LayoutScheme.MATCHING_BUTTONFIELD.getLayout());
    }

    class randomMatchingAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: add random matching action
        }
    }

    class privateMatchingAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: add private matching action
        }
    }

    class checkRecordAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: add check record action
        }
    }
}
