package sk.tuke.gamestudio.core;

public class EmptySpace implements Tile, Reacheble {
    private boolean isPlayer;

    public EmptySpace() {
        this.isPlayer = false;
    }

    public boolean isPlayerPresent() {
        return isPlayer;
    }

    public void setPlayer(boolean player) {
        isPlayer = player;
    }
}
