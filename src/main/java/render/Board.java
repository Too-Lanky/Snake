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
    //divided by 10 minus 1
    private int RAND_POS = new Random().nextInt(49);

    public Board(){
        snake = new Snake(Constants.BOARD_WIDTH/2,Constants.BOARD_HEIGHT/2);
        food = new Food(RAND_POS*Constants.BODY_SIZE,RAND_POS*Constants.BODY_SIZE);
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (BodyPart bodypart : snake.getBody()) {
            System.out.println("("+bodypart.getX()+","+bodypart.getY()+")");
            if (bodypart.equals(snake.getHead())) {
                snake.draw(g, Color.GREEN, bodypart.getX(), bodypart.getY());
            }else {
                snake.draw(g, Color.ORANGE, bodypart.getX(), bodypart.getY());
            }
        }
        food.draw(g, Color.RED, food.getX(),food.getY());
    }

    public boolean update(Direction direction) {
        super.paintComponent(this.getGraphics());

        if(collision(snake)) {
            return false;
        }
        if(numNumNum(snake.getHead(),food)) {
            snake.grow(snake.getHead());
            RAND_POS = new Random().nextInt(49);
            food.setY(RAND_POS*Constants.BODY_SIZE);
            food.setX(RAND_POS*Constants.BODY_SIZE);
        }
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

    public void gameOver(Graphics g){
        super.paintComponent(g);
        String gameOver = "Press Enter to start";
        Font font = new Font("Verdana", Font.BOLD, 18);
        g.setColor(Color.GREEN);
        g.setFont(font);
        //TODO
        g.drawString(gameOver,Constants.BOARD_WIDTH/3-gameOver.length()+1,Constants.BOARD_HEIGHT/2);
    }
}
