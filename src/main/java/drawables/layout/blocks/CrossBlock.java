package drawables.layout.blocks;

import drawables.layout.Field;
import screen.IScreen;

import java.util.ArrayList;

public class CrossBlock extends Block {
    public CrossBlock(Integer startColumn, Integer startRow, Integer size){
        this.walls = new ArrayList<>();
        this.startColumn = startColumn;
        this.startRow = startRow;
        this.size = size;
        initBlock();
    }

    protected void initBlock(){
        // TODO
    }

    @Override
    public void draw(IScreen screen) {
        for (Field wall : walls)
            wall.draw(screen);
    }
}
