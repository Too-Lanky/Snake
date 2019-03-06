package board;

import java.awt.Graphics;
import java.awt.Color;
import java.util.LinkedList;

public class Snake {
    LinkedList<BodyParts> body;

    Snake(int x, int y){
        body = new LinkedList<BodyParts>();
        body.add(new BodyParts(x,y));
    }

    public void move(Direction d,Graphics g){
        BodyParts moveBodyPart = body.getFirst();

        switch(d) {
        case UP:
            for (BodyParts bodypart : body) {
                System.out.println("("+bodypart.getX()+","+bodypart.getY()+")");
                if (bodypart.equals(body.peekFirst())) {
                    bodypart.setY(bodypart.getY() - 10);
                    draw(g, Color.GREEN, bodypart.getX(), bodypart.getY());
                }else {
                    draw(g, Color.ORANGE, moveBodyPart.getX(), moveBodyPart.getY());
                }
            }
            break;
        case DOWN:
            for (BodyParts bodypart : body) {
                System.out.println("("+bodypart.getX()+","+bodypart.getY()+")");
                if (bodypart.equals(body.peekFirst())) {
                    bodypart.setY(bodypart.getY() + 10);
                    draw(g, Color.GREEN, bodypart.getX(), bodypart.getY());
                }else {
                    draw(g, Color.ORANGE, moveBodyPart.getX(), moveBodyPart.getY());
                    moveBodyPart = bodypart;
                }
            }
            break;
        case LEFT:
            for (BodyParts bodypart : body) {
                System.out.println("("+bodypart.getX()+","+bodypart.getY()+")");
                if (bodypart.equals(body.peekFirst())) {
                    bodypart.setX(bodypart.getX() - 10);
                    draw(g, Color.GREEN, bodypart.getX(), bodypart.getY());
                }else {
                    draw(g, Color.ORANGE, moveBodyPart.getX(), moveBodyPart.getY());
                    moveBodyPart = bodypart;
                }
            }
            break;
        case RIGHT:
            for (BodyParts bodypart : body) {
                System.out.println("("+bodypart.getX()+","+bodypart.getY()+")");
                if (bodypart.equals(body.peekFirst())) {
                    bodypart.setX(bodypart.getX() + 10);
                    draw(g, Color.GREEN, bodypart.getX(), bodypart.getY());
                }else {
                    draw(g, Color.ORANGE, moveBodyPart.getX(), moveBodyPart.getY());
                    moveBodyPart = bodypart;
                }
            }
            break;
        }
    }

    public void draw(Graphics g, Color c, int x, int y){
        g.drawRect(x,y,Constants.BODY_SIZE,Constants.BODY_SIZE);
        g.setColor(c);
        g.fillRect(x,y,Constants.BODY_SIZE,Constants.BODY_SIZE);
    }

    public void grow(BodyParts bodyPart){
        body.addLast(new BodyParts(bodyPart.getX(),bodyPart.getY()));
    }

    public LinkedList<BodyParts> getBody() {
        return body;
    }

    public BodyParts getHead(){
        return body.getFirst();
    }
}
