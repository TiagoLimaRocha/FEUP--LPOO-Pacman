package drawables.layout;

import drawables.IDrawable;
import drawables.agents.Agent;
import screen.IScreen;
import utils.Consts;
import utils.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit of motion
 *  - has coordinate
 *  - stores agents: things which are currently on the field
 */
public class Field implements IDrawable {

    protected Integer x;
    protected Integer y;

    private Boolean locked = false;
    private List<Agent> agents;

    public Field(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        agents = new ArrayList<>();
    }

    /**
     * Lets an agent step on it (Pacman or Ghost)
     *   - after that it meets with every new agent
     */
    public boolean accept(Agent agent) {
        if (!locked) {
            locked = true;

            List<Agent> agentsDup = agents;

            for (Agent otherAgent : agentsDup)
                agent.collideWith(otherAgent);

            agents.removeIf(Agent::isRemoved);

            locked = false;
            return true;
        }
        return true;
    }

    @Override
    public void draw(IScreen screen) {
        for (Agent agent : agents)
            agent.draw(screen);
    }

    public Field getNeighbor(Direction direction) {
        switch (direction){
            case UP:
                return Maze.getField(x, y - 1);
            case DOWN:
                return Maze.getField(x, y + 1);
            case RIGHT:
                if (x == (Consts.Maze.COLUMNS - 1) && y == 13)
                    return Maze.getField(1, 13);
                else
                    return Maze.getField(x + 1, y);
            case LEFT:
                if (x == 1 && y == 13)
                    return Maze.getField(Consts.Maze.COLUMNS - 1,13);
                else
                    return Maze.getField(x - 1, y);
            default:
                return null;
        }
    }

    public boolean isIntersection(Agent agent){

        Field neighborUp = this.getNeighbor(Direction.UP);
        Field neighborDown = this.getNeighbor(Direction.DOWN);
        Field neighborLeft = this.getNeighbor(Direction.LEFT);
        Field neighborRight = this.getNeighbor(Direction.RIGHT);

        boolean isAnIntersection;

        if ( (neighborUp.accept(agent) && neighborLeft.accept(agent)) ||
                (neighborUp.accept(agent) && neighborRight.accept(agent)) ||
                (neighborDown.accept(agent) && neighborLeft.accept(agent)) ||
                (neighborDown.accept(agent) && neighborRight.accept(agent)) ){

            isAnIntersection = true;
        } else
            isAnIntersection = false;

        return isAnIntersection;
    }

    public void addAgent(Agent agent) {
        this.agents.add(agent);
    }

    public void removeAgent(Agent agent) {
        this.agents.remove(agent);
    }

    // Getters setters

    public List<Agent> getAgents() { return agents; }

    public void setAgents(List<Agent> agents) { this.agents = agents; }

    public Integer getX() { return x; }

    public void setX(Integer x) { this.x = x; }

    public Integer getY() { return y; }

    public void setY(Integer y) { this.y = y; }
}
