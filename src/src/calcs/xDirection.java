package calcs;

import calcs.interfaces.IDirection;

public class xDirection implements IDirection{

    private Directions xDir;

    public xDirection(Directions x){
        this.xDir = x;
    }

    @Override
    public Directions getDirection() {
        return this.xDir;
    }
    
}
