package sk.tuke.gamestudio.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.tuke.gamestudio.core.Direction;
import sk.tuke.gamestudio.core.Game;
import sk.tuke.gamestudio.entity.Comment;
import sk.tuke.gamestudio.entity.Rating;
import sk.tuke.gamestudio.entity.Score;
import sk.tuke.gamestudio.level.*;
import sk.tuke.gamestudio.service.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private GameState gameState = GameState.INIT;
    private String playerName = null;
    private int points = 0;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private RatingService ratingService;

    private Level1 level1;

    public ConsoleUI(Level1 level1) {
        this.level1 = level1;
    }

    public void gameLoop() throws IOException {
        System.out.println("Welcome to the Tilt Mazes!\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        playerName = scanner.nextLine();

        while (gameState != GameState.EXIT) {
            switch (gameState) {
                case INIT -> init();
                case CHOOSING_LEVEL -> chooseLevel();
                case RATING -> rating();
                case GUIDE -> guide();
                case SCORE -> score();
                case COMMENTING -> comment();
                default -> {
                    return;
                }
            }
        }
    }

    public void rating() {
        System.out.println("What are you want see my(m) / see average(s) / add(a) rating?");

        RatingServiceJDBC ratingServiceJDBC = new RatingServiceJDBC();

        Scanner scanner = new Scanner(System.in);

        int playerRating = -1;
        String ratingstring;
        String input = scanner.nextLine();

        switch (input.charAt(0)) {
            case 'a':
                while (playerRating > 5 || playerRating < 0) {
                    System.out.println("Please enter your game rating from 0 to 5");
                    ratingstring = scanner.nextLine();
                    try {
                        playerRating = Integer.parseInt(ratingstring);
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input");
                    }
                }

                Rating rating = new Rating(playerName, "TiltMaze", playerRating, new Date());
                ratingService.setRating(rating);
                break;
            case 's':
                System.out.println("Average rating of game: " + ratingService.getAverageRating("TiltMaze"));
                break;
            case 'm':
                System.out.println("Your rating is: "+ ratingService.getRating("TiltMaze",playerName));
                break;
        }

        gameState = GameState.INIT;
    }

    public void init() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What are you want? \rplay(p) \nguide(g) \nrate(r) \ncomment(c) \nscore(s) \nexit(e)");
        String input = scanner.nextLine();
        if (!input.isEmpty())
            switch (input.charAt(0)) {
                case 'p' -> gameState = GameState.CHOOSING_LEVEL;
                case 'r' -> gameState = GameState.RATING;
                case 'c' -> gameState = GameState.COMMENTING;
                case 's' -> gameState = GameState.SCORE;
                case 'e' -> gameState = GameState.EXIT;
                case 'g' -> gameState = GameState.GUIDE;
                default -> {
                }
            }
    }

    private void guide() {
        System.out.println("Welcome to Tilt MAZE game!\n" +
                "It is a guide for this game.\n" +
                "Playing in TIlt MAZE is very easy, if you..... YEAH.\n" +
                "Main goal of game is reach every GOAL in the least number of steps.\n" +
                "In game * represent goal. \nYou, player, look like ball. You only have four keys to control the ball.\n" +
                "If you want to go up press 'W', for go down press 'S', left 'A' and right 'D'. That's all.\n" +
                "Break a leg.\n" +
                "(press enter to close)");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        gameState = GameState.INIT;
    }

    public void chooseLevel() {
        System.out.println("Choose level \neasy(e) \nmedium(m) \nhard(h) \ninsane(i)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LevelInterface level = null;
        if (!input.isEmpty())
            switch (input.charAt(0)) {
                case 'e' -> level = new Level1();
                case 'm' -> level = new Level2();
                case 'h' -> level = new Level3();
                case 'i' -> level = new Level4();
                default -> {
                }
            }
        if (level != null)
            play(level);
    }

    private void comment() {
        System.out.println("What are you want see(s) / add(a) comment?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        CommentServiceJDBC commentServiceJDBC = new CommentServiceJDBC();
        if (!input.isEmpty())
            switch (input.charAt(0)) {
                case 's' -> {
                    List<Comment> comments = commentService.getComments("TiltMaze");
                    for (Comment comment : comments) {
                        System.out.println("Player: " + comment.getPlayer() + " comment: " + comment.getComment());
                    }

                }
                case 'a' -> {
                    System.out.println("Write your comment(max length 200 letters)");
                    String playerComment = scanner.nextLine();
                    Comment comment = new Comment(playerName, "TiltMaze", playerComment, new Date());
                    commentService.addComment(comment);
                }
                default -> {
                }
            }
        System.out.println("(press enter to close)");
        scanner.nextLine();
        gameState = GameState.INIT;
    }

    public void play(LevelInterface level) {

        Game game = new Game(level);
        Visualisation.printField(level);
        Scanner scanner = new Scanner(System.in);
        String input;
        int steps = 0;
        int star = 0;
        while (!game.isWon()) {
            input = scanner.nextLine();
            if (!input.isEmpty())
                switch (input.charAt(0)) {
                    case 'w' -> game.update(Direction.NORTH);
                    case 'a' -> game.update(Direction.WEST);
                    case 's' -> game.update(Direction.SOUTH);
                    case 'd' -> game.update(Direction.EAST);
                    case 'e' -> {
                        gameState = GameState.INIT;
                        return;
                    }
                }
            Visualisation.printField(level);
            steps++;
        }

        if (level.getMinSteps() == steps)
            star = 3;
        else if (level.getMinSteps() + 3 == steps)
            star = 2;
        else
            star = 1;

        points += star;
        System.out.println("You got " + star + " stars");
        ScoreServiceJDBC scoreServiceJDBC = new ScoreServiceJDBC();

        Score score = new Score(playerName, "TiltMaze", points, new Date());
        scoreService.addScore(score);

        System.out.println("Do you want to rate game?(y/n)");
        input = scanner.nextLine();
        if (!input.isEmpty())
            if (input.charAt(0) == 'y') {
                gameState = GameState.RATING;
            } else {
                gameState = GameState.INIT;
            }


    }

    private void score() {
        ScoreServiceJDBC scoreServiceJDBC = new ScoreServiceJDBC();
        List<Score> scores = scoreService.getTopScores("TiltMaze");

        for (Score score : scores) {
            System.out.println("player: " + score.getPlayer() + " points " + score.getPoints());
        }
        System.out.println("(press enter to close)");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        gameState = GameState.INIT;
    }

}
