package drawables.layout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import screen.IScreen;
import utils.Consts;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class WallTest {

    Wall wall;

    @Before
    public void setup() {
        wall = new Wall(10, 10);
    }

    @Test
    public void accept_false() {
        boolean result = wall.accept(null);
        assertEquals(false, result);
    }

    @Test
    public void draw_screen() {
        IScreen screen = Mockito.mock(IScreen.class);

        wall.draw(screen);

        verify(screen).draw(10, 10, Consts.Drawables.WALL, Consts.Drawables.WALL_COLOR);
    }
}
