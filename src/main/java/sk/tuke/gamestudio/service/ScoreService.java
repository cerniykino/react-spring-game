package sk.tuke.gamestudio.service;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.tuke.gamestudio.entity.Score;

import java.util.List;

public interface ScoreService {
    void addScore(Score score) throws ScoreException;

    List<Score> getTopScores(String game) throws ScoreException;
    Score getScore(String player, String game) throws ScoreException;

    void reset() throws ScoreException;
}
