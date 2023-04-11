package sk.tuke.gamestudio.level;

import sk.tuke.gamestudio.core.EmptySpace;
import sk.tuke.gamestudio.core.Player;
import sk.tuke.gamestudio.core.Tile;

public abstract class BaseLevel implements LevelInterface {

    private final int width;
    private final int height;
    private int playerX;
    private int playerY;
    private int goals;
    private int minSteps;

    private final Tile[][] field;

    public BaseLevel(int width, int height, int playerX, int playerY, int goals, int minSteps, Tile[][] field) {
        this.width = width;
        this.height = height;
        this.playerX = playerX;
        this.playerY = playerY;
        this.field = field;
        this.goals = goals;
        this.minSteps = minSteps;
        setPlayerPresence(true);
    }


    @Override
    public void setPlayerPresence(boolean presence) {
        if (field[playerY][playerX] instanceof EmptySpace)
            ((EmptySpace) (field[playerY][playerX])).setPlayer(presence);
    }

    public Tile[][] getField() {
        return field;
    }

    @Override
    public void setPlayerCoordinates(Player player) {
        this.playerX = player.getX();
        this.playerY = player.getY();
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getPlayerX() {
        return playerX;
    }

    @Override
    public int getPlayerY() {
        return playerY;
    }

    @Override
    public int getGoals() {
        return goals;
    }

    @Override
    public void setGoals(int goals) {
        this.goals = goals;
    }

    @Override
    public int getMinSteps() {
        return minSteps;
    }

}
