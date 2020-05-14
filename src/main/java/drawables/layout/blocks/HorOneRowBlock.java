package drawables.layout.blocks;

import drawables.layout.Wall;

public class HorOneRowBlock extends OneRowBlock {
    public HorOneRowBlock(Integer startColumn, Integer startRow, Integer size) {
        super(startColumn, startRow, size);
        initBlock();
    }

    @Override
    protected void initBlock(){
        for (int i = startColumn; i < startColumn + size; i++){
            Wall w1 = new Wall(i, startRow);
            walls.add(w1);
        }
    }
}
