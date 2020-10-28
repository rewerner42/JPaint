package calcs;

import calcs.interfaces.IDirection;

public class yDirection implements IDirection{

    private Directions yDir;

    public yDirection(Directions y){
        this.yDir = y;
    }

    @Override
    public Directions getDirection() {
        return this.yDir;
    }
    
}
