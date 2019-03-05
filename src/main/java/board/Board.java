package board;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board extends JPanel {
    Snake snake;
    private final int RAND_POS = new Random().nextInt(Constants.BOARD_HEIGHT*Constants.BOARD_WIDTH/2);

    public Board(){
        snake = new Snake(Constants.BOARD_WIDTH/2,Constants.BOARD_HEIGHT/2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g, Color.GREEN, Constants.BOARD_WIDTH/2,Constants.BOARD_HEIGHT/2);
    }

    public void update(Graphics g,Direction d) {
        super.paintComponent(g);
        snake.move(d,g);
    }
}
