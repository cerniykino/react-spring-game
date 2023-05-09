package sk.tuke.gamestudio.core;

public class Goal implements Tile, Reacheble {
    boolean isReached;
    boolean playerPresent;
    public Goal() {
        this.isReached = true;
        this.playerPresent = false;
    }

    public boolean isReached() {
        return isReached;
    }

    public void setReached(boolean reached) {
        isReached = reached;
    }

    public boolean isPlayerPresent() {
        return playerPresent;
    }

    public void setPlayerPresent(boolean playerPresent) {
        this.playerPresent = playerPresent;
    }

    @Override
    public void setPlayer(boolean presence) {
        this.playerPresent = presence;
    }
}
