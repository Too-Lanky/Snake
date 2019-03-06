package board;

import java.awt.*;

public class Food {
    int x;
    int y;

    Food(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics g, Color c, int x, int y){
        g.drawRect(x,y,Constants.BODY_SIZE,Constants.BODY_SIZE);
        g.setColor(c);
        g.fillRect(x,y,Constants.BODY_SIZE,Constants.BODY_SIZE);
    }
}
