package sk.tuke.gamestudio.service;

import org.springframework.data.repository.query.Param;
import sk.tuke.gamestudio.entity.Score;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Transactional
public class ScoreServiceJPA implements ScoreService{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void addScore(Score score) throws ScoreException {
        entityManager.createNativeQuery("INSERT INTO Score (player, game, points, played_on) VALUES (?, ?, ?, ?) ON CONFLICT (player) DO UPDATE SET points = ?")
                .setParameter(1, score.getPlayer())
                .setParameter(2, score.getGame())
                .setParameter(3, score.getPoints())
                .setParameter(4, score.getPlayedOn())
                .setParameter(5, score.getPoints())
                .executeUpdate();
    }

    @Override
    public List<Score> getTopScores(String game) throws ScoreException {
        return entityManager.createQuery("SELECT s FROM Score s WHERE s.game = :game ORDER BY points DESC", Score.class)
                .setParameter("game", game)
                .setMaxResults(10)
                .getResultList();
    }

    @Override
    public void reset() throws ScoreException {
        entityManager.createNamedQuery("DELETE FROM score").executeUpdate();
    }
}
