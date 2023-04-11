package sk.tuke.gamestudio.level;


import sk.tuke.gamestudio.core.Tile;
import sk.tuke.gamestudio.core.EmptySpace;
import sk.tuke.gamestudio.core.Goal;
import sk.tuke.gamestudio.core.Wall;

public class Level3 extends BaseLevel {

    private static final Tile[][] field = {
            {new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
            {new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new Wall()},
            {new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
            {new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace()},
            {new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new Wall()},
            {new EmptySpace(), new Goal(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
            {new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new Wall(), new EmptySpace()},
            {new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()}
    };

    public Level3() {
        super(8, 8, 5, 2, 1, 16, field);
    }
}
