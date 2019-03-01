package board;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private int x;
    private int y;
    List<BodyParts> body;

    Snake(int x, int y){
        body = new LinkedList<BodyParts>();
        body.add(new BodyParts(x,y));
    }

    public void move(int x, int y){

    }

}
