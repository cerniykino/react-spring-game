package sk.tuke.gamestudio.core;

public class EmptySpace implements Tile, Reacheble {

    private boolean upBlocked = false;
    private boolean downBlocked = false;
    private boolean leftBlocked = false;
    private boolean rightBlocked = false;
    private boolean blocked = false;
    private boolean isPlayer;

    public EmptySpace() {
        this.isPlayer = false;
    }

    public EmptySpace(boolean upBlocked, boolean downBlocked, boolean leftBlocked, boolean rightBlocked, boolean blocked) {
        this.upBlocked = upBlocked;
        this.downBlocked = downBlocked;
        this.leftBlocked = leftBlocked;
        this.rightBlocked = rightBlocked;
        this.blocked = blocked;
        this.isPlayer = false;
    }

    public boolean isPlayerPresent() {
        return isPlayer;
    }

    public void setPlayer(boolean player) {
        isPlayer = player;
    }

    public boolean isUpBlocked() {
        return upBlocked;
    }

    public void setUpBlocked(boolean upBlocked) {
        this.upBlocked = upBlocked;
    }

    public boolean isDownBlocked() {
        return downBlocked;
    }

    public void setDownBlocked(boolean downBlocked) {
        this.downBlocked = downBlocked;
    }

    public boolean isLeftBlocked() {
        return leftBlocked;
    }

    public void setLeftBlocked(boolean leftBlocked) {
        this.leftBlocked = leftBlocked;
    }

    public boolean isRightBlocked() {
        return rightBlocked;
    }

    public void setRightBlocked(boolean rightBlocked) {
        this.rightBlocked = rightBlocked;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "EmptySpace{" +
                "upBlocked=" + upBlocked +
                ", downBlocked=" + downBlocked +
                ", leftBlocked=" + leftBlocked +
                ", rightBlocked=" + rightBlocked +
                ", blocked=" + blocked +
                ", isPlayer=" + isPlayer +
                '}';
    }
}
