package utils;

import drawables.agents.collectibles.Collectible;
import drawables.agents.collectibles.Dot;
import drawables.agents.collectibles.Energizer;
import drawables.layout.Field;
import drawables.layout.Maze;
import drawables.layout.blocks.Block;
import drawables.layout.blocks.BlockFactory;

import java.util.ArrayList;
import java.util.List;

import static utils.Blocks.*;

public class MazeBuilder {

    public List<Field> loadFields(){
        List<Field> fields = new ArrayList<>();

        for (int i = 1; i < Consts.Maze.COLUMNS; i++) {
            for (int j = 1; j < Consts.Maze.ROWS; j++) {
                Field field = new Field(i, j);

                if (!((i >= 37 && i < 44) && (j >= 8 && j <= 11))) {
                    if (i % 2 == 0){
                        Collectible dot = new Dot();

                        dot.setField(field);
                        Maze.addCollectible(dot);
                        field.addAgent(dot);

                    }
                }

                if ( (i == 1 && j == 1)
                        || (i == 1 && j == (Consts.Maze.ROWS - 1))
                        || (i == (Consts.Maze.COLUMNS - 1) && j == 1)
                        || (i == (Consts.Maze.COLUMNS - 1) && j == (Consts.Maze.ROWS - 1)) ) {

                    Collectible energizer = new Energizer();

                    energizer.setField(field);
                    Maze.addCollectible(energizer);
                    field.addAgent(energizer);
                }

                fields.add(field);
            }
        }

        return fields;
    }

