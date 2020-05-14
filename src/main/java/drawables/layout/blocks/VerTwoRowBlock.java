package drawables.layout.blocks;

import drawables.layout.Wall;

public class VerTwoRowBlock extends TwoRowBlock {
    public VerTwoRowBlock(Integer startColumn, Integer startRow, Integer size) {
        super(startColumn, startRow, size);
        initBlock();
    }

    protected void initBlock(){
        for (int i = startRow; i < startRow + size; i++){
            Wall w1 = new Wall(startColumn, i);
            Wall w2 = new Wall(startColumn + 1, i);

            walls.add(w1);
            walls.add(w2);
        }
    }
}
