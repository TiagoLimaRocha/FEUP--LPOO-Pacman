package drawables.layout.blocks;

import drawables.layout.Wall;
import utils.Consts;

public class LeftHorTShapeBlock extends TShapeBlock {
    public LeftHorTShapeBlock(Integer startColumn, Integer startRow, Integer size, Integer offset) {
        super(startColumn, startRow, size, offset);
        initBlock();
    }

    @Override
    protected void initBlock(){
        // horizontal wall
        for (int i = startColumn; i < startColumn + size; i++){
            Wall w1 = new Wall(Consts.Maze.COLUMNS - i, startRow + (int) Math.ceil((size-offset)/2));
            walls.add(w1);
        }

        // vertical walls
        for (int i = startRow; i < startRow + size - offset; i++){
            Wall w1 = new Wall(Consts.Maze.COLUMNS - startColumn, i);
            Wall w2 = new Wall(Consts.Maze.COLUMNS - startColumn + 1, i);

            walls.add(w1);
            walls.add(w2);
        }
    }
}
