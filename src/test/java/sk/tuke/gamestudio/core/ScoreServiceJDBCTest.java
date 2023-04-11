package sk.tuke.gamestudio.core;

import sk.tuke.gamestudio.entity.Score;
import org.junit.jupiter.api.*;
import sk.tuke.gamestudio.service.ScoreService;
import sk.tuke.gamestudio.service.ScoreServiceJDBC;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class ScoreServiceJDBCTest {

    private final String testGame = "testGame";
    private ScoreService scoreService;

    @BeforeEach
    public void setUp() throws Exception {
        scoreService = new ScoreServiceJDBC();
        scoreService.reset();
    }

    @AfterEach
    public void tearDown() throws Exception {
        scoreService.reset();
    }

    @Test
    void addScore() {
        Date date = new Date();
        Score score = new Score(testGame, "testPlayer", 30, date);
        scoreService.addScore(score);
        List<Score> scores = scoreService.getTopScores(testGame);
        assertNotNull(scores);
        assertEquals(score.getGame(), scores.get(0).getGame());
        assertEquals(score.getPlayer(), scores.get(0).getPlayer());
        assertEquals(score.getPoints(), scores.get(0).getPoints());
    }

    @Test
    void getTopScores() {
        Date date = new Date();
        Score score1 = new Score(testGame, "testPlayer1", 4, date);
        Score score2 = new Score(testGame, "testPlayer2", 7, date);
        Score score3 = new Score(testGame, "testPlayer3", 19, date);
        scoreService.addScore(score1);
        scoreService.addScore(score2);
        scoreService.addScore(score3);
        List<Score> scores = scoreService.getTopScores(testGame);
        assertNotNull(scores);
        assertEquals(3, scores.size());
        assertEquals(score3.getGame(), scores.get(0).getGame());
        assertEquals(score3.getPlayer(), scores.get(0).getPlayer());
        assertEquals(score3.getPoints(), scores.get(0).getPoints());
        assertEquals(score2.getGame(), scores.get(1).getGame());
        assertEquals(score2.getPlayer(), scores.get(1).getPlayer());
        assertEquals(score2.getPoints(), scores.get(1).getPoints());
        assertEquals(score1.getGame(), scores.get(2).getGame());
        assertEquals(score1.getPlayer(), scores.get(2).getPlayer());
        assertEquals(score1.getPoints(), scores.get(2).getPoints());
    }

    @Test
    void reset() {

        Score score = new Score(testGame, "testPlayer", 12, new Date());
        scoreService.addScore(score);
        scoreService.reset();
        List<Score> scores = scoreService.getTopScores(testGame);
        assertNotNull(scores);
        assertEquals(0, scores.size());
    }
}