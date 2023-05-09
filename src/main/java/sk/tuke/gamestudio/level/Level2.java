package sk.tuke.gamestudio.level;

import sk.tuke.gamestudio.core.EmptySpace;
import sk.tuke.gamestudio.core.Goal;
import sk.tuke.gamestudio.core.Tile;
import sk.tuke.gamestudio.core.Wall;

public class Level2 extends BaseLevel {



    public Level2() {
        super(6, 6, 0, 0, 5, 5);
        Tile[][] field = {
                {new EmptySpace(), new Wall(), new Wall(), new Wall(), new EmptySpace(), new EmptySpace()},
                {new EmptySpace(), new Wall(), new EmptySpace(), new Wall(), new EmptySpace(), new Wall()},
                {new EmptySpace(), new Wall(), new EmptySpace(), new Wall(), new EmptySpace(), new Wall()},
                {new EmptySpace(), new Wall(), new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace()},
                {new EmptySpace(), new EmptySpace(), new EmptySpace(), new Wall(), new Wall(), new Wall()},
                {new EmptySpace(), new Wall(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new Goal()}
        };
        super.setField(field);
        super.setPlayerPresence(true);
    }
}