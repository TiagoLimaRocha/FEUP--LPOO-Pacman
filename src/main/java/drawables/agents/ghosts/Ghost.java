package drawables.agents.ghosts;

import audio.SoundFX;
import behaviors.chase.ChaseBehavior;
import behaviors.frightened.FrightenedBehavior;
import behaviors.scatter.ScatterBehavior;
import drawables.agents.Agent;
import drawables.agents.MovingAgent;
import drawables.agents.Pacman;
import drawables.layout.Field;
import screen.IScreen;
import step.Steppable;

import utils.Consts;
import utils.Direction;
import utils.GhostStates;

import javax.sound.sampled.Clip;

public abstract class Ghost extends MovingAgent {

    protected State state;

    protected Integer speed;
    protected Integer lives;

    protected ChaseBehavior chaseBehavior;
    protected FrightenedBehavior frightenedBehavior;
    protected ScatterBehavior scatterBehavior;

    SoundFX eatenSound;

    public Ghost(){
        super();
        this.state = new State();
        this.direction = Direction.UP;
        this.eatenSound = new SoundFX("ghost_eaten.wav");

    }

    protected abstract void resetPosition();

    @Override
    public void collideWith(Agent otherAgent) {
        otherAgent.hitBy(this);
    }

    @Override
    public void hitBy(Pacman pacman) {
        if (this.state.isFrightened()){
            lives -= 1;
            pacman.munchGhost();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            eatenSound.play(eatenSound.getSoundFile());
            this.resetPosition();
        }
    }

    @Override
    public void hitBy(Ghost ghost){}

    // Getters Setters

    public State getState(){ return this.state; }

    public void setState(GhostStates newState){
        switch (newState){
            case SCATTER:
                state.setScatter();
                break;
            case CHASE:
                state.setChase();
                break;
            case FRIGHTENED:
                state.setFrightened();
                break;
            default:
                break;
        }
    }

    @Override
    public void setLives(Integer lives){ this.lives = lives; }

    public Integer getLives() { return lives; }

    public void setNextDirection(Pacman pacman){
        if (field.isIntersection(this)) {
            if (state.isScatter())
                nextDirection = scatterBehavior.scatter(direction);
            else if (state.isChase())
                nextDirection = chaseBehavior.chase(direction, pacman);
            else if (state.isFrightened())
                nextDirection = frightenedBehavior.wander(direction);
        }

    }
}
