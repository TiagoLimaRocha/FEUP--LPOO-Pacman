package drawables.layout.blocks;

import drawables.layout.Field;
import screen.IScreen;

import java.util.ArrayList;

public  class LShapeBlock extends Block {
    Integer offset;

    public LShapeBlock(Integer startColumn, Integer startRow, Integer size, Integer offset){
        this.walls = new ArrayList<>();
        this.startColumn = startColumn;
        this.startRow = startRow;
        this.size = size;
        this.offset = offset;

        initBlock();
    }

    @Override
    protected void initBlock() {

    }

    @Override
    public void draw(IScreen screen) {
        for (Field wall : walls)
            wall.draw(screen);
    }
}
