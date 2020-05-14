package drawables.layout.blocks;

import drawables.layout.Wall;

public class HorThreeRowBlock extends ThreeRowBlock {
    public HorThreeRowBlock(Integer startColumn, Integer startRow, Integer size) {
        super(startColumn, startRow, size);
        initBlock();
    }

    protected void initBlock(){
        for (int i = startColumn; i < startColumn + size; i++){
            Wall w1 = new Wall(i, startRow);
            Wall w2 = new Wall(i, startRow + 1);
            Wall w3 = new Wall(i, startRow + 2);

            walls.add(w1);
            walls.add(w2);
            walls.add(w3);
        }
    }
}
