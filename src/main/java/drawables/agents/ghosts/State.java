package drawables.agents.ghosts;

public class State {
    private boolean chase, scatter, frightened;

    public State(){
        this.chase = false;
        this.scatter = true;
        this.frightened = false;
    }

    public boolean isChase(){ return this.chase; }
    public void setChase(){
        this.chase = true;
        this.scatter = false;
        this.frightened = false;
    }

    public boolean isScatter(){ return this.scatter; }
    public void setScatter(){
        this.chase = false;
        this.scatter = true;
        this.frightened = false;
    }

    public boolean isFrightened(){ return this.frightened; }
    public void setFrightened(){
        this.chase = false;
        this.scatter = false;
        this.frightened = true;

    }
}
