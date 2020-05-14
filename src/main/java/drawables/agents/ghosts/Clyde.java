package drawables.agents.ghosts;

import behaviors.chase.ChasePatrol;
import behaviors.chase.ChaseRandom;
import behaviors.frightened.FrightenedWandering;
import behaviors.scatter.ScatterBotLeftCorner;
import behaviors.scatter.ScatterBotRightCorner;
import drawables.layout.Maze;
import screen.IScreen;
import utils.Consts;

public class Clyde extends Ghost {

    public Clyde(){
        this.chaseBehavior = new ChaseRandom(this);
        this.scatterBehavior = new ScatterBotLeftCorner();
        this.frightenedBehavior = new FrightenedWandering();
    }

    @Override
    protected void resetPosition() {
        removed = true;

        field = Maze.getField(40, 10);
        field.addAgent(this);
    }

    @Override
    public void draw(IScreen screen) {
        if (this.state.isFrightened()){
            screen.draw(
                    this.getField().getX(), this.getField().getY(),
                    Consts.Drawables.CLYDE,
                    Consts.Drawables.WHITE
            );
        } else {
            screen.draw(
                    this.getField().getX(), this.getField().getY(),
                    Consts.Drawables.CLYDE,
                    Consts.Drawables.CLYDE_COLOR
            );
        }
    }
}
