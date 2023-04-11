import sk.tuke.gamestudio.level.Level1;
import sk.tuke.gamestudio.ui.ConsoleUI;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleUI startGame = new ConsoleUI(new Level1());
        startGame.gameLoop();
    }
}