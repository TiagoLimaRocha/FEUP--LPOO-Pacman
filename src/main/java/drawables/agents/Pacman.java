package drawables.agents;

import audio.SoundFX;

import com.googlecode.lanterna.TextColor;
import drawables.agents.ghosts.Ghost;
import drawables.layout.Maze;

import screen.IScreen;

import utils.Consts;

import javax.sound.sampled.Clip;


public class Pacman extends MovingAgent {

    private static Integer points;
    private static Integer lives;
    private boolean superStronk;

    private SoundFX munchSound1;
    private SoundFX munchSound2;
    private SoundFX eatGhostSound;
    private SoundFX eatFruitSound;
    private SoundFX deathSound;
    private SoundFX strongModeSound;

    public Clip strongModeClip;
    private long strongModeTime;

    public Pacman() {
        super();
        this.points = 0;
        this.direction = Consts.Pacman.STARTING_DIRECTION;

        this.superStronk = false;

        this.munchSound1 = new SoundFX("munch_1.wav");
        this.munchSound2 = new SoundFX("munch_2.wav");
        this.eatGhostSound = new SoundFX("eat_ghost.wav");
        this.eatFruitSound = new SoundFX("eat_fruit.wav");
        this.deathSound = new SoundFX("death.wav");
        this.strongModeSound = new SoundFX("frightened.wav");

    }

    @Override
    public void collideWith(Agent otherAgent) {
        otherAgent.hitBy(this);
    }

    @Override
    public void hitBy(Pacman pacman) {}

    @Override
    public void hitBy(Ghost ghost){
        if (ghost.getState().isFrightened())
            this.addPoints((int) ((Integer) (Consts.Pacman.POINT_INCREMENT * 20) + (Consts.Pacman.POINT_INCREMENT * 10 * (100-lives) * 0.1)));
        else {
            try {
                this.die();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void becomeStronk(){
        if (!superStronk){
            strongModeTime = System.currentTimeMillis() + 10000;

            this.superStronk = true;
            this.strongModeClip = strongModeSound.loopPlay(strongModeSound.getSoundFile());
        }
    }

    public long getStrongModeTime(){ return this.strongModeTime; }

    public void becomeMortal(){
        this.superStronk = false;
        strongModeSound.stop(strongModeClip);
    }

    public boolean isSuperStronk(){ return this.superStronk; }

    public void munch(){
        munchSound1.play(munchSound1.getSoundFile());
        munchSound2.play(munchSound2.getSoundFile());
    }

    public void munchGhost(){
        eatGhostSound.play(eatGhostSound.getSoundFile());
    }

    public void munchFruit(){
        eatFruitSound.play(eatFruitSound.getSoundFile());
    }

    public void die() throws InterruptedException {
        if (lives > 0){
            lives -= 1;
            this.resetPosition();

            Clip deathClip = deathSound.play(deathSound.getSoundFile());
            Thread.sleep(1500);
            deathSound.stop(deathClip);
        }
    }

    public void resetPosition(){
        removed = true;

        field = Maze.getField(10, 5);
        field.addAgent(this);
    }

    @Override
    public void draw(IScreen screen) {
        screen.draw(
            field.getX(), field.getY(),
            Consts.Drawables.PACMAN,
            Consts.Drawables.PACMAN_COLOR
        );
    }

    public void addPoints(Integer points) {
        this.points += points;
    }

    // Getters setters

    public static Integer getPoints() {
        return points;
    }

    public static Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }
}
