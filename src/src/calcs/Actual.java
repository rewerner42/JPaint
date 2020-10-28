package calcs;

import calcs.interfaces.ITriangleCalculator;
import controller.Point;

public class Actual implements ITriangleCalculator{

    public Actual(){
    }

    @Override
    public int[] calculateXVertices(Point startPoint, Point endPoint) {
        int x1 = startPoint.getX();
        int y1 = startPoint.getY();
        int x2 = endPoint.getX();
        int y2 = endPoint.getY();
        int x3;
        if (y1 > y2){ // if upwards movement
            x3 = x2;
        }
        else{ // if downwards movement
            x3 = x1;
         }
        int [] xPoints = {x1,x2,x3};
        return xPoints;
    }

    @Override
    public int[] calculateYVertices(Point startPoint, Point endPoint) {
        int y1 = startPoint.getY();
        int y2 = endPoint.getY();
        int y3;
        if (y1 > y2){ // if upwards movement
            y3 = y1;
        }
        else{ // if downwards movement
            y3 = y2;
         }
        int [] yPoints = {y1,y2,y3};
        return yPoints;
    }
    
}
