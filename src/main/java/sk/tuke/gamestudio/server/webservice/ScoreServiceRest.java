package sk.tuke.gamestudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.gamestudio.entity.Score;
import sk.tuke.gamestudio.service.ScoreService;

import java.util.List;

@RestController
@RequestMapping("/api/score")
@CrossOrigin(origins = "http://localhost:3000")
public class ScoreServiceRest {
    @Autowired
    private ScoreService scoreService;


    @GetMapping("/{game}")
    public List<Score> getTopScores(@PathVariable String game) {
        return scoreService.getTopScores(game);
    }

    @GetMapping("/{game}/{player}")
    public Score getMyScores(@PathVariable String player, @PathVariable String game){ return scoreService.getScore(player, game);}
    @PostMapping
    public void addScore(@RequestBody Score score) {
        scoreService.addScore(score);
    }
}