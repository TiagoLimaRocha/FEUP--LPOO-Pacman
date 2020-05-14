package drawables.agents;

import drawables.layout.Field;
import step.Steppable;
import utils.Direction;

/**
 * Agents that can move, like Pacman and Ghosts
 */
public abstract class MovingAgent extends Agent implements Steppable {

    protected Direction direction, nextDirection;
    private boolean verticalStep;

    public MovingAgent() {
        this.verticalStep = false;
    }

    /**
     * Stepping logic: the next direction is cached until we can move towards it
     */
    @Override
    public void step() {
        if (nextDirection != null && direction != nextDirection){
            if (move(nextDirection))
                direction = nextDirection;
            else
                move(direction);
        } else if (canStepVertically())
            move(direction);
    }

    /**
     * Moves Agent to given direction
     *  - returns its success
     */
    protected boolean move(Direction direction) {
        Field nextField = field.getNeighbor(direction);
        boolean success = nextField.accept(this);

        if (success) {
            field.removeAgent(this);
            nextField.addAgent(this);
            field = nextField;
        }

        return success;
    }

    /**
     * Hack to slow down pacman when going up
     *  - because of uneven character "pixels"
     *  - calling move at every 2nd step() function
     */
    protected boolean canStepVertically() {
        if ((direction == Direction.UP || direction == Direction.DOWN)) {
            if (verticalStep)
                return verticalStep = false;
            else
                return verticalStep = true;
        } else return true;
    }

    public void setNextDirection(Direction nextDirection) {
        this.nextDirection = nextDirection;
    }
}
