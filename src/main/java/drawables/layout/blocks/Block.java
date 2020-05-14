package drawables.layout.blocks;

import drawables.layout.Field;
import drawables.layout.Wall;
import screen.IScreen;

import java.util.List;

public abstract class Block {

    public  List<Field> walls;

    protected Integer startColumn;
    protected Integer startRow;
    protected Integer size;

    protected abstract void initBlock();
    protected abstract void draw(IScreen screen);
}
