import audio.SoundFX;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import drawables.agents.Pacman;
import drawables.agents.ghosts.*;
import drawables.layout.*;
import drawables.layout.blocks.Block;

import screen.IScreen;
import screen.Screen;

import step.Timer;
import utils.*;

import javax.sound.sampled.Clip;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) throws Exception {
        IScreen screen = Screen.getScreen(ScreenType.GAME);

        startScreen(screen);
        initGame(screen);
    }

    private static void startScreen(IScreen screen) throws InterruptedException {
        StartScreen startScreen  = new StartScreen();
        Timer timer = Timer.getTimer();
        timer.addSteppable(startScreen);

        SoundFX startThemeSong = new SoundFX("pacman_theme.wav");
        SoundFX btnPressSound = new SoundFX("btn_press.wav");

        Clip startThemeClip = startThemeSong.play(startThemeSong.getSoundFile());

        while (true){
            KeyStroke keyStroke1 = screen.getInput();

            if (keyStroke1 != null && (keyStroke1.getKeyType() == KeyType.Enter
                    || keyStroke1.getKeyType() == KeyType.EOF)) {

                startThemeSong.stop(startThemeClip);
                btnPressSound.play(btnPressSound.getSoundFile());
                timer.removeSteppable(startScreen);
                break;
            }
        }

        Thread.sleep(500);
    }

    private static void initGame(IScreen screen) throws InterruptedException {
        Maze maze = new Maze();
        MazeBuilder builder =  new MazeBuilder();

        List<Block> blocks = builder.loadBlocks();
        List<Field> fields = builder.loadFields();

        Maze.setFields(fields);
        Maze.setBlocks(blocks);

        // audio
        SoundFX introSound = new SoundFX("intro.wav");
        SoundFX sirenSound = new SoundFX("siren_1.wav");

        // Placing Pacman
        Field pacmanField = Maze.getField(10, 5);
        pacmanField.setAgents(new ArrayList<>());

        Pacman pacman = new Pacman();
        pacman.setField(pacmanField);
        pacman.setLives(Consts.Pacman.MAX_LIVES);
        pacmanField.addAgent(pacman);

        // Placing the Ghosts
        // Inky
        Field inkyField = Maze.getField(39, 9);
        inkyField.setAgents(new ArrayList<>());

        Ghost inky = new Inky();
        inky.setField(inkyField);
        inky.setLives(99);
        inkyField.addAgent(inky);

        // Blinky
        Field blinkyField = Maze.getField(40, 9);
        blinkyField.setAgents(new ArrayList<>());

        Ghost blinky = new Blinky();
        blinky.setField(blinkyField);
        blinky.setLives(99);
        blinkyField.addAgent(blinky);

        // Pinky
        Field pinkyField = Maze.getField(39, 10);
        pinkyField.setAgents(new ArrayList<>());

        Ghost pinky = new Pinky();
        pinky.setField(pinkyField);
        pinky.setLives(99);
        pinkyField.addAgent(pinky);

        // Clyde
        Field clydeField = Maze.getField(40, 10);
        clydeField.setAgents(new ArrayList<>());

        Ghost clyde = new Clyde();
        clyde.setField(clydeField);
        clyde.setLives(99);
        clydeField.addAgent(clyde);

        // Render
        maze.draw(screen);

        // Delay 4 seconds
        introSound.play(introSound.getSoundFile());
        Thread.sleep(4080);

        // Steppables
        Timer timer = Timer.getTimer();

        timer.addSteppable(pacman);
        timer.addSteppable(inky);
        timer.addSteppable(blinky);
        timer.addSteppable(pinky);
        timer.addSteppable(clyde);
        timer.addSteppable(maze);

        Clip sirenClip = sirenSound.loopPlay(sirenSound.getSoundFile());

        ScoreSaver pointSaver = new ScoreSaver();

        // Game Loop
        while (true){
            KeyStroke keyStroke2 = screen.getInput();
            long currTime = System.currentTimeMillis();

            // Moving Pacman to direction of key press
            Direction direction = keyToDir(keyStroke2);
            if (direction != null)
                pacman.setNextDirection(direction);

            if (pacman.isSuperStronk()){
                sirenSound.stop(sirenClip);

                inky.setState(GhostStates.FRIGHTENED);
                blinky.setState(GhostStates.FRIGHTENED);
                pinky.setState(GhostStates.FRIGHTENED);
                clyde.setState(GhostStates.FRIGHTENED);

                if (currTime >= pacman.getStrongModeTime()){
                    pacman.becomeMortal();
                    sirenClip = sirenSound.loopPlay(sirenSound.getSoundFile());
                }
            } else {
                inky.setState(GhostStates.CHASE);
                blinky.setState(GhostStates.CHASE);
                pinky.setState(GhostStates.CHASE);
                clyde.setState(GhostStates.CHASE);
            }

            inky.setNextDirection(pacman);
            blinky.setNextDirection(pacman);
            pinky.setNextDirection(pacman);
            clyde.setNextDirection(pacman);

            if (keyStroke2 != null && (keyStroke2.getKeyType() == KeyType.Escape
                    || keyStroke2.getKeyType() == KeyType.EOF)){

                sirenSound.stop(sirenClip);

                timer.removeSteppable(pacman);
                timer.removeSteppable(inky);
                timer.removeSteppable(blinky);
                timer.removeSteppable(pinky);
                timer.removeSteppable(clyde);
                timer.removeSteppable(maze);

                break;
            }

            if (Pacman.getLives() == 0){
                sirenSound.stop(sirenClip);
                pointSaver.save();

                timer.removeSteppable(pacman);
                timer.removeSteppable(inky);
                timer.removeSteppable(blinky);
                timer.removeSteppable(pinky);
                timer.removeSteppable(clyde);
                timer.removeSteppable(maze);

                break;
            }
        }

        gameOver(screen);
    }

    private static void highScores(IScreen screen) throws InterruptedException {
        HighscoreScreen highscoreScreen = new HighscoreScreen();
        highscoreScreen.draw(screen);

        SoundFX btnPressSound = new SoundFX("btn_press.wav");

        while (true){
            KeyStroke keyStroke = screen.getInput();

             if (keyStroke != null && (keyStroke.getKeyType() == KeyType.Escape
                    || keyStroke.getKeyType() == KeyType.EOF)){

                // CLOSE GAME
                btnPressSound.play(btnPressSound.getSoundFile());
                Thread.sleep(100);
                screen.close();

                return;
            }
        }
    }

    private static void gameOver(IScreen screen) throws InterruptedException {
        GameOverScreen gameOverScreen  = new GameOverScreen();
        gameOverScreen.draw(screen);

        SoundFX btnPressSound = new SoundFX("btn_press.wav");

        while (true){
            KeyStroke keyStroke3 = screen.getInput();

            if (keyStroke3 != null && (keyStroke3.getKeyType() == KeyType.Enter
                    || keyStroke3.getKeyType() == KeyType.EOF)){

                // RESET GAME
                btnPressSound.play(btnPressSound.getSoundFile());
                break;
            } else if (keyStroke3 != null && (keyStroke3.getKeyType() == KeyType.Escape
                    || keyStroke3.getKeyType() == KeyType.EOF)){

                // HIGHSCORES
                btnPressSound.play(btnPressSound.getSoundFile());
                Thread.sleep(100);

                screen.close();

                IScreen ScoresScreen = Screen.getScreen(ScreenType.HIGHSCORES);
                highScores(ScoresScreen);

                return;
            }
        }

        initGame(screen);
    }

    /**
     * Converts key to Direction enum, if no key given returns null
     */
    private static Direction keyToDir(KeyStroke keyStroke) {
        if (keyStroke != null) {
            KeyType keyType = keyStroke.getKeyType();
            if (keyType == KeyType.ArrowUp)
                return Direction.UP;
            else if (keyType == KeyType.ArrowDown)
                return Direction.DOWN;
            else if (keyType == KeyType.ArrowRight)
                return Direction.RIGHT;
            else if (keyType == KeyType.ArrowLeft)
                return Direction.LEFT;
            else
                return null;
        }
        return null;
    }
}