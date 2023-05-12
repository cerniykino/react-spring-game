package sk.tuke.gamestudio.server.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import sk.tuke.gamestudio.core.*;
import sk.tuke.gamestudio.entity.Comment;
import sk.tuke.gamestudio.entity.Score;
import sk.tuke.gamestudio.level.Level1;
import sk.tuke.gamestudio.level.LevelInterface;
import sk.tuke.gamestudio.service.CommentService;
import sk.tuke.gamestudio.service.ScoreService;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/TiltMaze")
@CrossOrigin(origins = "http://localhost:3000")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class TiltMazeController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private Game game;


    @RequestMapping
    public String tiltMaze() {
        return "TiltMaze";
    }

    @RequestMapping("/new")
    public void newGame(Model model) {


        fillModel(model);
    }

    private void fillModel(Model model) {
        model.addAttribute("message", "Message");
        model.addAttribute("score", scoreService.getTopScores("TiltMaze"));
    }

    @RequestMapping("/scores")
    @ResponseBody
    public List<Score> score(){
        List<Score> topScores = scoreService.getTopScores("TiltMaze");
        return topScores;
    }




    @RequestMapping("/refresh-field")
    @ResponseBody
    public String refreshField(@RequestParam("direction") String direction){
        game.update(Direction.valueOf(direction.toUpperCase()));
        return getHtmlField();
    }



    @RequestMapping("/getField")
    @ResponseBody
    public String getHtmlField() {
        LevelInterface level = game.getLevel();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<table>\n");

        for (int i = 0; i < level.getHeight(); i++) {
            stringBuilder.append("<tr>\n");
            for (int j = 0; j < level.getWidth(); j++) {
                if ((level.getField()[i][j] instanceof EmptySpace && ((EmptySpace) level.getField()[i][j]).isPlayerPresent()) || (level.getPlayerX() == j && level.getPlayerY() == i)) {      //emptySpace
                    stringBuilder.append("<td>\n");
                    stringBuilder.append("<div class=\"ball\"/>\n");
                    stringBuilder.append("</td>\n");
                }
                else if (level.getField()[i][j] instanceof Wall){      //emptySpace
                    stringBuilder.append("<td>\n");
                    stringBuilder.append("<div class=\"wall\"></div> \n");
                    stringBuilder.append("</td>\n");
                }
                else if (level.getField()[i][j] instanceof EmptySpace && !((EmptySpace) level.getField()[i][j]).isPlayerPresent()){      //emptySpace
                    stringBuilder.append("<td>\n");
                    stringBuilder.append("<div class=\"empty\"/>\n");
                    stringBuilder.append("</td>\n");
                }
                else if (level.getField()[i][j] instanceof Goal && ((Goal) level.getField()[i][j]).isReached()){      //emptySpace
                    stringBuilder.append("<td>\n");
                    stringBuilder.append("<div class=\"star\"></div> \n");
                    stringBuilder.append("</td>\n");
                }
                else if (level.getField()[i][j] instanceof Goal && !((Goal) level.getField()[i][j]).isReached()){      //emptySpace
                    stringBuilder.append("<td>\n");
                    stringBuilder.append(" \n");
                    stringBuilder.append("</td>\n");
                }


            }
            stringBuilder.append("</tr>\n");

        }
        stringBuilder.append("</table>\n");
        return stringBuilder.toString();
    }


}
