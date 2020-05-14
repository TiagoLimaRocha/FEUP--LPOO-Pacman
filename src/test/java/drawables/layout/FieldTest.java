package drawables.layout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class FieldTest {

    Field field;

    @Before
    public void setup() {
        field = new Field(10, 10);
    }

    @Test
    public void accept_true() {
        boolean result = field.accept(null);
        assertEquals(true, result);
    }

}
