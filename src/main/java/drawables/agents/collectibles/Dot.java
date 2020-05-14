package drawables.agents.collectibles;

import audio.SoundFX;
import drawables.agents.Agent;
import drawables.agents.Pacman;
import drawables.layout.Maze;
import screen.IScreen;
import utils.Consts;

import javax.sound.sampled.Clip;

/**
 * Simple dots which the player collects
 */
public class Dot extends Collectible {

    /**
     * If hit by Pacman, it is removed and Pacman gains points
     */
    @Override
    public void hitBy(Pacman pacman) {

        pacman.munch();

        pacman.addPoints(Consts.Pacman.POINT_INCREMENT);
        Maze.removeCollectible(this);

        // cant use field.removeAgent(this) here because of a concurrent modification
        // the field deletes it according to flag, after the outer for-cycle
        removed = true;
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
            Consts.Drawables.DOT,
            Consts.Drawables.DOT_COLOR
        );
    }
}
