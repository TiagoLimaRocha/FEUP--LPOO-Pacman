package drawables.layout.blocks;

import drawables.layout.Field;
import drawables.layout.Wall;
import screen.IScreen;
import utils.Consts;

import java.util.ArrayList;

public class GhostCage extends Block {

    public GhostCage(Integer startColumn, Integer startRow, Integer size){
        this.walls = new ArrayList<>();
        this.startColumn = startColumn;
        this.startRow = startRow;
        this.size = size;
        initBlock();
    }

    protected void initBlock(){
        for (int i = startRow; i < startRow + 4; i++){
            Wall w1 = new Wall(startColumn, i);
            Wall w2 = new Wall(startColumn + 1, i);

            walls.add(w1);
            walls.add(w2);
        }

        for (int i = startRow; i < startRow + 4; i++){
            Wall w1 = new Wall(Consts.Maze.COLUMNS - startColumn, i);
            Wall w2 = new Wall(Consts.Maze.COLUMNS - 1 - startColumn, i);

            walls.add(w1);
            walls.add(w2);
        }

        for (int i = startColumn; i < startColumn + 10; i++){
            Wall w1 = new Wall(i, startRow + 3);
            walls.add(w1);
        }

        for (int i = startColumn; i < startColumn + 4; i++){
            Wall w1 = new Wall(i, startRow);
            walls.add(w1);
        }

        for (int i = startColumn + 6; i < startColumn + 10; i++){
            Wall w1 = new Wall(i, startRow);
            walls.add(w1);
        }
    }

    @Override
    public void draw(IScreen screen) {
        for (Field wall : walls)
            wall.draw(screen);
    }
}
