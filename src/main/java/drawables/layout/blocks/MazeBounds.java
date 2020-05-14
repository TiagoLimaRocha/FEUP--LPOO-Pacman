package drawables.layout.blocks;

import drawables.layout.Field;
import drawables.layout.Wall;
import screen.IScreen;
import utils.Consts;

import java.util.ArrayList;

public class MazeBounds extends Block {

    public MazeBounds(Integer startColumn, Integer startRow, Integer size){
        this.walls = new ArrayList<>();
        this.startColumn = startColumn;
        this.startRow = startRow;
        this.size = size;
        initBlock();
    }

    protected void initBlock(){
        // Upper and bottom bounds
        for (int i = startColumn; i < Consts.Maze.COLUMNS; i++) {
            Wall up = new Wall(i, 0);
            Wall down = new Wall(i, Consts.Maze.ROWS);

            walls.add(up);
            walls.add(down);
        }
        // Right and left bounds
        for (int j = startRow; j < Consts.Maze.ROWS; j++) {
            if (j != 13) {
                Wall left = new Wall(0, j);
                Wall right = new Wall(Consts.Maze.COLUMNS, j);

                walls.add(left);
                walls.add(right);
            }
        }
    }

    @Override
    public void draw(IScreen screen) {
        for (Field wall : walls)
            wall.draw(screen);
    }
}
