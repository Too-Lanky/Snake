package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Session extends KeyAdapter implements ActionListener {

    Board board = new Board();
    Direction direction = Direction.UP;

    Session(JFrame jFrame){
        jFrame.add(board);
        jFrame.addKeyListener(this);
        board.repaint();
        //set refresh rate
        Timer timer = new Timer(8, this);
        timer.start();

    }

    //bring screen to life
    public void actionPerformed(ActionEvent e) {
        board.update(board.getGraphics(),direction);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && !direction.equals(Direction.RIGHT)) {
            direction = Direction.LEFT;
        } else if (key == KeyEvent.VK_RIGHT && !direction.equals(Direction.LEFT)) {
            direction = Direction.RIGHT;
        } else if (key == KeyEvent.VK_UP && !direction.equals(Direction.DOWN)) {
            direction = Direction.UP;
        } else if (key == KeyEvent.VK_DOWN && !direction.equals(Direction.UP)) {
            direction = Direction.DOWN;
        }
    }
}
