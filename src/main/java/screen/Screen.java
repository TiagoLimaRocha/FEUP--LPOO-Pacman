package screen;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import utils.Consts;
import utils.ScreenType;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Singleton wrapper of Lanterna, implementing the screen interface
 *
 * used tutorial:
 * https://github.com/mabe02/lanterna/blob/master/docs/tutorial/Tutorial03.md
 */
public class Screen implements IScreen {

    private static Screen instance = null;
    private com.googlecode.lanterna.screen.Screen screen;
    private TextGraphics graphics;

    public static int nSecs = (int) System.currentTimeMillis() / 1000;

    public Screen(ScreenType st) {
        initScreen(st);
    }

    @Override
    public void draw(Integer x, Integer y, char ch, TextColor color) {
        screen.setCharacter(x, y,
                new TextCharacter(ch, color, Consts.Drawables.MAZE_COLOR)
        );
    }

    public void drawGfx(Integer x, Integer y, String str, TextColor color) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.setForegroundColor(color);
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(x, y, str);
    }


    @Override
    public void display() {
        try {
            screen.refresh();
            screen.clear();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            screen.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public KeyStroke getInput() {
        try {
            return screen.pollInput();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Screen getScreen(ScreenType st) {
        if (instance == null)
            instance = new Screen(st);
        else if (st == ScreenType.HIGHSCORES)
            instance = new Screen(st);

        return instance;
    }

    private void initScreen(ScreenType st) {

        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        File fontFile;
        Font font;
        GraphicsEnvironment ge;
        Terminal terminal;
        AWTTerminalFontConfiguration fontConfig;

        screen = null;

        try {

            switch (st){
                case GAME:
                    fontFile = new File("game_font.ttf");
                    font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);

                    ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                    ge.registerFont(font);

                    Font pacFont = font.deriveFont(Font.PLAIN, 16);
                    fontConfig = AWTTerminalFontConfiguration.newInstance(pacFont);

                    defaultTerminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);

                    break;

                case HIGHSCORES:
                    fontFile = new File("score_font.ttf");
                    font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);

                    ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                    ge.registerFont(font);

                    Font scoresFont = font.deriveFont(Font.PLAIN, 16);
                    fontConfig = AWTTerminalFontConfiguration.newInstance(scoresFont);

                    defaultTerminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);

                    break;
            }

            defaultTerminalFactory.setTerminalEmulatorTitle("PAC-MAN .txt edition");
            defaultTerminalFactory.setForceAWTOverSwing(true);
            defaultTerminalFactory.setInitialTerminalSize(new TerminalSize(200, 200));

            terminal = defaultTerminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.startScreen();
            screen.setCursorPosition(null);
            screen.doResizeIfNecessary();

            graphics = screen.newTextGraphics();

        } catch(IOException|FontFormatException e) {
            e.printStackTrace();
        }
    }
}
