package drawables.agents.ghosts;

import behaviors.chase.ChaseAgressive;
import behaviors.frightened.FrightenedWandering;
import behaviors.scatter.ScatterTopRightCorner;
import drawables.layout.Field;
import drawables.layout.Maze;
import screen.IScreen;
import utils.Consts;

public class Blinky extends Ghost {

    public Blinky(){
        this.field = new Field(40, 9);

        this.chaseBehavior = new ChaseAgressive(this, field);
        this.scatterBehavior = new ScatterTopRightCorner();
        this.frightenedBehavior = new FrightenedWandering();
    }

    @Override
    protected void resetPosition() {
        removed = true;

        field = Maze.getField(41, 9);
        field.addAgent(this);
    }

    @Override
    public void draw(IScreen screen) {
        if (this.state.isFrightened()){
            screen.draw(
                    this.getField().getX(), this.getField().getY(),
                    Consts.Drawables.BLINKY,
                    Consts.Drawables.WHITE
            );
        } else {
            screen.draw(
                    this.getField().getX(), this.getField().getY(),
                    Consts.Drawables.BLINKY,
                    Consts.Drawables.BLINKY_COLOR
            );
        }

    }
}
