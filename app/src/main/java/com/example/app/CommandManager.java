package com.example.app;

import com.data.buffer.CommandBuffer;
import com.ui.component.MainFrame;

import java.util.concurrent.TimeUnit;

public class CommandManager implements Runnable {
    MainFrame mainFrame;
    CommandBuffer commandBuffer;

    CommandManager(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        commandBuffer = CommandBuffer.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            if (!commandBuffer.isEmpty()) {
                System.out.println(commandBuffer.retrieveCommand());
            } else {
                try {
                    TimeUnit.MILLISECONDS.sleep(10); //コマンド読み取り処理が追いつかない場合、このタイムアウトを延長
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
