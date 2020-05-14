package utils;

import com.googlecode.lanterna.TextColor;

public class Consts {
    private Consts() {}

    public static class Maze {
        private Maze() {}

        public static final Integer COLUMNS = 79;
        public static final Integer ROWS = 23;
    }

    public static class Pacman {
        private Pacman() {}

        public static final Integer MAX_LIVES = 3;
        public static final Integer POINT_INCREMENT = 10;
        public static final String SCORES_FILE = "scores.txt";
        public static final Direction STARTING_DIRECTION = Direction.RIGHT;
    }

    public static class Drawables {
        private Drawables() {}

        public static final TextColor YELLOW = new TextColor.RGB(255, 243, 29);
        public static final TextColor LIGHT_YELLOW = new TextColor.RGB(255, 255, 153);
        public static final TextColor CYAN  = new TextColor.RGB(0, 255, 255);
        public static final TextColor PINK  = new TextColor.RGB(255, 20, 147);
        public static final TextColor RED  = new TextColor.RGB(255, 0, 0);
        public static final TextColor ORANGE  = new TextColor.RGB(255, 69, 0);
        public static final TextColor WHITE  = new TextColor.RGB(255, 255, 255);

        public static final TextColor MAZE_COLOR = TextColor.ANSI.BLACK;

        public static final char WALL = 'x';
        public static final TextColor WALL_COLOR = TextColor.ANSI.BLUE;

        public static final char PACMAN = '1';
        public static final TextColor PACMAN_COLOR = YELLOW;

        public static final char DOT = '2';
        public static final TextColor DOT_COLOR = LIGHT_YELLOW;

        public static final char ENERGIZER = 'o';
        public static final TextColor ENERGIZER_COLOR = WHITE;

        public static final char INKY = '9';
        public static final TextColor INKY_COLOR = CYAN;

        public static final char BLINKY = '9';
        public static final TextColor BLINKY_COLOR = RED;

        public static final char PINKY = '9';
        public static final TextColor PINKY_COLOR = PINK;

        public static final char CLYDE = '9';
        public static final TextColor CLYDE_COLOR = ORANGE;

        public static final char LIFE = 'C';
        public static final TextColor LIFE_COLOR = YELLOW;

    }

    public static class Timing {
        private Timing() {}

        public static final Integer STEP_PERIOD_MS = 100;
        public static final Integer STARTING_DELAY_MS = 1000;
    }

}
