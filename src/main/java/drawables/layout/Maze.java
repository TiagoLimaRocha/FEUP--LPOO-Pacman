package drawables.layout;

import drawables.IDrawable;
import drawables.agents.Pacman;
import drawables.agents.collectibles.Collectible;
import drawables.layout.blocks.Block;
import screen.IScreen;
import screen.Screen;
import step.Steppable;

import java.util.ArrayList;
import java.util.List;

/**
 * Map of the game, consists of fields
 *  - static variables: they are the same for the whole class
 */
public class Maze implements IDrawable, Steppable {

    private static List<Block> blocks;
    private static List<Field> fields;
    private static StatusDisplay statusDisplay;
    private static List<Collectible> collectibles;

    public Maze() {
        fields = new ArrayList<>();
        collectibles = new ArrayList<>();
        statusDisplay = new StatusDisplay();
    }

    @Override
    public void step() {
        this.draw(Screen.getScreen());
    }

    @Override
    public void draw(IScreen screen) {
        for (Block block : blocks)
            fields.addAll(block.walls);

        for (Field field : fields) {
            field.draw(screen);
        }

        statusDisplay.draw(screen);

        screen.display();
    }

    public static Field getField(Integer x, Integer y) {

        Field currField = null;
        Field wall = null;

        for (Field field : fields){
            if (field.getX().equals(x) && field.getY().equals(y)){
                if (field instanceof Wall){
                    wall = field;
                    break;
                }
                currField = field;
            }
        }

        if (wall != null)
            currField = wall;

        return currField;
    }

    public static void removeCollectible(Collectible collectible) {
        collectibles.remove(collectible);
    }

    public static void addCollectible(Collectible collectible) {
        collectibles.add(collectible);
    }

    // Getter setters
    public static List<Field> getFields() {
        return fields;
    }

    public static void setFields(List<Field> fields) {
        Maze.fields = fields;
    }

    public static void setBlocks(List<Block> blocks) { Maze.blocks = blocks; }

    public static List<Collectible> getCollectibles() {
        return collectibles;
    }

    public static void setCollectibles(List<Collectible> collectibles) {
        Maze.collectibles = collectibles;
    }
}
