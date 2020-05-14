package behaviors.chase;

import drawables.agents.Agent;
import drawables.agents.Pacman;
import drawables.layout.Field;
import utils.Direction;

public class ChaseRandom implements ChaseBehavior {

    Agent ghost;

    public ChaseRandom(Agent ghost){
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

        switch (rng(1, 4)){
            case 1:
                if (currDir != Direction.UP)
                    newDirection = Direction.DOWN;
                break;
            case 2:
                if (currDir != Direction.LEFT)
                    newDirection = Direction.RIGHT;
                break;
            case 3:
                if (currDir != Direction.DOWN)
                    newDirection = Direction.UP;
                break;
            case 4:
                if (currDir != Direction.RIGHT)
                    newDirection = Direction.LEFT;
                break;
            default:
                break;
        }

        return newDirection;
    }
}