package drawables.agents;

import drawables.layout.Field;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import utils.Direction;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MovingAgentTest {

    @Mock Field field;

    MovingAgent movingAgent;

    @Before
    public void setup() {
        movingAgent = new Pacman();
        movingAgent.setField(field);
    }

    @Test
    public void move_false() {
        Field nextField = Mockito.mock(Field.class);

        when(field.getNeighbor(any(Direction.class)))
                .thenReturn(nextField);
        when(nextField.accept(any(MovingAgent.class)))
                .thenReturn(false);

        boolean result = movingAgent.move(Direction.UP);

        assertFalse(result);
    }

    @Test
    public void move_true() {
        Field nextField = Mockito.mock(Field.class);

        when(field.getNeighbor(any(Direction.class)))
                .thenReturn(nextField);
        when(nextField.accept(any(MovingAgent.class)))
                .thenReturn(true);

        boolean result = movingAgent.move(Direction.UP);

        assertTrue(result);
    }

    @Test
    public void move_true_correctMethodsCalled() {
        Field nextField = Mockito.mock(Field.class);

        when(field.getNeighbor(any(Direction.class)))
                .thenReturn(nextField);
        when(nextField.accept(any(MovingAgent.class)))
                .thenReturn(true);

        boolean result = movingAgent.move(Direction.UP);

        verify(field).removeAgent(movingAgent);
        verify(nextField).addAgent(movingAgent);
        assertTrue(result);
    }

}
