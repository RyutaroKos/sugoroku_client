package com.ui.component.dialog;

import com.data.Protocol;
import com.data.Request;
import com.data.buffer.GameBuffer;
import com.data.buffer.RequestBuffer;
import com.ui.component.MainFrame;
import org.json.JSONObject;

import javax.swing.*;

public class SelectRouteDialog extends AppDialog {
    SelectRouteDialog(MainFrame mainFrame) {
        super(mainFrame);
        setTitle("前進方向選択");
        dialogMessage.setText("角を曲がる？");
        positiveButton.addActionListener(e -> selectRoute(1));
        negativeButton.addActionListener(e -> selectRoute(0));
        buttonHolder.add(negativeButton);
    }

    private void selectRoute(int route) {
        JSONObject selectRouteRequest = new JSONObject();
        selectRouteRequest.put(Protocol.Request.toString(), Request.SELECT_ROUTE);
//        selectRouteRequest.put(Protocol.Username.toString(), GameBuffer.getInstance().getUsername());
        selectRouteRequest.put(Protocol.Route.toString(), route);
        RequestBuffer.getInstance().registerRequest(selectRouteRequest);
    }

    public static JDialog getDialog(MainFrame mainFrame) {
        return new SelectRouteDialog(mainFrame);
    }
}
