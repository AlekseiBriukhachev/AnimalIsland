package src_temp.main.java.com.aleksei.island.view;

import com.aleksei.island.config.AppConfig;
import com.aleksei.island.controller.Controller;
import com.aleksei.island.entities.Location;
import com.aleksei.island.enumartion.AnimalType;
import com.aleksei.island.model.Model;
import com.aleksei.island.service.Factories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class View extends JPanel implements ActionListener {
    private final AppConfig config = AppConfig.getAppConfig();

    private static final int LOCATION_MARGIN = 2;
    private Controller controller;
    private Location location;
    private final int LOCATION_SIZE = config.getLocationSize() - LOCATION_MARGIN;
    private final JFrame frame = new JFrame();
    private final JPanel controlBtnPanel = new JPanel();
    private final JPanel parameterPanel = new JPanel();
    private final JButton startBtn = new JButton("Start");
    private final JButton stopBtn = new JButton("Stop");
    private final JButton restartBtn = new JButton("Restart");
    private final JButton confirmBtn = new JButton("Confirm");
    private final JLabel islandWightLabel = new JLabel("Width: ");
    private final JLabel islandHeightLabel = new JLabel("Height: ");
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
//        parameterPanel.add(somelab);
        parameterPanel.add(animalList);
        parameterPanel.add(confirmBtn);


//        statistic.add(somelab);

        frame.getContentPane().add(controlBtnPanel, BorderLayout.NORTH);
        frame.getContentPane().add(controller.getView());
        frame.getContentPane().add(parameterPanel, BorderLayout.WEST);
//        frame.getContentPane().add(statistic, BorderLayout.SOUTH);
        frame.pack();

        frame.setTitle("Animal Island Simulation");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1600, 800);//FIXME
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);
        for (int x = 0; x < config.getIslandWidth(); x++) {
            for (int y = 0; y < config.getIslandHeight(); y++) {
                drawLocation(g, controller.getSimLocations()[x][y], x, y);
            }
        }
    }

    private void drawLocation(Graphics g2, Location location, int x, int y) {
        Graphics2D g = ((Graphics2D) g2);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int xOffset = offsetCoors(x);
        int yOffset = offsetCoors(y);
        Factories imageFactory = new Factories();
        Image image = imageFactory.chooseImage(AnimalType.BEAR);
        //FIXME fix hardcode of image, temporary BEAR
        g.drawImage(image, xOffset, yOffset, LOCATION_SIZE, LOCATION_SIZE,this);
    }

    private int offsetCoors(int arg) {
        return arg * (LOCATION_MARGIN + LOCATION_SIZE) + LOCATION_MARGIN;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}