package drawables.layout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import screen.IScreen;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MazeTest {

    @Mock List<Field> fieldMocks;

    @InjectMocks Maze maze;

    @Test
    public void step() {
        Maze mazeMock = Mockito.spy(Maze.class);

        mazeMock.step();

        verify(mazeMock).draw(any());
    }

    @Test
    public void draw() {
        IScreen screen = Mockito.mock(IScreen.class);

        maze.draw(screen);

        verify(screen).display();
    }


}
