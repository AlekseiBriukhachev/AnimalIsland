package com.briukhachev.aleksei;


import com.briukhachev.aleksei.animals.Wolf;
import com.briukhachev.aleksei.config.Configuation;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        Model model = new Model();
//        Controller controller = new Controller(model);
//        View view = new View(controller);
//        view.init();
//        controller.startSimulation();


        //Test************************
//        System.out.println(Wolf.count);
        Map<String, Object> map = new HashMap<>();
        try {
            Properties properties = new Properties();
            properties.load(Configuation.class.getClassLoader().getResourceAsStream("config/config.properties"));
            for (String key : properties.stringPropertyNames()){
                String[] newKey = key.split("\\.");
                if (key.startsWith(Wolf.class.getSimpleName().toLowerCase() + ".eatProbability")) {
//                    System.out.println(properties.get(key));
//                    System.out.println(newKey[2]);

                    map.put(newKey[2], properties.get(key));
                    System.out.println(map);
                }

//                System.out.println(Wolf.class.getSimpleName().toLowerCase() + ".eatProbability");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
