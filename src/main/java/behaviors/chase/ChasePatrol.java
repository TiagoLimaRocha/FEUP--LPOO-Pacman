package behaviors.chase;

import drawables.agents.Agent;
import drawables.agents.Pacman;
import drawables.layout.Field;
import utils.Consts;
import utils.Direction;

import java.util.ArrayList;
import java.util.List;

public class ChasePatrol implements ChaseBehavior {

    Agent ghost;

    public ChasePatrol(Agent ghost){
        this.ghost = ghost;
    }

    private int rng(int min, int max){
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    @Override
    public Direction chase(Direction currDir, Pacman pacman) {

        Direction newDirection = currDir;
        Field currField = ghost.getField();
        Integer currX = currField.getX();
        Integer currY = currField.getY();

        List<Direction> possibleDirections = new ArrayList<>();

        if (currField.getNeighbor(Direction.UP).accept(ghost))
            possibleDirections.add(Direction.UP);

        if (currField.getNeighbor(Direction.DOWN).accept(ghost))
            possibleDirections.add(Direction.DOWN);

        if (currField.getNeighbor(Direction.LEFT).accept(ghost))
            possibleDirections.add(Direction.LEFT);

        if (currField.getNeighbor(Direction.RIGHT).accept(ghost))
            possibleDirections.add(Direction.RIGHT);


        if (currX >= 0 && currX <= Consts.Maze.COLUMNS){
            if (currY >= 0 && currY <= Consts.Maze.ROWS/2){
                Direction possibleDirection = possibleDirections.get(rng(0, possibleDirections.size() - 1));
                if (currDir == Direction.DOWN && possibleDirection != Direction.UP)
                    newDirection = possibleDirection;
                else if (currDir == Direction.UP && possibleDirection != Direction.DOWN)
                    newDirection = possibleDirection;
                else if (currDir == Direction.LEFT && possibleDirection != Direction.RIGHT)
                    newDirection = possibleDirection;
                else if (currDir == Direction.RIGHT && possibleDirection != Direction.LEFT)
                    newDirection = possibleDirection;
            } else {
                if (currDir == Direction.DOWN)
                    newDirection = Direction.UP;
                else if (currDir == Direction.UP)
                    newDirection = Direction.DOWN;
                else if (currDir == Direction.LEFT)
                    newDirection = Direction.RIGHT;
                else if (currDir == Direction.RIGHT)
                    newDirection = Direction.LEFT;
            }
        }

        return newDirection;
    }
}