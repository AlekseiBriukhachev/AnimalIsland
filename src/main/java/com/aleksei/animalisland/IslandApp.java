package com.aleksei.animalisland;


import com.aleksei.animalisland.services.StartService;

public class IslandApp {
    public static void main(String[] args) {
        new Thread(new StartService()).start();
    }
}
