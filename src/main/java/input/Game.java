package input;

import constants.Constants;

import javax.swing.*;

public class Game {
    public static void main(String[] args){
        JFrame jFrame = new JFrame("Snake");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(Constants.BOARD_WIDTH,Constants.BOARD_HEIGHT);
        jFrame.setResizable(false);
        //jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        Session session = new Session(jFrame);
    }
}
