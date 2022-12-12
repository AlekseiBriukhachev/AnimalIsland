package com.briukhachev.aleksei;

import com.briukhachev.aleksei.model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class View extends JPanel implements ActionListener {
    private static final int LOCATION_MARINE = 2;
    private Controller controller;
    private Model model;
    private Location location = new Location();
    private Params params = new Params();
    private final int LOCATION_SIZE = (1500 / params.getWidth()) - LOCATION_MARINE;
    private Image image;
    private final JFrame frame = new JFrame();
    private final JPanel controlBtnPanel = new JPanel();
    private final JPanel parameterPanel = new JPanel();
    private final JPanel statistic = new JPanel();
    private final JButton startBtn = new JButton("Start");
    private final JButton stopBtn = new JButton("Stop");
    private final JButton restartBtn = new JButton("Restart");
    private final JButton confirmBtn = new JButton("Confirm");
    private final JLabel islandWightLabel = new JLabel("Width: ");
    private final JLabel islandHeightLabel = new JLabel("Height: ");
    private final JLabel somelab = new JLabel("SomeLabel");
    private final JTextField widthInp = new JTextField(5);
    private final JTextField heightInp = new JTextField(5);
    private final String[] animalString = {"bear", "boar", "buffalo", "caterpillar", "deer", "duck", "eagle", "fox",
    "goat", "horse", "mouse", "rabbit", "sheep", "snake", "wolf", "plant", "empty"};
    private final JComboBox animalList =new JComboBox<>(animalString);
    private final JPanel hut = new JPanel();

    public View(Controller controller) {
        this.controller = controller;
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void init() {

        animalList.setSelectedIndex(4);
        animalList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
//                JComboBox cb = (JComboBox) e.getSource();
                String animalName = e.getSource().toString();
                if ((animalName).equals("bear")) location.setImage(AnimalImage.BEAR);
                else if (animalName.equals("boar")) location.setImage(AnimalImage.BOAR);
                else if (animalName.equals("buffalo")) location.setImage(AnimalImage.BUFFALO);
                else if (animalName.equals("caterpillar")) location.setImage(AnimalImage.CATERPILLAR);
                else if (animalName.equals("deer")) location.setImage(AnimalImage.DEER);
                else if (animalName.equals("duck")) location.setImage(AnimalImage.DUCK);
                else if (animalName.equals("eagle")) location.setImage(AnimalImage.EAGLE);
                else if (animalName.equals("fox")) location.setImage(AnimalImage.FOX);
                else if (animalName.equals("goat")) location.setImage(AnimalImage.GOAT);
                else if (animalName.equals("horse")) location.setImage(AnimalImage.HORSE);
                else if (animalName.equals("rabbit")) location.setImage(AnimalImage.RABBIT);
                else if (animalName.equals("sheep")) location.setImage(AnimalImage.SHEEP);
                else if (animalName.equals("snake")) location.setImage(AnimalImage.SNAKE);
                else if (animalName.equals("wolf")) location.setImage(AnimalImage.WOLF);
                else if (animalName.equals("plant")) location.setImage(AnimalImage.PLANT);
                else location.setImage(AnimalImage.EMPTY);
                repaint();
            }
        });

        startBtn.setActionCommand("start");
        startBtn.addActionListener(this);
        stopBtn.setActionCommand("stop");
        stopBtn.addActionListener(this);
        restartBtn.setActionCommand("restart");
        restartBtn.addActionListener(this);
        controlBtnPanel.add(startBtn);
        controlBtnPanel.add(stopBtn);
        controlBtnPanel.add(restartBtn);

        stopBtn.setActionCommand("");
        stopBtn.addActionListener(this);
        confirmBtn.setActionCommand("confirm");
        confirmBtn.addActionListener(this);
        parameterPanel.setLayout(new GridLayout(10, 4));
        parameterPanel.add(islandHeightLabel);
        parameterPanel.add(heightInp);
        parameterPanel.add(islandWightLabel);
        parameterPanel.add(widthInp);
        parameterPanel.add(somelab);
        parameterPanel.add(animalList);
        parameterPanel.add(confirmBtn);


        statistic.add(somelab);

        frame.getContentPane().add(controlBtnPanel, BorderLayout.NORTH);
        frame.getContentPane().add(controller.getView());
        frame.getContentPane().add(parameterPanel, BorderLayout.WEST);
//        frame.getContentPane().add(statistic, BorderLayout.SOUTH);
        frame.pack();

        frame.setTitle("Animal Island Simulation");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1600, 800);
        frame.setVisible(true);
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
        image = location.chooseImage(location.getImage());
        g.drawImage(image, xOffset, yOffset, LOCATION_SIZE, LOCATION_SIZE,this);
    }

    private int offsetCoors(int arg) {
        return arg * (LOCATION_MARINE + LOCATION_SIZE) + LOCATION_MARINE;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confirm")) {
            params.setWidth(Integer.parseInt(widthInp.getText()));
            widthInp.setText(" ");
            controller.setSimLocation(new Location[params.getWidth()][params.getHeight()]);
            repaint();
        }
        else if (e.getActionCommand().equals("start")){
            controller.startSimulation();
        }
    }
}
