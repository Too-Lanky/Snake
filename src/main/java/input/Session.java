package input;

import render.Board;
import constants.Direction;

import javax.swing.*;
import java.awt.event.*;


public class Session extends KeyAdapter implements ActionListener {

    private Board board = new Board();
    private Direction direction = Direction.UP;
    private boolean session = true;
    private boolean paused = false;
    private JFrame jFrame;

    Session(JFrame jFrame){
        this.jFrame = jFrame;
        jFrame.add(board);
        jFrame.addKeyListener(this);
        board.repaint();
        //set refresh rate
        Timer timer = new Timer(140, this);
        timer.start();

    }

    //bring screen to life
    public void actionPerformed(ActionEvent e) {
        if(session){
            if(paused){
                board.repaint();
            }else
                session = board.update(direction);
        }else
            board.gameOver(board.getGraphics());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && !direction.equals(Direction.RIGHT) && !paused && session) {
            direction = Direction.LEFT;
        } else if (key == KeyEvent.VK_RIGHT && !direction.equals(Direction.LEFT) && !paused && session) {
            direction = Direction.RIGHT;
        } else if (key == KeyEvent.VK_UP && !direction.equals(Direction.DOWN) && !paused && session) {
            direction = Direction.UP;
        } else if (key == KeyEvent.VK_DOWN && !direction.equals(Direction.UP) && !paused && session) {
            direction = Direction.DOWN;
        } else if (key == KeyEvent.VK_P){
            paused = !paused;
        /*TODO
        this could be cleaned up by simply removing the controls from the session and making a new session whenever enter is clicked
        now i have to lazely reset the variables
        */
        }else if (key == KeyEvent.VK_ENTER){
            jFrame.remove(board);
            board = new Board();
            jFrame.add(board);
            jFrame.revalidate();
            paused = false;
            session = true;
            direction = Direction.UP;
        }
    }
}
