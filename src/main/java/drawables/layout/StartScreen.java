package drawables.layout;

import com.googlecode.lanterna.TextColor;
import drawables.IDrawable;
import screen.IScreen;
import screen.Screen;
import step.Steppable;
import utils.Consts;

public class StartScreen implements IDrawable, Steppable {

    @Override
    public void draw(IScreen screen) {
        screen.drawGfx(38, 5, "pAcmAn", Consts.Drawables.YELLOW);
        screen.drawGfx(34, 9, "1", Consts.Drawables.PACMAN_COLOR);
        screen.drawGfx(35, 9, "222324234 ", TextColor.ANSI.BLACK);
        screen.drawGfx(44, 9, "9", Consts.Drawables.PINKY_COLOR);
        screen.drawGfx(45, 9, "9", Consts.Drawables.INKY_COLOR);
        screen.drawGfx(46, 9, "9", Consts.Drawables.BLINKY_COLOR);
        screen.drawGfx(47, 9, "9", Consts.Drawables.CLYDE_COLOR);
        screen.drawGfx(35, 13, "TXT. EDITION", TextColor.ANSI.WHITE);

        int currTimeSecs = (int) System.currentTimeMillis() / 1000;

        if (currTimeSecs - Screen.nSecs >= 1) {
            screen.drawGfx(35, 20, " pressENTER", TextColor.ANSI.BLACK);
            Screen.nSecs = currTimeSecs;
        } else
            screen.drawGfx(35, 20, " pressENTER", TextColor.ANSI.RED);

        screen.display();
    }

    @Override
    public void step(){
        this.draw(Screen.getScreen());
    }
}
