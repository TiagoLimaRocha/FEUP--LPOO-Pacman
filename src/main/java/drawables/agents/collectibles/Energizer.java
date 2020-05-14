package drawables.agents.collectibles;

import drawables.agents.Agent;
import drawables.agents.Pacman;
import drawables.layout.Maze;
import screen.IScreen;
import utils.Consts;

public class Energizer extends Collectible {

    @Override
    public void hitBy(Pacman pacman) {

        pacman.addPoints(Consts.Pacman.POINT_INCREMENT);
        Maze.removeCollectible(this);

        // cant use field.removeAgent(this) here because of a concurrent modification
        // the field deletes it according to flag, after the outer for-cycle
        removed = true;

        pacman.becomeStronk();
    }

    /**
     * It wont collide since it cant move
     */
    @Override
    public void collideWith(Agent otherAgent) {
    }

    @Override
    public void draw(IScreen screen) {
        screen.draw(
                this.getField().getX(), this.getField().getY(),
                Consts.Drawables.ENERGIZER,
                Consts.Drawables.ENERGIZER_COLOR
        );
    }
}
