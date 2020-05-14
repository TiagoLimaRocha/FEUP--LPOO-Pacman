package behaviors.chase;

import drawables.agents.Pacman;
import utils.Direction;

public interface ChaseBehavior {
    Direction chase(Direction currDir, Pacman pacman);
}
