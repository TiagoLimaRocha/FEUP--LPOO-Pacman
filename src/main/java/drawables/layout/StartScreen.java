package drawables.layout;

import com.googlecode.lanterna.TextColor;
import drawables.IDrawable;
import screen.IScreen;
import utils.Consts;

public class StartScreen implements IDrawable {
    @Override
    public void draw(IScreen screen) {
        screen.drawGfx(37, 6, "pAc-mAn", Consts.Drawables.YELLOW);
        screen.drawGfx(34, 10, "1", Consts.Drawables.PACMAN_COLOR);
        screen.drawGfx(35, 10, "2324234 ", TextColor.ANSI.BLACK);
        screen.drawGfx(43, 10, "9", Consts.Drawables.PINKY_COLOR);
        screen.drawGfx(44, 10, "9", Consts.Drawables.INKY_COLOR);
        screen.drawGfx(45, 10, "9", Consts.Drawables.BLINKY_COLOR);
        screen.drawGfx(46, 10, "9", Consts.Drawables.CLYDE_COLOR);
        screen.drawGfx(35, 14, "TXT. EDITION", TextColor.ANSI.WHITE);
        screen.drawGfx(35, 20, " pressENTER", TextColor.ANSI.RED);
        screen.display();
    }

}
