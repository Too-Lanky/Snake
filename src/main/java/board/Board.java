package board;

import javax.swing.JFrame;

public class Board {

    private Board(){
        JFrame jFrame = new JFrame("Snake");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(Constants.BOARD_WIDTH,Constants.BOARD_HEIGHT);
        jFrame.add(new Game());
        jFrame.setResizable(false);
        //jFrame.pack();
        jFrame.setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        new Board();
    }
}
