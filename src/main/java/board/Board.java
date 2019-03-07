package board;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board extends JPanel {
    Snake snake;
    Food food;
    private final int RAND_POS = new Random().nextInt(Constants.BOARD_HEIGHT*Constants.BOARD_WIDTH/2);

    public Board(){
        snake = new Snake(Constants.BOARD_WIDTH/2,Constants.BOARD_HEIGHT/2);
        food = new Food(Constants.BOARD_WIDTH/2,Constants.BOARD_HEIGHT/2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g, Color.GREEN, snake.getHead().getX(),snake.getHead().getY());
    }

    public void update(Direction direction) {
        super.paintComponent(this.getGraphics());
        if(numNumNum(snake.getHead(),food)){
            snake.grow(snake.getHead());
        }
        snake.move(direction,this.getGraphics());
        food.draw(this.getGraphics(), Color.RED, food.getX(),food.getY());
    }

    public boolean numNumNum(BodyPart bodyPart, Food food){
        if(bodyPart.getX() == food.getX() && bodyPart.getY() == food.getY()){
            return true;
        }else
            return false;
    }
}
