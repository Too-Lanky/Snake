package board;

import java.awt.Graphics;
import java.awt.Color;
import java.util.LinkedList;

public class Snake {
    private int x;
    private int y;
    LinkedList<BodyParts> body;

    Snake(int x, int y){
        body = new LinkedList<BodyParts>();
        body.add(new BodyParts(x,y));
    }

    public void move(Direction d,Graphics g){
        switch(d) {
            case UP:
            for (BodyParts bodypart : body) {
                bodypart.setY(bodypart.getY() - 1);
                if (bodypart.equals(body.peekFirst())) {
                    draw(g, Color.GREEN, bodypart.getX(), bodypart.getY());
                }
                draw(g, Color.ORANGE, bodypart.getX(), bodypart.getY());
            }
            case DOWN:
                for (BodyParts bodypart : body) {
                    bodypart.setY(bodypart.getY() + 1);
                    if (bodypart.equals(body.peekFirst())) {
                        draw(g, Color.GREEN, bodypart.getX(), bodypart.getY());
                    }
                    draw(g, Color.ORANGE, bodypart.getX(), bodypart.getY());
                }
            case LEFT:
                for (BodyParts bodypart : body) {
                    bodypart.setX(bodypart.getX() - 1);
                    if (bodypart.equals(body.peekFirst())) {
                        draw(g, Color.GREEN, bodypart.getX(), bodypart.getY());
                    }
                    draw(g, Color.ORANGE, bodypart.getX(), bodypart.getY());
                }
            case RIGHT:
                for (BodyParts bodypart : body) {
                    bodypart.setX(bodypart.getX() + 1);
                    if (bodypart.equals(body.peekFirst())) {
                        draw(g, Color.GREEN, bodypart.getX(), bodypart.getY());
                    }
                    draw(g, Color.ORANGE, bodypart.getX(), bodypart.getY());
                }
        }
    }

    public void draw(Graphics g, Color c, int x, int y){
        g.drawRect(x,y,Constants.BODY_SIZE,Constants.BODY_SIZE);
        g.setColor(c);
        g.fillRect(x,y,Constants.BODY_SIZE,Constants.BODY_SIZE);
    }

    public void grow(BodyParts tail){

    }

}
