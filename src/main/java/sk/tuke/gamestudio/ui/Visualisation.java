package sk.tuke.gamestudio.ui;


import sk.tuke.gamestudio.core.EmptySpace;
import sk.tuke.gamestudio.core.Goal;
import sk.tuke.gamestudio.core.Wall;
import sk.tuke.gamestudio.level.LevelInterface;

import java.io.IOException;

public class Visualisation {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void printField(LevelInterface level) {

        String str1 = "\u25CF";

        String ball = null;
        String star = null;

        try {
            byte[] charset;
            charset = str1.getBytes("UTF-8");
            ball = new String(charset, "UTF-8");
        } catch (IOException e) {
            System.out.print("Exception");
        }
        str1 = "\u2726";
        try {
            byte[] charset;
            charset = str1.getBytes("UTF-8");
            star = new String(charset, "UTF-8");
        } catch (IOException e) {
            System.out.print("Exception");
        }
        char s = star.charAt(0);
        // print the top border of the frame
        System.out.print(ANSI_BLACK_BACKGROUND + ANSI_BLACK + ' ' + ANSI_RESET);
        for (int i = 0; i < level.getHeight(); i++) {
            System.out.print(ANSI_BLACK_BACKGROUND + ANSI_BLACK + ' ' + ANSI_RESET);
        }
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_BLACK + ' ' + ANSI_RESET);

        // print the sides of the frame
        for (int i = 0; i < level.getHeight(); i++) {
            System.out.print(ANSI_BLACK_BACKGROUND + ANSI_BLACK + ' ' + ANSI_RESET);
            for (int j = 0; j < level.getWidth(); j++) {

                if ((level.getField()[i][j] instanceof EmptySpace && ((EmptySpace) level.getField()[i][j]).isPlayerPresent()) || (level.getPlayerX() == j && level.getPlayerY() == i))       //emptySpace
                    System.out.print(ball);
                else if (level.getField()[i][j] instanceof Wall)  //wall '|'
                    System.out.print(ANSI_RED_BACKGROUND + ANSI_RED + ' ' + ANSI_RESET);
                else if (level.getField()[i][j] instanceof EmptySpace && !((EmptySpace) level.getField()[i][j]).isPlayerPresent())
                    System.out.print(' ');
                else if (level.getField()[i][j] instanceof Goal && ((Goal) level.getField()[i][j]).isReached())
                    System.out.print('*');
                else if (level.getField()[i][j] instanceof Goal && !((Goal) level.getField()[i][j]).isReached())
                    System.out.print(' ');


            }

            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_BLACK + ' ' + ANSI_RESET);
        }

        // print the bottom border of the frame
        System.out.print(ANSI_BLACK_BACKGROUND + ANSI_BLACK + ' ' + ANSI_RESET);
        for (int i = 0; i < level.getWidth(); i++) {
            System.out.print(ANSI_BLACK_BACKGROUND + ANSI_BLACK + ' ' + ANSI_RESET);
        }
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_BLACK + ' ' + ANSI_RESET);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
