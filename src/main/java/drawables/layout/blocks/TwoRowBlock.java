package drawables.layout.blocks;

import drawables.layout.Field;
import drawables.layout.Wall;
import screen.IScreen;

import java.util.ArrayList;

public abstract class TwoRowBlock extends Block {

    public TwoRowBlock(Integer startColumn, Integer startRow, Integer size){
        this.walls = new ArrayList<>();
        this.startColumn = startColumn;
        this.startRow = startRow;
        this.size = size;
    }

    protected void initBlock(){
        for (int i = startColumn; i < startColumn + size; i++){
            Wall w1 = new Wall(i, startRow);
            Wall w2 = new Wall(i, startRow + 1);

            walls.add(w1);
            walls.add(w2);
        }
    }

    @Override
    public void draw(IScreen screen) {
        for (Field wall : walls)
            wall.draw(screen);
    }
}
