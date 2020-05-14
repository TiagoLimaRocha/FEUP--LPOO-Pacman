package drawables.layout.blocks;

import drawables.layout.Wall;

public class VerOneRowBlock extends OneRowBlock {
    public VerOneRowBlock(Integer startColumn, Integer startRow, Integer size) {
        super(startColumn, startRow, size);
        initBlock();
    }

    @Override
    protected void initBlock(){
        for (int i = startRow; i < startRow + size; i++){
            Wall w1 = new Wall(startColumn, i);
            walls.add(w1);
        }
    }
}