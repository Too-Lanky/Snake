package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Game extends JPanel implements ActionListener {

    private final int RAND_POS = new Random().nextInt(Constants.BOARD_HEIGHT*Constants.BOARD_WIDTH/2);

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
        g.drawRect(Constants.BOARD_WIDTH/2,Constants.BOARD_HEIGHT/2,Constants.BODY_SIZE,Constants.BODY_SIZE);
        double i = Math.random();
        float colorCode = (float)i;
        Color c = new Color(colorCode,colorCode,colorCode);
        g.setColor(c);
        g.fillRect(Constants.BOARD_WIDTH/2,Constants.BOARD_HEIGHT/2,Constants.BODY_SIZE,Constants.BODY_SIZE);
    }

    //bring screen to life
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
