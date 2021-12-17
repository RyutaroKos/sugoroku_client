package com.example.app;

import com.data.JSONBuilder;
import com.data.buffer.CommandBuffer;
import com.ui.component.MainFrame;

import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class CommandManager implements Runnable {
    MainFrame mainFrame;

    CommandManager(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void run() {
        while (true) {
            if (!CommandBuffer.getInstance().isEmpty()) {
                JSONObject jsonObject = JSONBuilder.getJsonObject(CommandBuffer.getInstance().retrieveCommand());
                System.out.println(jsonObject);
            } else {
                try {
                    TimeUnit.MICROSECONDS.sleep(100); //コマンド読み取り処理が追いつかない場合、このタイムアウトを延長
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
