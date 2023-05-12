package sk.tuke.gamestudio.server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.gamestudio.core.Direction;
import sk.tuke.gamestudio.core.Game;
import sk.tuke.gamestudio.core.Tile;
import sk.tuke.gamestudio.level.Level1;
import sk.tuke.gamestudio.level.Level3;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class FieldController {

    @Autowired
    private Game gameService;

    @GetMapping("field")
    public Tile[][] getField(){
        return gameService.getLevel().getField();
    }
    @RequestMapping("/refresh-field")
    @ResponseBody
    public Tile[][] refreshField(@RequestParam("direction") String direction){
        gameService.update(Direction.valueOf(direction.toUpperCase()));
        return gameService.getLevel().getField();
    }

    @RequestMapping("/isWon")
    @ResponseBody
    public boolean isWon(){
        return gameService.isWon();
    }

    @RequestMapping("/steps")
    @ResponseBody
    public int steps(){
        return gameService.steps();
    }

    @RequestMapping("/newGame")
    @ResponseBody
    public void newGame(){
        gameService = new Game(new Level3());
    }
}
