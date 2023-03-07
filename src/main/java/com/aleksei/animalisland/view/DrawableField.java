package com.aleksei.animalisland.view;



import com.aleksei.animalisland.models.Location;
import com.aleksei.animalisland.services.Position;
import com.aleksei.animalisland.utils.factories.CellFactory;
import com.aleksei.animalisland.utils.factories.DrawableZooFactory;
import com.aleksei.animalisland.utils.factories.PlantFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class DrawableField implements Drawable {

    private final Field field;

    private final DrawableZooFactory drawableZooFactory;

    private final List<DrawableLocation> highlightedCells = new ArrayList<>();
    private final Map<Position, DrawableLocation> drawableCells;
    private List<DrawableBoar> drawableBoars = new ArrayList<>();
    private List<DrawableBear> drawableWolves = new ArrayList<>();

    private DrawableField(Field field, DrawableZooFactory drawableZooFactory, Map<Position, DrawableLocation> drawableCells) {
        this.field = field;
        this.drawableZooFactory = drawableZooFactory;
        this.drawableCells = drawableCells;
    }

    public static DrawableField create(int width, int height,
                                       CellFactory cellFactory,
                                       PlantFactory plantFactory,
                                       DrawableZooFactory drawableZooFactory) {
        ArrayList<DrawableLocation> drawableLocations = new ArrayList<>(width * height);
        IntStream.range(0, width * height)
            .forEach(i -> {
                Position position = Position.on(i % width, i / width);
                drawableLocations.add(cellFactory.create(position, plantFactory.createGrass()));
            });
        List<Location> cells = drawableLocations.stream().map(DrawableLocation::getLocation).collect(Collectors.toList());
        Field field = new Field(width, height, cells);
        return new DrawableField(field, drawableZooFactory, drawableLocations.stream().collect(toMap(c -> c.getCell().getPosition(), c -> c)));
    }

    public UpdateResult update() {
        long st = System.currentTimeMillis();
        field.updateCells();

        List<Rabbit> newRabbits = field.updateRabbits();
        drawableBoars = drawableBoars.stream().filter(du -> du.getBoar().isAlive()).collect(Collectors.toList());
        newRabbits.forEach(newRabbit -> drawableBoars.add(drawableZooFactory.wrap(newRabbit)));

        List<Wolf> newWolves = field.updateWolves();
        drawableWolves = drawableWolves.stream().filter(du -> du.getBear().isAlive()).collect(Collectors.toList());
        newWolves.forEach(newWolf -> drawableWolves.add(drawableZooFactory.wrap(newWolf)));

        long end = System.currentTimeMillis();
        return new UpdateResult(end - st, field.rabbitsTotal(), field.wolvesTotal());
    }

    @Override
    public void draw(Graphics2D g) {
        drawableCells.forEach((pos, cell) -> cell.draw((Graphics2D) g.create(
            cell.getLocation().getX() * SIZE,
            cell.getLocation().getY() * SIZE,
            SIZE - 1,
            SIZE - 1)
        ));

        Stream.concat(
            new ArrayList<>(drawableBoars).stream(),
            new ArrayList<>(drawableWolves).stream()
        ).collect(
            Collectors.groupingBy(du -> du.getLivingUnit().getPosition())
        ).forEach((position, units) -> {
                units.stream().filter(u -> u.getLivingUnit() instanceof Wolf).findAny().ifPresent(unit ->
                    unit.draw((Graphics2D) g.create(
                        position.getX() * SIZE,
                        position.getY() * SIZE,
                        SIZE - 1,
                        SIZE - 1)
                    )
                );
                units.stream().filter(u -> u.getLivingUnit() instanceof Rabbit).findAny().ifPresent(unit ->
                    unit.draw((Graphics2D) g.create(
                        position.getX() * SIZE,
                        position.getY() * SIZE,
                        SIZE - 1,
                        SIZE - 1)
                    )
                );
                if (units.size() > 1) {
                    g.setColor(Color.BLACK);
                    g.drawString(Integer.toString(units.size()),
                        position.getX() * SIZE,
                        (position.getY() + 1) * SIZE);
                }
            }
        );
    }

    public void addBoarOn(Position position, RabbitExample example) {
        DrawableBoar drawable = drawableZooFactory.createRabbit(position, example, field);
        field.addRabbit(drawable.getBoar());
        drawableBoars.add(drawable);
    }

    public void addBearOn(Position position, WolfExample example) {
        DrawableBear drawable = drawableZooFactory.createWolf(position, example, field);
        field.addWolf(drawable.getBear());
        drawableWolves.add(drawable);
    }

    public Stream<LivingUnit<?>> unitsOn(Position position) {
        return field.unitsOn(position);
    }

    public DrawableLocation drawableCellOn(Position position) {
        return drawableCells.get(position);
    }

    public void highlightAim(LivingUnit<?> livingUnit) {
        highlightedCells.forEach(c -> c.setValue(null));
        highlightedCells.clear();
        if (livingUnit == null) {
            return;
        }
        Map<Position, Integer> evaluated = livingUnit.evaluate(field.visibilityFor(livingUnit));
        int min = evaluated.values().stream().mapToInt(i -> i).min().orElse(0);
        int max = evaluated.values().stream().mapToInt(i -> i).max().orElse(0);
        evaluated
            .forEach((position, value) -> {
                DrawableLocation dc = drawableCellOn(position);
                dc.setValue(min == max ? 1 : ((float) value - min) / (max - min));
                highlightedCells.add(dc);
            });
    }
}
