package calcs;

public class DirectionPointer {
    
    static Directions findXDirection(int x1, int x2){
        if(x1 > x2){
            return Directions.LEFT;
        }
        return Directions.RIGHT;
    }
    static Directions findYDirection(int y1, int y2){
        if (y1 > y2){
            return Directions.UP;
        }
        return Directions.DOWN;
    }

}
