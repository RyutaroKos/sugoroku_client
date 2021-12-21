package com.ui.component.subpanel;

import com.ui.scheme.ColorScheme;
import com.ui.scheme.FontScheme;
import com.ui.scheme.LayoutScheme;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * ロビーパネルの下部ボディークラス。
 * 本質はロビーパネルのサブパネル。
 */

public class LobbyPanelBody extends JPanel {
    LobbyPanelBody(String title) {
        setPreferredSize(new Dimension(400, 600));
        setBorder(new LineBorder(Color.BLACK, 1, false));
        setColor(title);
        setLayout(new GridBagLayout());

        JLabel panelTitle = new JLabel(title);
        panelTitle.setFont(FontScheme.LOBBY_BODYPANEL_TITLE.getFont());
        add(panelTitle, LayoutScheme.LOBBY_BODYPANEL_LABEL.getLayout());
    }

    private void setColor(String title) {
        if (title.equals("参加者")) {
            setBackground(ColorScheme.LIGHT_GOLD.getColor());
        } else {
            setBackground(ColorScheme.LIGHT_BLUE.getColor());
        }
    }

    public static LobbyPanelBody getPanel(String title) {
        return new LobbyPanelBody(title);
    }
}
