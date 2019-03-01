package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Game extends JPanel implements ActionListener {

    private final int RAND_POS = new Random().nextInt(Constants.BOARD_HEIGHT*Constants.BOARD_WIDTH/2);
    Snake snake;

    Game(){
        //set refresh rate
        Timer timer = new Timer(170, this);
        timer.start();
    }

    public boolean outOfBounds(int x,int y){
        boolean hasCollided = false;
        return hasCollided;
    }

    public boolean numNumNum(int x, int y){
        boolean foodEaten = false;
        return foodEaten;
    }

    //work horse
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //start game
        if(snake == null){
            snake = new Snake(Constants.BOARD_WIDTH/2,Constants.BOARD_HEIGHT/2);
        }
    }

    //bring screen to life
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
