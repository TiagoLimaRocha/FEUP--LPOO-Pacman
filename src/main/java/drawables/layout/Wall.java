package drawables.layout;

import drawables.agents.Agent;
import screen.IScreen;
import utils.Consts;

/**
 * Special kind of field: a wall
 *  - player can't step on it
 */
public class Wall extends Field {

    public Wall(Integer x, Integer y) {
        super(x, y);
    }

    @Override
    public boolean accept(Agent agent) {
        return false;
    }

    @Override
    public void draw(IScreen screen) {
        screen.draw(
            this.x, this.y,
            Consts.Drawables.WALL,
            Consts.Drawables.WALL_COLOR
        );
    }
}
