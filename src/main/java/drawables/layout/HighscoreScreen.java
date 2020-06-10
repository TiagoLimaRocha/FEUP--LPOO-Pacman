
package drawables.layout;

import com.googlecode.lanterna.TextColor;
import drawables.IDrawable;
import screen.IScreen;
import screen.Screen;
import step.Steppable;
import utils.Consts;
import utils.ScoreSaver;
import utils.ScreenType;

import java.util.Collections;
import java.util.List;

public class HighscoreScreen implements IDrawable, Steppable {

    @Override
    public void draw(IScreen screen) {
        ScoreSaver scoreLoader = new ScoreSaver();
        List<Integer> scores = scoreLoader.load();
        Collections.sort(scores, Collections.reverseOrder());

        screen.drawGfx(36, 5, "Highscores", Consts.Drawables.RED);

        int i = 7;
        int j = 1;
        for (Integer score : scores){
            screen.drawGfx(36, i + 1,  j + ".", TextColor.ANSI.GREEN);
            screen.drawGfx(39, i + 1," " + score, TextColor.ANSI.WHITE);

            i++; j++;
        }

        screen.display();
    }

    @Override
    public void step(){
        this.draw(Screen.getScreen(ScreenType.HIGHSCORES));
    }
}
