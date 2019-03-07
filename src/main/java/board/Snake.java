package board;

import java.awt.Graphics;
import java.awt.Color;
import java.util.LinkedList;

public class Snake {
    private LinkedList<BodyPart> body;

    Snake(int x, int y){
        body = new LinkedList<BodyPart>();
        body.add(new BodyPart(x,y));
    }

    public void move(Direction d,Graphics g){

        switch(d) {
        case UP:
            body.addFirst(new BodyPart(body.peek().getX(),body.peek().y -10));
            body.removeLast();
            break;
        case DOWN:
            body.addFirst(new BodyPart(body.peek().getX(),body.peek().y +10));
            body.removeLast();
            break;
        case LEFT:
            body.addFirst(new BodyPart(body.peek().getX() -10,body.peek().y));
            body.removeLast();
            break;
        case RIGHT:
            body.addFirst(new BodyPart(body.peek().getX() +10,body.peek().y));
            body.removeLast();
            break;
        }

        for (BodyPart bodypart : body) {
            System.out.println("("+bodypart.getX()+","+bodypart.getY()+")");
            if (bodypart.equals(body.peekFirst())) {
                draw(g, Color.GREEN, bodypart.getX(), bodypart.getY());
            }else {
                draw(g, Color.ORANGE, bodypart.getX(), bodypart.getY());
            }
        }
    }

    public void draw(Graphics g, Color c, int x, int y){
        g.drawRect(x,y,Constants.BODY_SIZE,Constants.BODY_SIZE);
        g.setColor(c);
        g.fillRect(x,y,Constants.BODY_SIZE,Constants.BODY_SIZE);
    }

    public void grow(BodyPart bodyPart){
        body.addFirst(new BodyPart(bodyPart.getX(),bodyPart.getY()));
    }

    public LinkedList<BodyPart> getBody() {
        return body;
    }

    public BodyPart getHead(){
        return body.getFirst();
    }
}
