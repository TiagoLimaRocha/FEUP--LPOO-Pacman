package drawables;

import screen.IScreen;

/**
 * Classes which can be drawn on the terminal window
 */
public interface IDrawable {
    /**
     * Draws itself on the given screen
     */
    void draw(IScreen screen);
}
