package com.briukhachev.aleksei;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    private static final int LOCATION_MARINE = 2;
    private Controller controller;
    private Location location = new Location();
    private Params params = new Params();
    private final int LOCATION_SIZE = (1500 / params.getWidth()) - LOCATION_MARINE;
    private AnimalImage animalImage;
    private Image image;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void init() {

        JFrame simulation = new JFrame();
        simulation.setTitle("Animal Island");
        simulation.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        simulation.setSize(1600, 800);
        simulation.setResizable(false);
        simulation.add(controller.getView());
        simulation.setLocationRelativeTo(null);
        simulation.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);
        for (int x = 0; x < params.getWidth(); x++) {
            for (int y = 0; y < params.getHeight(); y++) {
                drawLocation(g, controller.getSimLocations()[x][y], x, y);
            }
        }
    }

    private void drawLocation(Graphics g2, Location location, int x, int y) {
        Graphics2D g = ((Graphics2D) g2);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int xOffset = offsetCoors(x);
        int yOffset = offsetCoors(y);
        image = Toolkit.getDefaultToolkit().getImage("resources/Bear.png");
        g.drawImage(image, xOffset, yOffset, LOCATION_SIZE, LOCATION_SIZE,this);
//        g.fillRoundRect(xOffset, yOffset, LOCATION_SIZE, LOCATION_SIZE, 8, 8);
    }

    private int offsetCoors(int arg) {
        return arg * (LOCATION_MARINE + LOCATION_SIZE) + LOCATION_MARINE;
    }
}
