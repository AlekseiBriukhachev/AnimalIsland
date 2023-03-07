package com.aleksei.animalisland.view;

import com.aleksei.animalisland.config.AppConfig;
import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.animals.Bear;
import com.aleksei.animalisland.models.animals.Boar;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.utils.factories.CellFactory;
import com.aleksei.animalisland.utils.factories.DrawableZooFactoryImpl;
import com.aleksei.animalisland.utils.factories.PlantFactory;

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

    private static final AppConfig CONF = AppConfig.getAppConfig();

    public static final int WIDTH = CONF.getIslandWidth();
    public static final int HEIGHT = CONF.getIslandHeight();
    public static final int SIZE = 5;
    //
    private volatile DrawableField field;
    private volatile Timer timer;
    //
    private Consumer<String> infoConsumer;

    public FieldVisualizationPanel() {
        super(true);
        setPreferredSize(new Dimension(SIZE * WIDTH + 1, SIZE * HEIGHT + 1));
    }

    public void init() {
        field = DrawableField.create(WIDTH, HEIGHT, new CellFactory(), new PlantFactory(), new DrawableZooFactoryImpl());
        IntStream.range(0, CONF.getInitNumber(Boar.class)).forEach(i -> {
            int randX = ThreadLocalRandom.current().nextInt(WIDTH);
            int randY = ThreadLocalRandom.current().nextInt(HEIGHT);
            field.addBoarOn(Position.onPosition(randX, randY), BoarExample.random());
        });
        IntStream.range(0, CONF.getInitNumber(Bear.class)).forEach(i -> {
            int randX = ThreadLocalRandom.current().nextInt(WIDTH);
            int randY = ThreadLocalRandom.current().nextInt(HEIGHT);
            field.addBearOn(Position.onPosition(randX, randY), BearExample.random());
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
                "Rabbits: " + result.getBoarsTotal()
                    + ", Wolves: " + result.getBearsTotal()
                    + ", Elapsed: "
                    + result.getElapsed() + "ms");
        }
    }

    public void putBearOn(Point point, BearExample example) {
        if (timer == null) {
            field.addBearOn(positionBy(point), example);
            repaint();
        }
    }

    public void putBoarOn(Point point, BoarExample example) {
        if (timer == null) {
            field.addBoarOn(positionBy(point), example);
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
            .map((Animal<?> t) -> {
                return Object.toString(t);
            })
            .collect(Collectors.joining(",\n")));
    }

    private Position positionBy(Point point) {
        int x = (int) (point.getX() / SIZE);
        int y = (int) (point.getY() / SIZE);
        return Position.onPosition(x, y);
    }
}
