package sk.tuke.gamestudio.core;

import sk.tuke.gamestudio.level.*;

public class Game {
    private final LevelInterface level;
    private final Player player;
    private int steps;
    public Game(LevelInterface level) {
        this.level = level;
        this.player = new Player(this.level.getPlayerX(), this.level.getPlayerY());
        this.steps = 0;
    }

    public int update(Direction direction) {
        if(isWon())
            return -1;
        int newX = player.getX();
        int newY = player.getY();
        boolean moved = false;
        System.out.println("Position " + newX +" "+newY);
        switch (direction) {
            case SOUTH -> newY++;
            case WEST -> newX--;
            case NORTH -> newY--;
            case EAST -> newX++;
        }

        if (isValidMove(newX, newY)) {
            while (isReachable(newX, newY, direction)) {
                if(isValidMove(newX, newY)){
                    player.setX(newX);
                    player.setY(newY);}
                if (newX >= 0 && newX < level.getWidth() && newY >= 0 && newY < level.getHeight()) {
                    changeLevelState();}


                switch (direction) {
                    case SOUTH -> newY++;
                    case WEST -> newX--;
                    case NORTH -> newY--;
                    case EAST -> newX++;
                }
            }
            steps++;
        }
        return steps;
    }

    private boolean isValidMove(int newX, int newY) {
        System.out.println("isValidMove " + newX +" "+newY);
        if (newX >= 0 && newX < level.getWidth() && newY >= 0 && newY < level.getHeight()) {
            return level.getField()[newY][newX] instanceof EmptySpace || level.getField()[newY][newX] instanceof Reacheble;
        }
        return false;
    }

    private boolean isReachable(int newX, int newY, Direction direction) {
        System.out.println("isReachable" + newX +" "+newY);
        if(isValidMove(newX, newY)){
                if(isBlocked(player.getX(), player.getY(), direction))
                    return false;
                else return !isNextBlocked(newX, newY, direction);
        }

        return false;
    }


    private boolean isBlocked(int newX, int newY, Direction direction) {
        System.out.println("isBlocked"+ newX +" "+newY);
        if (level.getField()[newY][newX] instanceof EmptySpace emptySpace) {
            return switch (direction) {
                case SOUTH -> emptySpace.isDownBlocked();
                case WEST -> emptySpace.isLeftBlocked();
                case NORTH -> emptySpace.isUpBlocked();
                case EAST -> emptySpace.isRightBlocked();
            };
        }
        return false;
    }
    private boolean isNextBlocked(int newX, int newY, Direction direction) {
        System.out.println("isNextBlocked"+ newX +" "+newY);
        if (level.getField()[newY][newX] instanceof EmptySpace emptySpace) {
            return switch (direction) {
                case SOUTH -> emptySpace.isUpBlocked();
                case WEST -> emptySpace.isRightBlocked();
                case NORTH -> emptySpace.isDownBlocked();
                case EAST -> emptySpace.isLeftBlocked();
            };
        }
        return false;
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

    public LevelInterface getLevel() {
        return this.level;
    }

    public boolean isWon() {
        return level.getGoals() == 0;
    }

    public int steps(){
        return this.steps;
    }
}
