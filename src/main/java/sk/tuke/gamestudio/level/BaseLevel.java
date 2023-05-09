package sk.tuke.gamestudio.level;

import sk.tuke.gamestudio.core.EmptySpace;
import sk.tuke.gamestudio.core.Player;
import sk.tuke.gamestudio.core.Reacheble;
import sk.tuke.gamestudio.core.Tile;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;

public abstract class BaseLevel implements LevelInterface, Serializable {

    private final int width;
    private final int height;
    private int playerX;
    private int playerY;
    private int goals;
    private int minSteps;

    private Tile[][] field;

    public BaseLevel(int width, int height, int playerX, int playerY, int goals, int minSteps) {
        this.width = width;
        this.height = height;
        this.playerX = playerX;
        this.playerY = playerY;
        this.goals = goals;
        this.minSteps = minSteps;
    }

    public void setField(Tile[][] field){
        this.field = new Tile[this.height][this.width];
        for(int i=0; i<height; i++){
            for (int j=0; j<width; j++)
                this.field[i][j] = field[i][j];
        }
    }

    @Override
    public void setPlayerPresence(boolean presence) {

        if (field[playerY][playerX] instanceof Reacheble)
            ((Reacheble) (field[playerY][playerX])).setPlayer(presence);

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

    @Override
    public String toString() {
        return "BaseLevel{" +
                "width=" + width +
                ", height=" + height +
                ", playerX=" + playerX +
                ", playerY=" + playerY +
                ", goals=" + goals +
                ", minSteps=" + minSteps +
                ", field=" + Arrays.toString(field) +
                '}';
    }
}
