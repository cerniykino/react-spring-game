package sk.tuke.gamestudio.core;

import sk.tuke.gamestudio.entity.Rating;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sk.tuke.gamestudio.service.RatingServiceJDBC;


import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class RatingServiceJDBCTest {

    private final String testGame = "testGame";
    private RatingServiceJDBC ratingServiceJDBC;

    @BeforeEach
    void setUp() {
        ratingServiceJDBC = new RatingServiceJDBC();
        ratingServiceJDBC.reset();
    }

    @AfterEach
    void tearDown() {
        ratingServiceJDBC.reset();
    }

    @Test
    void setRating() {
        Rating rating = new Rating("testPlayer", testGame, 4, new Date());
        ratingServiceJDBC.setRating(rating);

        assertEquals(4, ratingServiceJDBC.getRating(testGame, "testPlayer"));

    }

    @Test
    void getAverageRating() {
        Rating rating1 = new Rating("testPlayer1", testGame, 5, new Date());
        Rating rating2 = new Rating("testPlayer2", testGame, 0, new Date());
        Rating rating3 = new Rating("testPlayer3", testGame, 2, new Date());

        ratingServiceJDBC.setRating(rating1);
        ratingServiceJDBC.setRating(rating2);
        ratingServiceJDBC.setRating(rating3);

        assertEquals(2, ratingServiceJDBC.getAverageRating(testGame));
    }

    @Test
    void getRating() {
        Rating rating1 = new Rating("testPlayer1", testGame, 5, new Date());
        Rating rating2 = new Rating("testPlayer2", testGame, 0, new Date());
        Rating rating3 = new Rating("testPlayer3", testGame, 2, new Date());

        ratingServiceJDBC.setRating(rating1);
        ratingServiceJDBC.setRating(rating2);
        ratingServiceJDBC.setRating(rating3);

        assertEquals(ratingServiceJDBC.getRating(testGame, "testPlayer1"), 5);
        assertEquals(ratingServiceJDBC.getRating(testGame, "testPlayer2"), 0);
        assertEquals(ratingServiceJDBC.getRating(testGame, "testPlayer3"), 2);
    }

    @Test
    void reset() {
        Rating rating = new Rating("testPlayer", testGame, 4, new Date());
        ratingServiceJDBC.setRating(rating);
        ratingServiceJDBC.reset();
        int ratings = 0;
        ratings = ratingServiceJDBC.getRating(testGame, "testPlayer");
        assertEquals(-1, ratings);

    }
}