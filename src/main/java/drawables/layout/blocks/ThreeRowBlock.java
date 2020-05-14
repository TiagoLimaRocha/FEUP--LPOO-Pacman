package drawables.layout.blocks;

import drawables.layout.Field;
import drawables.layout.Wall;
import screen.IScreen;

import java.util.ArrayList;

public abstract class ThreeRowBlock extends Block {
    public ThreeRowBlock(Integer startColumn, Integer startRow, Integer size){
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
