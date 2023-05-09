package sk.tuke.gamestudio.service;

import sk.tuke.gamestudio.entity.Score;
import sk.tuke.gamestudio.entity.User;

import java.util.List;
public interface UserService {

    boolean registerUser(User user) throws UserException;

    boolean loginUser(User User) throws UserException;
    void reset() throws UserException;
}
