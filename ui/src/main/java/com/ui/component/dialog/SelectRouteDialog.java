package com.ui.component.dialog;

import com.data.Protocol;
import com.data.Request;
import com.data.buffer.GameBuffer;
import com.data.buffer.RequestBuffer;
import com.ui.component.MainFrame;
import org.json.JSONObject;

public class SelectRouteDialog extends AppDialog {
    SelectRouteDialog(MainFrame mainFrame) {
        super(mainFrame);
        dialogMessage.setText("角を曲がりますか？");
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
}
