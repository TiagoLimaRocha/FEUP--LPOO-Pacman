package drawables.layout;

import com.googlecode.lanterna.TextColor;
import drawables.IDrawable;
import screen.IScreen;
import utils.Consts;

public class GameOverScreen implements IDrawable {
    @Override
    public void draw(IScreen screen) {

        screen.drawGfx(35, 10, " GAME over", TextColor.ANSI.RED);
        screen.drawGfx(39, 13, "9", Consts.Drawables.PINKY_COLOR);
        screen.drawGfx(40, 13, "9", Consts.Drawables.INKY_COLOR);
        screen.drawGfx(41, 13, "9", Consts.Drawables.BLINKY_COLOR);
        screen.drawGfx(42, 13, "9", Consts.Drawables.CLYDE_COLOR);
        screen.drawGfx(20, 20, " CONTINUE: enter", TextColor.ANSI.YELLOW);
        screen.drawGfx(45, 20, " EXIT: escape", TextColor.ANSI.GREEN);

        screen.display();
    }

}
