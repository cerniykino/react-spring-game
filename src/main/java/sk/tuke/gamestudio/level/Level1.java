package sk.tuke.gamestudio.level;

import sk.tuke.gamestudio.core.EmptySpace;
import sk.tuke.gamestudio.core.Goal;
import sk.tuke.gamestudio.core.Tile;
import sk.tuke.gamestudio.core.Wall;

public class Level1 extends BaseLevel {

    private static final Tile[][] field = {
            {new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
            {new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace()},
            {new Wall(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace()},
            {new Goal(), new Wall(), new Wall(), new EmptySpace(), new EmptySpace()},
            {new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()}

    };

    public Level1() {
        super(5, 5, 0, 0, 1, 4, field);
    }
}
