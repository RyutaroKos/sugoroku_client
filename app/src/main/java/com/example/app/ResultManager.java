package com.example.app;

import com.data.Request;
import com.data.buffer.ResultBuffer;
import com.ui.component.MainFrame;

public class ResultManager implements Runnable {
    MainFrame mainFrame;

    ResultManager(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {
        while (true) {
            if (!ResultBuffer.getInstance().isEmpty()) {
                switch (Request.valueOf(ResultBuffer.getInstance().retrieveResult())) {
                    case LOGIN -> {}
                }
            }
        }
    }
}
