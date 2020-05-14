package drawables.agents.ghosts;

import behaviors.chase.ChasePatrol;
import behaviors.frightened.FrightenedWandering;
import behaviors.scatter.ScatterBotRightCorner;
import drawables.layout.Maze;
import screen.IScreen;
import utils.Consts;

public class Inky extends Ghost {

    public Inky(){
        this.chaseBehavior = new ChasePatrol(this);
        this.scatterBehavior = new ScatterBotRightCorner();
        this.frightenedBehavior = new FrightenedWandering();
    }

    @Override
    protected void resetPosition() {
        removed = true;

        field = Maze.getField(38, 9);
        field.addAgent(this);
    }

    @Override
    public void draw(IScreen screen) {
        if (this.state.isFrightened()){
            screen.draw(
                    this.getField().getX(), this.getField().getY(),
                    Consts.Drawables.INKY,
                    Consts.Drawables.WHITE
            );
        } else {
            screen.draw(
                    this.getField().getX(), this.getField().getY(),
                    Consts.Drawables.INKY,
                    Consts.Drawables.INKY_COLOR
            );
        }
    }
}
