package sk.tuke.gamestudio.core;

public class Goal implements Tile, Reacheble {
    boolean isReached;

    public Goal() {
        this.isReached = true;
    }

    public boolean isReached() {
        return isReached;
    }

    public void setReached(boolean reached) {
        isReached = reached;
    }
}
