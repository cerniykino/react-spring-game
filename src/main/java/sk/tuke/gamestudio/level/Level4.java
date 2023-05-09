package sk.tuke.gamestudio.level;

import sk.tuke.gamestudio.core.EmptySpace;
import sk.tuke.gamestudio.core.Goal;
import sk.tuke.gamestudio.core.Tile;
import sk.tuke.gamestudio.core.Wall;

public class Level4 extends BaseLevel {
    private static final Tile[][] field = {
            {new Goal(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new Goal(), new Wall(), new EmptySpace(), new EmptySpace(), new Goal(), new Wall(), new EmptySpace(), new Goal()},
            {new EmptySpace(), new EmptySpace(), new Wall(), new Goal(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
            {new Wall(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace()},
            {new Goal(), new EmptySpace(), new Wall(), new EmptySpace(), new Goal(), new EmptySpace(), new Wall(), new Goal(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
            {new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
            {new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
            {new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
            {new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new Goal(), new EmptySpace(), new Wall(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace()},
            {new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace()},
            {new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new Wall(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
            {new Wall(), new EmptySpace(), new EmptySpace(), new Wall(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
            {new Goal(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()}
    };

    public Level4() {
        super(12, 12, 1, 1, 10, 24);
        Tile[][] field = {
                {new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
                {new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace()},
                {new Wall(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace()},
                {new Goal(), new Wall(), new Wall(), new EmptySpace(), new EmptySpace()},
                {new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()}

        };
        super.setField(field);
        super.setPlayerPresence(true);
    }
}