    public List<Block> loadBlocks(){
        List<Block> blocks = new ArrayList<>();

        BlockFactory blockFactory = new BlockFactory();

        Block b1 = blockFactory.makeBlock(MAZE_BOUNDS, 0, 0, 0, 0); blocks.add(b1);
        Block b2 = blockFactory.makeBlock(GHOST_CAGE, 35, 8, 0, 0); blocks.add(b2);
        Block b68 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, 35, 6, 10, 0); blocks.add(b68);
        Block b3 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, 2, 2, 9, 0); blocks.add(b3);
        Block b4 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, 12, 2, 12, 0); blocks.add(b4);
        Block b5 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, 2, 6, 9, 0); blocks.add(b5);
        Block b6 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, Consts.Maze.COLUMNS - 1 - 9, 6, 9, 0); blocks.add(b6);
        Block b7 = blockFactory.makeBlock(RIGHT_HOR_T_SHAPED_BLOCK, 12, 6, 14, 7); blocks.add(b7);
        Block b8 = blockFactory.makeBlock(LEFT_HOR_T_SHAPED_BLOCK, 12 + 1, 6, 13, 6); blocks.add(b8);
        Block b9 = blockFactory.makeBlock(HOR_TWO_ROW_BLOCK, 15, 6, 11, 0); blocks.add(b9);
        Block b10 = blockFactory.makeBlock(HOR_TWO_ROW_BLOCK, Consts.Maze.COLUMNS - 14 - 11, 6, 11, 0); blocks.add(b10);
        Block b11 = blockFactory.makeBlock(HOR_TWO_ROW_BLOCK, 15, 11, 11, 0); blocks.add(b11);
        Block b12 = blockFactory.makeBlock(HOR_TWO_ROW_BLOCK, Consts.Maze.COLUMNS - 14 - 11, 11, 11, 0); blocks.add(b12);
        Block b13 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, 1, 10, 10, 0); blocks.add(b13);
        Block b14 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, Consts.Maze.COLUMNS - 10, 10, 10, 0); blocks.add(b14);
        Block b15 = blockFactory.makeBlock(HOR_TWO_ROW_BLOCK, 1, 14, 10, 0); blocks.add(b15);
        Block b16 = blockFactory.makeBlock(HOR_TWO_ROW_BLOCK, Consts.Maze.COLUMNS - 10, 14, 10, 0); blocks.add(b16);
        Block b17 = blockFactory.makeBlock(VER_TWO_ROW_BLOCK, 27, 6, 7, 0); blocks.add(b17);
        Block b18 = blockFactory.makeBlock(VER_TWO_ROW_BLOCK, Consts.Maze.COLUMNS - 27 - 1, 6, 7, 0); blocks.add(b18);
        Block b19 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, 30, 6, 4, 0); blocks.add(b19);
        Block b20 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, Consts.Maze.COLUMNS - 30 - 3, 6, 4, 0); blocks.add(b20);
        Block b21 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, 30, 10, 4, 0); blocks.add(b21);
        Block b22 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, Consts.Maze.COLUMNS - 30 - 3, 10, 4, 0); blocks.add(b22);
        Block b23 = blockFactory.makeBlock(DOWN_VER_T_SHAPED_BLOCK, 35, 13, 10, 5); blocks.add(b23);
        Block b24 = blockFactory.makeBlock(VER_TWO_ROW_BLOCK, 25, 1, 4, 0); blocks.add(b24);
        Block b25 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, 28, 2, 8, 0); blocks.add(b25);
        Block b26 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, 37, 2, 7, 0); blocks.add(b26);
        Block b27 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, 45, 2, 8, 0); blocks.add(b27);
        Block b28 = blockFactory.makeBlock(VER_TWO_ROW_BLOCK, 54, 1, 4, 0); blocks.add(b28);
        Block b29 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, 57, 2, 11, 0); blocks.add(b29);
        Block b30 = blockFactory.makeBlock(HOR_THREE_ROW_BLOCK, 69, 2, 9, 0); blocks.add(b30);
        Block b31 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, 0, Consts.Maze.ROWS-4, 4, 0); blocks.add(b31);
        Block b32 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, Consts.Maze.COLUMNS - 3, Consts.Maze.ROWS-4, 4, 0); blocks.add(b32);
        Block b33 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, 12, 14, 6, 0); blocks.add(b33);
        Block b34 = blockFactory.makeBlock(DOWN_VER_T_SHAPED_BLOCK, 12, 15, 6, 3); blocks.add(b34);
        Block b35 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, Consts.Maze.COLUMNS - 11 - 6, 14, 6, 0); blocks.add(b35);
        Block b36 = blockFactory.makeBlock(DOWN_VER_T_SHAPED_BLOCK, Consts.Maze.COLUMNS - 11 - 6, 15, 6, 3); blocks.add(b36);
        Block b37 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, 17, 17, 9, 0); blocks.add(b37);
        Block b38 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, Consts.Maze.COLUMNS - 16 - 9, 17, 9, 0); blocks.add(b38);
        Block b39 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, 27, 17, 11, 0); blocks.add(b39);
        Block b40 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, Consts.Maze.COLUMNS - 26 - 11, 17, 11, 0); blocks.add(b40);
        Block b41 = blockFactory.makeBlock(HOR_TWO_ROW_BLOCK, 19, 14, 4, 0); blocks.add(b41);
        Block b42 = blockFactory.makeBlock(HOR_TWO_ROW_BLOCK, Consts.Maze.COLUMNS - 18 - 4, 14, 4, 0); blocks.add(b42);
        Block b43 = blockFactory.makeBlock(HOR_TWO_ROW_BLOCK, 24, 14, 3, 0); blocks.add(b43);
        Block b44 = blockFactory.makeBlock(HOR_TWO_ROW_BLOCK, Consts.Maze.COLUMNS - 23 - 3, 14, 3, 0); blocks.add(b44);
        Block b45 = blockFactory.makeBlock(HOR_TWO_ROW_BLOCK, 28, 14, 5, 0); blocks.add(b45);
        Block b46 = blockFactory.makeBlock(HOR_TWO_ROW_BLOCK, Consts.Maze.COLUMNS - 27 - 5, 14, 5, 0); blocks.add(b46);
        Block b47 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, 34, 15, 4, 0); blocks.add(b47);
        Block b48 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, Consts.Maze.COLUMNS - 33 - 4, 15, 4, 0); blocks.add(b48);
        Block b49 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, 2, Consts.Maze.ROWS-6, 11, 0); blocks.add(b49);
        Block b50 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, Consts.Maze.COLUMNS - 1 - 11, Consts.Maze.ROWS-6, 11, 0); blocks.add(b50);
        Block b51 = blockFactory.makeBlock(VER_TWO_ROW_BLOCK, 5, Consts.Maze.ROWS - 6, 3, 0); blocks.add(b51);
        Block b52 = blockFactory.makeBlock(VER_TWO_ROW_BLOCK, Consts.Maze.COLUMNS - 6, Consts.Maze.ROWS - 6, 3, 0); blocks.add(b52);
        Block b53 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, 2, Consts.Maze.ROWS - 2, 11, 0); blocks.add(b53);
        Block b54 = blockFactory.makeBlock(HOR_ONE_ROW_BLOCK, Consts.Maze.COLUMNS - 1 - 11, Consts.Maze.ROWS - 2, 11, 0); blocks.add(b54);
        Block b55 = blockFactory.makeBlock(VER_TWO_ROW_BLOCK, 8, Consts.Maze.ROWS - 4, 3, 0); blocks.add(b55);
        Block b56 = blockFactory.makeBlock(VER_TWO_ROW_BLOCK, Consts.Maze.COLUMNS - 9, Consts.Maze.ROWS - 4, 3, 0); blocks.add(b56);
        Block b57 = blockFactory.makeBlock(DOWN_VER_T_SHAPED_BLOCK, 12, Consts.Maze.ROWS - 4, 6, 3); blocks.add(b57);
        Block b58 = blockFactory.makeBlock(DOWN_VER_T_SHAPED_BLOCK, Consts.Maze.COLUMNS - 11 - 6, Consts.Maze.ROWS - 4, 6, 3); blocks.add(b58);
        Block b59 = blockFactory.makeBlock(UP_VER_T_SHAPED_BLOCK, 17, Consts.Maze.ROWS - 2, 6, 3); blocks.add(b59);
        Block b60 = blockFactory.makeBlock(UP_VER_T_SHAPED_BLOCK, Consts.Maze.COLUMNS - 16 - 6, Consts.Maze.ROWS - 2, 6, 3); blocks.add(b60);
        Block b61 = blockFactory.makeBlock(DOWN_VER_T_SHAPED_BLOCK, 22, Consts.Maze.ROWS - 4, 6, 3); blocks.add(b61);
        Block b62 = blockFactory.makeBlock(DOWN_VER_T_SHAPED_BLOCK, Consts.Maze.COLUMNS - 21 - 6, Consts.Maze.ROWS - 4, 6, 3); blocks.add(b62);
        Block b63 = blockFactory.makeBlock(UP_VER_T_SHAPED_BLOCK, 27, Consts.Maze.ROWS - 2, 6, 3); blocks.add(b63);
        Block b64 = blockFactory.makeBlock(UP_VER_T_SHAPED_BLOCK, Consts.Maze.COLUMNS - 26 - 6, Consts.Maze.ROWS - 2, 6, 3); blocks.add(b64);
        Block b65 = blockFactory.makeBlock(DOWN_VER_T_SHAPED_BLOCK, 32, Consts.Maze.ROWS - 4, 6, 3); blocks.add(b65);
        Block b66 = blockFactory.makeBlock(DOWN_VER_T_SHAPED_BLOCK, Consts.Maze.COLUMNS - 31 - 6, Consts.Maze.ROWS - 4, 6, 3); blocks.add(b66);
        Block b67 = blockFactory.makeBlock(UP_VER_T_SHAPED_BLOCK, 37, Consts.Maze.ROWS - 2, 6, 3); blocks.add(b67);

        return blocks;
    }
}
