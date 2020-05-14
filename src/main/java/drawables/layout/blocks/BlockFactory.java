package drawables.layout.blocks;

import utils.Blocks;

public class BlockFactory {
    public Block makeBlock(Blocks blockType, Integer startColumn, Integer startRow, Integer size, Integer offset){
        switch (blockType){
            case MAZE_BOUNDS:
                return new MazeBounds(startColumn, startRow, size);
            case GHOST_CAGE:
                return new GhostCage(startColumn, startRow, size);
            case HOR_ONE_ROW_BLOCK:
                return new HorOneRowBlock(startColumn, startRow, size);
            case VER_ONE_ROW_BLOCK:
                return new VerOneRowBlock(startColumn, startRow, size);
            case HOR_TWO_ROW_BLOCK:
                return new HorTwoRowBlock(startColumn, startRow, size);
            case VER_TWO_ROW_BLOCK:
                return new VerTwoRowBlock(startColumn, startRow, size);
            case HOR_THREE_ROW_BLOCK:
                return new HorThreeRowBlock(startColumn, startRow, size);
            case VER_THREE_ROW_BLOCK:
                return new VerThreeRowBlock(startColumn, startRow, size);
            case RIGHT_HOR_T_SHAPED_BLOCK:
                return new RightHorTShapeBlock(startColumn, startRow, size, offset);
            case LEFT_HOR_T_SHAPED_BLOCK:
                return new LeftHorTShapeBlock(startColumn, startRow, size, offset);
            case DOWN_VER_T_SHAPED_BLOCK:
                return new DownVerTShapeBlock(startColumn, startRow, size, offset);
            case UP_VER_T_SHAPED_BLOCK:
                return new UpVerTShapeBlock(startColumn, startRow, size, offset);
            case L_SHAPED_BLOCK:
                return new LShapeBlock(startColumn, startRow, size, offset);
            case CROSS_BLOCK:
                return new CrossBlock(startColumn, startRow, size);
            default:
                System.out.println("Invalid Block Type!");
                return null;
        }
    }
}
