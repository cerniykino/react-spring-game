package sk.tuke.gamestudio.core;

import sk.tuke.gamestudio.core.Direction;
import sk.tuke.gamestudio.core.Game;
import sk.tuke.gamestudio.level.Level2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;

    @BeforeEach
    void setUp() {
        game = new Game(new Level2());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void update() {
        game = new Game(new Level2());
        assertEquals(1, game.update(Direction.EAST));
        assertEquals(3, game.update(Direction.SOUTH));
        assertEquals(1, game.update(Direction.WEST));
        assertEquals(1, game.update(Direction.NORTH));
        assertEquals(4, game.update(Direction.EAST));
        assertEquals(2, game.update(Direction.NORTH));
        assertEquals(1, game.update(Direction.WEST));
        assertEquals(4, game.update(Direction.SOUTH));
        assertEquals(1, game.update(Direction.EAST));

    }

    @Test
    void isWon() {
        game = new Game(new Level2());
        game.update(Direction.EAST);
        assertFalse(game.isWon());
        game.update(Direction.SOUTH);
        assertFalse(game.isWon());
        game.update(Direction.WEST);
        assertFalse(game.isWon());
        game.update(Direction.NORTH);
        assertFalse(game.isWon());
        game.update(Direction.EAST);
        assertFalse(game.isWon());
        game.update(Direction.NORTH);
        assertFalse(game.isWon());
        game.update(Direction.WEST);
        assertFalse(game.isWon());
        game.update(Direction.SOUTH);
        assertFalse(game.isWon());
        game.update(Direction.EAST);
        assertTrue(game.isWon());
    }
}