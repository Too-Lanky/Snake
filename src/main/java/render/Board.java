package render;

import constants.Constants;
import constants.Direction;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Random;

public class Board extends JPanel {
    Snake snake;
    Food food;
    private final int RAND_POS = new Random().nextInt(Constants.BOARD_HEIGHT*Constants.BOARD_WIDTH/2);

    public Board(){
        snake = new Snake(Constants.BOARD_WIDTH/2,Constants.BOARD_HEIGHT/2);
        food = new Food(Constants.BOARD_WIDTH/2,Constants.BOARD_HEIGHT/2);
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g, Color.GREEN, snake.getHead().getX(),snake.getHead().getY());
    }

    public boolean update(Direction direction) {
        super.paintComponent(this.getGraphics());
        if(collision(snake)) return false;
        if(numNumNum(snake.getHead(),food)) snake.grow(snake.getHead());
        snake.move(direction,this.getGraphics());
        food.draw(this.getGraphics(), Color.RED, food.getX(),food.getY());
        return true;
    }

    private boolean numNumNum(BodyPart bodyPart, Food food){
        return (bodyPart.getX() == food.getX() && bodyPart.getY() == food.getY());
    }

    private boolean collision(Snake snake){
        Iterator iterator = snake.getBody().descendingIterator();
        BodyPart head = snake.getHead();

        while(iterator.hasNext()){
            BodyPart tail = (BodyPart)iterator.next();
            if(head.equals(tail)){
                break;
            }else if(head.getX() == Constants.BOARD_WIDTH || head.getY() == Constants.BOARD_HEIGHT) {
                return true;
            }else if (head.getX() == Constants.BODY_WIDTH_INVERSE || head.getY() == Constants.BODY_HEIGHT_INVERSE){
                return true;
            }else if(head.getX() == tail.getX() && head.getY() == tail.getY()){
                return true;
            }
        }
        return false;
    }
}
