package drawables.layout.blocks;

import drawables.layout.Wall;

public class HorTwoRowBlock extends TwoRowBlock {
    public HorTwoRowBlock(Integer startColumn, Integer startRow, Integer size) {
        super(startColumn, startRow, size);
        initBlock();
    }

    protected void initBlock(){
        for (int i = startColumn; i < startColumn + size; i++){
            Wall w1 = new Wall(i, startRow);
            Wall w2 = new Wall(i, startRow + 1);

            walls.add(w1);
            walls.add(w2);
        }
    }
}
