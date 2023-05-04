package sk.tuke.gamestudio.service;

import jakarta.persistence.NoResultException;
import org.springframework.data.repository.query.Param;
import sk.tuke.gamestudio.entity.Score;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public class ScoreServiceJPA implements ScoreService{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addScore(Score score) throws ScoreException {

            entityManager.persist(score);

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
        entityManager.createQuery("DELETE FROM Score").executeUpdate();
    }
}
