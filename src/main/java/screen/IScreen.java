package screen;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

/**
 * Interface of drawing on terminal window
 */
public interface IScreen {

    /**
     * Draws a character at given position with given color
     */
    void draw(Integer x, Integer y, char ch, TextColor color);

    /**
     * Draws graphics at given position with given color
     */
    void drawGfx(Integer x, Integer y, String str, TextColor color);


    /**
     * Refreshes the screen, have to be called after drawing
     */
    void display();

    /**
     * Gets input from keyboard when called
     */
    KeyStroke getInput();


    /**
     * Closes the screen
     */
    void close();

}
