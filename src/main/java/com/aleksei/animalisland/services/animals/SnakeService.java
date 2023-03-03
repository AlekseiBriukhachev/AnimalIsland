package com.aleksei.animalisland.services.animals;

import com.aleksei.animalisland.models.Animal;
import com.aleksei.animalisland.models.snake.Snake;
import com.aleksei.animalisland.services.IslandService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SnakeService {
    private IslandService island;
    private List<Snake> snakes = new ArrayList<>();
    private final List<Snake> justBorn = new ArrayList<>();
    public List<Snake> update() {
        new ArrayList<>(snakes).forEach(this::animalTurn);
        snakes = snakes.stream().filter(Animal::isAlive)
                .collect(Collectors.toList());
        justBorn.forEach(this::addSnake);
        List<Snake> backup = new ArrayList<>(justBorn);
        justBorn.clear();
        return backup;
    }
    private void addSnake(Snake snake) {
        snake.addBirthListener(justBorn::add);
        snakes.add(snake);
    }
    public Stream<Snake> snakeStream(){
        return snakes.stream();
    }

    public void animalTurn(Animal<?> animal) {
        animal.update(island::visibilityFor);
    }
    public int total(){
        return snakes.size();
    }
}
