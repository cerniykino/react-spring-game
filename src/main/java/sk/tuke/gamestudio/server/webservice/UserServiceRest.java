package sk.tuke.gamestudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.gamestudio.entity.Score;
import sk.tuke.gamestudio.entity.User;
import sk.tuke.gamestudio.service.ScoreService;
import sk.tuke.gamestudio.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserServiceRest {
    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public boolean add(@RequestParam String username, @RequestParam String password) {
        return userService.registerUser(new User(username, password));
    }

    @GetMapping("/login")
    public boolean login(@RequestParam String username, @RequestParam String password){
        return userService.loginUser(new User(username, password));
    }
}