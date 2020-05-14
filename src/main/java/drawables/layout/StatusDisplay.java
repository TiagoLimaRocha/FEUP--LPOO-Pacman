package drawables.layout;

import drawables.IDrawable;
import drawables.agents.Pacman;
import screen.IScreen;
import utils.Consts;

public class StatusDisplay implements IDrawable {

    @Override
    public void draw(IScreen screen) {
        drawLives(screen);
        // drawPoints(screen);
    }

    private void drawLives(IScreen screen) {
        Integer lives = Pacman.getLives();
        String livesStr = "";

        for (Integer i = 0; i < lives; i++){
            if (i == lives - 1)
                livesStr += Consts.Drawables.LIFE;
            else
                livesStr += Consts.Drawables.LIFE + " ";
        }

        screen.drawGfx(5, Consts.Maze.ROWS, livesStr, Consts.Drawables.LIFE_COLOR);
    }

    private void drawPoints(IScreen screen) {
        Integer points = Pacman.getPoints();
        String pointsStr = points + "p";
        screen.drawGfx(5, 0, pointsStr, Consts.Drawables.WHITE);
    }
}
