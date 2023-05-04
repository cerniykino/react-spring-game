package sk.tuke.gamestudio.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sk.tuke.gamestudio.entity.Rating;

import java.util.Date;

@Transactional
public class RatingServiceJPA implements RatingService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void setRating(Rating rating) throws RatingException {
        try{
            Rating checkRating =  entityManager.createQuery("SELECT r FROM Rating r WHERE r.game=:game AND r.player=:player", Rating.class)
                    .setParameter("game",rating.getGame())
                    .setParameter("player" , rating.getPlayer())
                    .getSingleResult();

            checkRating.setRating(rating.getRating());
            checkRating.setRatedOn(new Date());
        }
        catch (NoResultException e) {
            entityManager.persist(rating);
        };


    }

    @Override
    public int getAverageRating(String game) throws RatingException {

       Double average =  entityManager.createQuery("SELECT AVG(r.rating) FROM Rating r WHERE r.game = :game", Double.class)
               .setParameter("game", game)
               .getSingleResult();

       return (int)Math.round(average);

    }

    @Override
    public int getRating(String game, String player) throws RatingException {
        return (int)entityManager.createQuery("SELECT r.rating FROM Rating r WHERE r.game = :game AND r.player = :player")
                .setParameter("game", game)
                .setParameter("player", player)
                .getSingleResult();
    }

    @Override
    public void reset() throws RatingException {
        entityManager.createQuery("DELETE FROM Rating").executeUpdate();
    }
}
