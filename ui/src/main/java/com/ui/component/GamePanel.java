package com.ui.component;

import com.ui.component.subcomponent.GamePanelMap;
import com.ui.component.subcomponent.GamePanelPlayerCard;
import com.ui.component.subcomponent.MapGrid;
import com.ui.component.subcomponent.Player;
import com.ui.scheme.ColorScheme;
import com.ui.scheme.LayoutScheme;

import javax.swing.*;
import java.awt.*;

/**
 * ゲーム開始後表示する第四の画面：ゲームパネル。
 * 現在工事中…
 */

public class GamePanel extends JPanel {
    MainFrame parentFrame;
    GamePanelMap gameMap;
    JLabel mapLabel;
    JLabel[] mapExampleLabels;
    JButton useItemButton;
    JButton rollDiceButton;
    JPanel[] playerCards;
    Container mapExamplePane;
    Container buttonHolder;
    Container playerCardPane;

    GamePanel(MainFrame mainFrame) {
        setBackground(ColorScheme.LIGHT_ORANGE.getColor());
        setLayout(new GridBagLayout());
        parentFrame = mainFrame;
        gameMap = new GamePanelMap();
        mapLabel = FactoryConstructor.getFactory(UIKeyword.Label).getLabel(UIKeyword.GamePanelMapLabel, "マップ図示");
        mapExampleLabels = new JLabel[MapGrid.values().length + Player.values().length - 1];
        int labelIndex = 0;
        for (MapGrid grid : MapGrid.values()) {
            if (grid == MapGrid.NULL) continue;
            mapExampleLabels[labelIndex++] = FactoryConstructor.getFactory(UIKeyword.Label).getLabel(UIKeyword.GamePanelMapExampleLabel, grid.toString());
        }
        for (Player player : Player.values()) {
            mapExampleLabels[labelIndex++] = FactoryConstructor.getFactory(UIKeyword.Label).getLabel(UIKeyword.GamePanelMapExampleLabel, player.toString());
        }
        useItemButton = FactoryConstructor.getFactory(UIKeyword.Button).getButton(UIKeyword.GamePanelButton, "道具を使用する");
        rollDiceButton = FactoryConstructor.getFactory(UIKeyword.Button).getButton(UIKeyword.GamePanelButton, "サイコロを振る");
        playerCards = new JPanel[Player.values().length];
        for (int i = 0; i < Player.values().length; i++) {
            playerCards[i] = GamePanelPlayerCard.getPlayerCard(Player.values()[i]);
        }
        mapExamplePane = new Container();
        buttonHolder = new Container();
        playerCardPane = new Container();

        useItemButton.addActionListener(e -> useItemAction());
        rollDiceButton.addActionListener(e -> rollDiceAction());
        mapExamplePane.setLayout(new GridLayout(MapGrid.values().length + Player.values().length - 1, 1, 5, 10));
        buttonHolder.setLayout(new GridLayout(1, 2, 5, 5));
        playerCardPane.setLayout(new GridLayout(1, 4, 5, 5));

        for (JLabel label : mapExampleLabels) {
            mapExamplePane.add(label);
        }
        buttonHolder.add(useItemButton);
        buttonHolder.add(rollDiceButton);
        for (JPanel playerCard : playerCards) {
            playerCardPane.add(playerCard);
        }
        add(gameMap, LayoutScheme.GAME_MAP.getLayout());
        add(mapLabel, LayoutScheme.GAME_MAP_LABEL.getLayout());
        add(mapExamplePane, LayoutScheme.GAME_MAP_EXAMPLE.getLayout());
        add(buttonHolder, LayoutScheme.GAME_BUTTONHOLDER.getLayout());
        add(playerCardPane, LayoutScheme.GAME_PLAYERCARD_PANE.getLayout());
    }

    private void useItemAction() {
        //TODO:
    }

    private void rollDiceAction() {
        //TODO:
    }
}
