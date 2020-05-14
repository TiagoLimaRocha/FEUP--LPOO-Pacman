package behaviors.chase;

import drawables.agents.Agent;
import drawables.agents.Pacman;
import drawables.agents.ghosts.Ghost;
import drawables.layout.Field;
import utils.Direction;

import java.util.ArrayList;
import java.util.List;

public class ChaseAgressive implements ChaseBehavior {

    Field currField;
    Agent ghost;

    public ChaseAgressive(Agent ghost, Field currField){
        this.ghost = ghost;
        this.currField = currField;
    }

    private int rng(int min, int max){
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    private double vectNorm(Field field, Pacman pacman){
        Integer x = field.getX();
        Integer y = field.getY();

        Integer pacmanX = pacman.getField().getX();
        Integer pacmanY = pacman.getField().getY();

        Integer vectX = Math.abs(x - pacmanX);
        Integer vectY = Math.abs(y - pacmanY);

        double norm = Math.sqrt(Math.pow(vectX, 2) + Math.pow(vectY, 2));

        return norm;
    }

    @Override
    public Direction chase(Direction currDir, Pacman pacman) {
        Direction newDirection = currDir;

        Field currField = ghost.getField();
        Integer currX = currField.getX();
        Integer currY = currField.getY();

        double lastCalculatedDistance;
        double shortestDistance = vectNorm(currField, pacman);

        List<Field> adjacentFields = new ArrayList<>();
        List<Direction> possibleDirections = new ArrayList<>();

        if (currField.getNeighbor(Direction.UP).accept(ghost)){
            adjacentFields.add(currField.getNeighbor(Direction.UP));
            possibleDirections.add(Direction.UP);
        }

        if (currField.getNeighbor(Direction.DOWN).accept(ghost)){
            adjacentFields.add(currField.getNeighbor(Direction.DOWN));
            possibleDirections.add(Direction.DOWN);
        }

        if (currField.getNeighbor(Direction.LEFT).accept(ghost)){
            adjacentFields.add(currField.getNeighbor(Direction.LEFT));
            possibleDirections.add(Direction.LEFT);
        }

        if (currField.getNeighbor(Direction.RIGHT).accept(ghost)){
            adjacentFields.add(currField.getNeighbor(Direction.RIGHT));
            possibleDirections.add(Direction.RIGHT);
        }

        int idx = 0;
        for (Field field : adjacentFields){
            lastCalculatedDistance = vectNorm(field, pacman);
            if (lastCalculatedDistance <= shortestDistance){
                shortestDistance = lastCalculatedDistance;
                newDirection = possibleDirections.get(idx);
                break;
            }

            idx++;
        }

        return newDirection;
    }
}