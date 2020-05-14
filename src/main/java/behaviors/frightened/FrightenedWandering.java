package behaviors.frightened;

import utils.Direction;

public class FrightenedWandering implements FrightenedBehavior {

    private int rng(int min, int max){
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    @Override
    public Direction wander(Direction currDir) {
        Direction newDirection = currDir;

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
