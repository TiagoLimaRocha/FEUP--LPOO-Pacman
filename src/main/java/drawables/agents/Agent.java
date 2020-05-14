package drawables.agents;

import drawables.IDrawable;
import drawables.agents.ghosts.Ghost;
import drawables.layout.Field;
import utils.Direction;

/**
 * Anything which can stand on a field
 */
public abstract class Agent implements IDrawable {

    protected Field field;
    protected boolean removed = false;

    public Agent() {}

    // Abstract methods begin
    public abstract void collideWith(Agent otherAgent);

    public abstract void hitBy(Pacman pacman);

    public abstract void hitBy(Ghost ghost);

    public abstract void setLives(Integer lives);
    // Abstract methods end


    public Field getField() { return field; }

    public void setField(Field field) {
        this.field = field;
    }

    public boolean isRemoved() {
        return removed;
    }
}
