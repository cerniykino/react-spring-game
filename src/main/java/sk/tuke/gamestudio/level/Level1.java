package sk.tuke.gamestudio.level;

import sk.tuke.gamestudio.core.EmptySpace;
import sk.tuke.gamestudio.core.Goal;
import sk.tuke.gamestudio.core.Tile;
import sk.tuke.gamestudio.core.Wall;

public class Level1 extends BaseLevel {



    public Level1() {
        super(5, 5, 0, 0, 1, 4);
        Tile[][] field = {
                {new EmptySpace(), new EmptySpace(true, true, true, false, true), new EmptySpace(false, false, false, false, true), new EmptySpace(), new EmptySpace()},
                {new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
                {new EmptySpace(false, true, false, false, true), new EmptySpace(), new EmptySpace(true, false, true, false, true), new EmptySpace(true, true, false, false, true), new EmptySpace()},
                {new Goal(), new EmptySpace(), new EmptySpace(), new EmptySpace(true, true, false, false, true), new EmptySpace()},
                {new EmptySpace(), new EmptySpace(true, true, false, false, true), new EmptySpace(), new EmptySpace(), new EmptySpace()}

        };
        super.setField(field);
        super.setPlayerPresence(true);
    }
}
