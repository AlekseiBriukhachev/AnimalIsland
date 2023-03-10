package com.aleksei.animalisland.view;

import com.aleksei.animalisland.config.AppConfig;
import com.typesafe.config.Config;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.awt.RenderingHints.*;

public class FieldVisualizationPanel extends JPanel {

    private static final AppConfig CONFIG = AppConfig.getAppConfig();

    public static final int WIDTH = CONFIG.getIslandWidth();
    public static final int HEIGHT = CONFIG.getIslandHeight();

    private volatile DrawableField field;
    private volatile Timer timer;

    private Consumer<String> infoConsumer;

    public FieldVisualizationPanel() {
        super(true);
        setPreferredSize(new Dimension(CellDrawer.SIZE * WIDTH + 1, CellDrawer.SIZE * HEIGHT + 1));
    }

    public void init() {
        field = DrawableField.create(WIDTH, HEIGHT, new CellFactory(), new GrassFactory(), new DrawableZooFactoryImpl());
        IntStream.range(0, CONFIG.getInt("rabbits")).forEach(i -> {
            int randX = ThreadLocalRandom.current().nextInt(WIDTH);
            int randY = ThreadLocalRandom.current().nextInt(HEIGHT);
            field.addRabbitOn(Position.on(randX, randY), RabbitExample.random());
        });
        repaint();
    }

    public void setInfoConsumer(Consumer<String> infoConsumer) {
        this.infoConsumer = infoConsumer;
    }

    public void stopOrResume() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        } else {
            start();
        }
    }

    private void start() {
        timer = new Timer(false);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateGame();
            }
        }, 0, 100);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(KEY_RENDERING, VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(KEY_ALPHA_INTERPOLATION, VALUE_ALPHA_INTERPOLATION_QUALITY);
        paintField(g2d);
    }

    private void paintField(Graphics2D g) {
        field.draw(g);
    }

    public void updateGame() {
        UpdateResult result = field.update();
        repaint();
        if (infoConsumer != null) {
            infoConsumer.accept(
                "Rabbits: " + result.getRabbitsTotal()
                    + ", Wolves: " + result.getWolvesTotal()
                    + ", Elapsed: "
                    + result.getElapsed() + "ms");
        }
    }

    public void putWolfOn(Point point, WolfExample example) {
        if (timer == null) {
            field.addWolfOn(positionBy(point), example);
            repaint();
        }
    }

    public void putRabbitOn(Point point, RabbitExample example) {
        if (timer == null) {
            field.addRabbitOn(positionBy(point), example);
            repaint();
        }
    }

    public void highlightAim(Point point) {
        field.highlightAim(field.unitsOn(positionBy(point)).findFirst().orElse(null));
        repaint();
    }

    public void showInfoAbout(Point point) {
        Position position = positionBy(point);
        JOptionPane.showMessageDialog(null, field.unitsOn(position)
            .map(Object::toString)
            .collect(Collectors.joining(",\n")));
    }

    private Position positionBy(Point point) {
        int x = (int) (point.getX() / CellDrawer.SIZE);
        int y = (int) (point.getY() / CellDrawer.SIZE);
        return Position.on(x, y);
    }
}
