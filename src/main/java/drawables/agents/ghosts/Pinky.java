package drawables.agents.ghosts;

import behaviors.chase.ChaseAmbush;
import behaviors.chase.ChasePatrol;
import behaviors.frightened.FrightenedWandering;
import behaviors.scatter.ScatterBotRightCorner;
import behaviors.scatter.ScatterTopLeftCorner;
import drawables.layout.Field;
import drawables.layout.Maze;
import screen.IScreen;
import utils.Consts;

public class Pinky extends Ghost {

    public Pinky(){
        this.field = new Field(39, 10);

        this.chaseBehavior = new ChaseAmbush(this, field);
        this.scatterBehavior = new ScatterTopLeftCorner();
        this.frightenedBehavior = new FrightenedWandering();
    }

    @Override
    protected void resetPosition() {
        removed = true;

        field = Maze.getField(38, 10);
        field.addAgent(this);
    }

    @Override
    public void draw(IScreen screen) {
        if (this.state.isFrightened()){
            screen.draw(
                    this.getField().getX(), this.getField().getY(),
                    Consts.Drawables.PINKY,
                    Consts.Drawables.WHITE
            );
        } else {
            screen.draw(
                    this.getField().getX(), this.getField().getY(),
                    Consts.Drawables.PINKY,
                    Consts.Drawables.PINKY_COLOR
            );
        }

    }
}
