package sk.tuke.gamestudio.core;

import sk.tuke.gamestudio.entity.Comment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sk.tuke.gamestudio.service.CommentService;
import sk.tuke.gamestudio.service.CommentServiceJDBC;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class CommentServiceJDBCTest {

    private final String testGame = "testGame";
    private CommentService commentService;

    @BeforeEach
    void setUp() {
        commentService = new CommentServiceJDBC();
        commentService.reset();
    }

    @AfterEach
    void tearDown() {
        commentService.reset();
    }

    @Test
    void addComment() {
        Comment comment = new Comment("testPlayer", testGame, "Very good", new Date());
        commentService.addComment(comment);

        List<Comment> comments = commentService.getComments(testGame);
        assertNotNull(comments);
        assertEquals(comment.getGame(), comments.get(0).getGame());
        assertEquals(comment.getPlayer(), comments.get(0).getPlayer());
        assertEquals(comment.getComment(), comments.get(0).getComment());
    }

    @Test
    void getComments() {
        Date date = new Date();

        Comment comment1 = new Comment("testPlayer1", testGame, "BAD", date);
        Comment comment2 = new Comment("testPlayer2", testGame, "GOOD", date);
        Comment comment3 = new Comment("testPlayer3", testGame, "soy soy", date);

        commentService.addComment(comment1);
        commentService.addComment(comment2);
        commentService.addComment(comment3);

        List<Comment> comments = commentService.getComments(testGame);

        assertNotNull(comments);
        assertEquals(3, comments.size());
        assertEquals(comment1.getGame(), comments.get(0).getGame());
        assertEquals(comment1.getPlayer(), comments.get(0).getPlayer());
        assertEquals(comment1.getComment(), comments.get(0).getComment());
        assertEquals(comment2.getGame(), comments.get(1).getGame());
        assertEquals(comment2.getPlayer(), comments.get(1).getPlayer());
        assertEquals(comment2.getComment(), comments.get(1).getComment());
        assertEquals(comment3.getGame(), comments.get(2).getGame());
        assertEquals(comment3.getPlayer(), comments.get(2).getPlayer());
        assertEquals(comment3.getComment(), comments.get(2).getComment());

    }

    @Test
    void reset() {
        Comment comment = new Comment("testPlayer3", testGame, "soy soy", new Date());
        commentService.addComment(comment);
        commentService.reset();
        List<Comment> comments = commentService.getComments(testGame);
        assertNotNull(comments);
        assertEquals(0, comments.size());
    }
}