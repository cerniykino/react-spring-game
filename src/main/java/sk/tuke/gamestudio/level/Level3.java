package sk.tuke.gamestudio.level;


import sk.tuke.gamestudio.core.Tile;
import sk.tuke.gamestudio.core.EmptySpace;
import sk.tuke.gamestudio.core.Goal;
import sk.tuke.gamestudio.core.Wall;

public class Level3 extends BaseLevel {



    public Level3() {
        super(8, 8, 5, 2, 1, 16);

        Tile[][] field = {
                {new EmptySpace(true, false, false, true, true), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
                {new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
                {new EmptySpace(), new EmptySpace(true, false, false, true, true), new EmptySpace(), new EmptySpace(true, false, false, true, true), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
                {new EmptySpace(true, false, false, false, true), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
                {new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
                {new EmptySpace(), new Goal(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
                {new EmptySpace(), new EmptySpace(true, false, false, true, true), new EmptySpace(), new EmptySpace(true, false, false, true, true), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()},
                {new EmptySpace(true, false, false, true, true), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace(), new EmptySpace()}
        };
        super.setField(field);
        super.setPlayerPresence(true);
    }
}
