package drawables.agents.collectibles;

import drawables.agents.Agent;
import drawables.agents.ghosts.Ghost;
import drawables.layout.Maze;
import utils.Direction;

/**
 * Any collectibles of the game
 */
public abstract class Collectible extends Agent {
    /**
     * Nothing happens here
     */
    @Override
    public void hitBy(Ghost ghost) {
    }

    @Override
    public void setLives(Integer lives) {

    }
}
