package board;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Game extends JPanel {

    private static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    Random random = new Random();
    private final int BOARD_WIDTH = dimension.width;
    private final int BOARD_HEIGHT = dimension.height;
    private final int BODY_SIZE = 10;
    private final int RAND_POS = random.nextInt(BOARD_HEIGHT*BOARD_WIDTH/2);
    private final int DELAY = 140;

    public boolean outOfBounds(int x,int y){
        boolean hasCollided = false;
        return hasCollided;
    }

    public boolean numNumNum(int x, int y){
        boolean foodEaten = false;
        return foodEaten;
    }

    public void goUp(Direction d){

    }

    public void goRight(Direction d){

    }

    public void goLeft(Direction d){

    }

    public void goDown(Direction d){

    }

    public void move(){

    }

    public void makeFood(int z, int k){

    }

    public boolean gameOver(Snake snake){
        boolean collided = false;

        return collided;
    }
}
