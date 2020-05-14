package drawables.layout.blocks;

import drawables.layout.Field;
import screen.IScreen;

import java.util.ArrayList;

public abstract class OneRowBlock extends Block {
    public OneRowBlock(Integer startColumn, Integer startRow, Integer size){
        this.walls = new ArrayList<>();
        this.startColumn = startColumn;
        this.startRow = startRow;
        this.size = size;
    }

    @Override
    public void draw(IScreen screen) {
        for (Field wall : walls)
            wall.draw(screen);
    }
}
