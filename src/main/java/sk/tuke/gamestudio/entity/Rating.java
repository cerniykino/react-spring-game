package sk.tuke.gamestudio.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

import java.io.Serializable;
import java.util.Date;


@Entity
//@NamedQuery(name = "Rating.getRating",
//            query = "SELECT r FROM Rating r WHERE r.game = :game AND r.player = :player ORDER BY r.rating LIMIT 5")
//@NamedQuery(name = "Rating.getAverageRating",
//            query = "SELECT AVG(r.rating) FROM Rating r WHERE r.game = :game")
//@NamedQuery(name = "Rating.setRating",
//            query = "INSERT INTO Rating r (r.player, r.game, r.rating, r.ratedOn) VALUES (:player, :game, :rating, :ratedOn) ON CONFLICT r.player DO UPDATE SET r.rating = :rating")
//@NamedQuery(name = "Rating.reset",
//            query = "DELETE FROM Rating")
public class Rating implements Serializable {
    @Id
    @GeneratedValue
    private int ident;

    private String player;
    private String game;
    private int rating;
    private Date ratedOn;

    public Rating() {
    }

    public Rating(String player, String game, int rating, Date ratedOn) {
        this.player = player;
        this.game = game;
        this.rating = rating;
        this.ratedOn = ratedOn;
    }

    public int getIdent() {
        return ident;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getRatedOn() {
        return ratedOn;
    }

    public void setRatedOn(Date ratedOn) {
        this.ratedOn = ratedOn;
    }

    @Override
    public String toString() {
        return "Score{" +
                "game='" + game + '\'' +
                ", player='" + player + '\'' +
                ", rating=" + rating +
                ", ratedOn=" + ratedOn +
                '}';
    }
}
