package board;

import javax.swing.*;
import java.awt.*;

public class Board {
    private Food food = new Food();
    private Snake snake = new Snake();

    private Board(){
        JFrame jFrame = new JFrame("Snake");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(dimension.width,dimension.height);
    }


    public static void main(String[] args){
        new Board();
    }
}
