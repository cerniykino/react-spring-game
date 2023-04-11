package sk.tuke.gamestudio.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sk.tuke.gamestudio.entity.Rating;
@Transactional
public class RatingServiceJPA implements RatingService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void setRating(Rating rating) throws RatingException {
        entityManager.createNativeQuery("INSERT INTO Rating (player, game, rating, rated_on) VALUES (?, ?, ?, ?) ON CONFLICT (player) DO UPDATE SET rating = ?")
                .setParameter(1, rating.getPlayer())
                .setParameter(2, rating.getGame())
                .setParameter(3, rating.getRating())
                .setParameter(4, rating.getRatedOn())
                .setParameter(5, rating.getRating()).executeUpdate();

        // entityManager.persist(rating);
    }

    @Override
    public double getAverageRating(String game) throws RatingException {
       return (Double) entityManager.createQuery("SELECT AVG(r.rating) FROM Rating r WHERE r.game = :game")
               .setParameter("game", game)
               .getSingleResult();
    }

    @Override
    public int getRating(String game, String player) throws RatingException {
        return entityManager.createQuery("SELECT rating FROM Rating r WHERE r.game = :game AND r.player = :player")
                .setParameter("game", game)
                .setParameter("player", player)
                .executeUpdate();
    }

    @Override
    public void reset() throws RatingException {
        entityManager.createQuery("DELETE FROM rating").executeUpdate();
    }
}
