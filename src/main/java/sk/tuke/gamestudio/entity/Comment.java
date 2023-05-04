package sk.tuke.gamestudio.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity

//@NamedQuery(name = "Comment.resetComment",
//            query = "DELETE FROM Comment ")
//@NamedQuery(name = "Comment.addComment",
//            query = "INSERT INTO Comment c (c.player, c.game, c.comment, c.commentedOn) VALUES (:player, :game, :comment, :commentedOn)")
//@NamedQuery(name = "Comment.getComment",
//            query = "SELECT c.player, c.game, c.comment, c.commentedOn FROM Comment c WHERE c.game=:game LIMIT 10")
public class Comment implements Serializable {

    @Id
    @GeneratedValue
    private int ident;
    private String player;
    private String game;
    private String comment;
    //@Column(name = "commented_on")
    private Date commentedOn;

    public Comment() {
    }

    public Comment(String player, String game, String comment, Date commentedOn) {
        this.player = player;
        this.game = game;
        this.comment = comment;
        this.commentedOn = commentedOn;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentedOn() {
        return commentedOn;
    }

    public void setCommentedOn(Date commentedOn) {
        this.commentedOn = commentedOn;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "game='" + game + '\'' +
                ", player='" + player + '\'' +
                ", comment=" + comment +
                ", commentedOn=" + commentedOn +
                '}';
    }
}
