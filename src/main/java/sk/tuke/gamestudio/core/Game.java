package sk.tuke.gamestudio.core;

import sk.tuke.gamestudio.level.*;

import sk.tuke.gamestudio.level.LevelInterface;

public class Game {

    private final LevelInterface level;
    private final Player player;

    public Game(LevelInterface level) {
        this.level = level;
        this.player = new Player(this.level.getPlayerX(), this.level.getPlayerY());

    }


    public int update(Direction direction) {
        int steps = 0;
        if (direction == Direction.SOUTH) {
            while (player.getY() < level.getHeight() - 1 && level.getField()[player.getY() + 1][player.getX()] instanceof Reacheble) {
                player.setY(player.getY() + 1);
                steps++;

                changeLevelState();
            }
        } else if (direction == Direction.WEST) {
            while (player.getX() > 0 && level.getField()[player.getY()][player.getX() - 1] instanceof Reacheble) {
                player.setX(player.getX() - 1);
                steps++;

                changeLevelState();
            }
        }
        if (direction == Direction.NORTH) {
            while (player.getY() > 0 && level.getField()[player.getY() - 1][player.getX()] instanceof Reacheble) {
                player.setY(player.getY() - 1);
                steps++;

                changeLevelState();
            }
        }
        if (direction == Direction.EAST) {
            while (player.getX() < level.getWidth() - 1 && level.getField()[player.getY()][player.getX() + 1] instanceof Reacheble) {
                player.setX(player.getX() + 1);
                steps++;
                changeLevelState();
            }
        }
        return steps;
    }

    private void changeLevelState() {
        level.setPlayerPresence(false);
        level.setPlayerCoordinates(this.player);
        level.setPlayerPresence(true);
        if (level.getField()[player.getY()][player.getX()] instanceof Goal && ((Goal) level.getField()[player.getY()][player.getX()]).isReached()) {
            ((Goal) level.getField()[player.getY()][player.getX()]).setReached(false);
            level.setGoals(level.getGoals() - 1);
        }
    }

    public boolean isWon() {
        return level.getGoals() == 0;
    }
}
