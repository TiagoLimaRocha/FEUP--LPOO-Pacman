package drawables.layout.blocks;

import drawables.layout.Field;
import drawables.layout.Wall;
import screen.IScreen;

import java.util.ArrayList;

public abstract class TShapeBlock extends Block {

    Integer offset;

    public TShapeBlock(Integer startColumn, Integer startRow, Integer size, Integer offset){
        this.walls = new ArrayList<>();
        this.startColumn = startColumn;
        this.startRow = startRow;
        this.size = size;
        this.offset = offset;
    }

    @Override
    public void draw(IScreen screen) {
        for (Field wall : walls)
            wall.draw(screen);
    }
}
