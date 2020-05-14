package drawables.agents.collectibles;

import drawables.agents.Pacman;
import drawables.layout.Field;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import screen.IScreen;
import utils.Consts;

import static org.mockito.Mockito.verify;

public class DotTest {

    Dot dot;

    @Before
    public void setup() {
        dot = new Dot();
        dot.setField(new Field(10,10));
    }

    @Test
    public void draw_screen() {
        IScreen screen = Mockito.mock(IScreen.class);

        dot.draw(screen);

        verify(screen).draw(10, 10,
                Consts.Drawables.DOT, Consts.Drawables.DOT_COLOR);
    }
}
