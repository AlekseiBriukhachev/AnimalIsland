package com.aleksei.animalisland;


import com.aleksei.animalisland.view.MainWindow;

import java.awt.*;

public class IslandApp {
    public static void main(String[] args) {

//        new Thread(new StartService()).start();
        EventQueue.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.init();
        });
    }
}
