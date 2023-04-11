package sk.tuke.gamestudio.level;

import sk.tuke.gamestudio.core.Player;
import sk.tuke.gamestudio.core.Tile;

public interface LevelInterface {
    int getPlayerX();

    int getPlayerY();

    int getHeight();

    int getWidth();

    Tile[][] getField();

    void setPlayerPresence(boolean presence);

    void setPlayerCoordinates(Player player);

    int getGoals();

    void setGoals(int goals);

    int getMinSteps();
}
