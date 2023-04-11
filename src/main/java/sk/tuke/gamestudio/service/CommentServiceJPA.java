package sk.tuke.gamestudio.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sk.tuke.gamestudio.entity.Comment;

import java.util.List;

@Transactional
public class CommentServiceJPA implements CommentService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addComment(Comment comment) throws CommentException {
        entityManager.createNativeQuery("INSERT INTO Comment (player, game, comment, commented_on) VALUES (?, ?, ?, ?)")
                .setParameter(1, comment.getPlayer())
                .setParameter(2, comment.getGame())
                .setParameter(3, comment.getComment())
                .setParameter(4, comment.getCommentedOn())
                .executeUpdate();
    }

    @Override
    public List<Comment> getComments(String game) throws CommentException {
        return entityManager.createQuery("SELECT c FROM Comment c WHERE c.game=:game")
                .setParameter("game", game)
                .setMaxResults(10)
                .getResultList();
    }

    @Override
    public void reset() throws CommentException {
        entityManager.createNamedQuery("DELETE FROM comment").executeUpdate();
    }
}
