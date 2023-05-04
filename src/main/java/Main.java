import sk.tuke.gamestudio.server.controller.TiltMazeController;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        //ConsoleUI startGame = new ConsoleUI(new Level1());
        //startGame.gameLoop();

        TiltMazeController tiltMazeController = new TiltMazeController();

        System.out.println(tiltMazeController.getHtmlField());
    }
}