package calcs;

import calcs.interfaces.ITriangleCalculator;
import controller.Point;

public class Outline implements ITriangleCalculator{

    @Override
    public int[] calculateXVertices(Point startPoint, Point endPoint) {
        int x1 = startPoint.getX();
        int y1 = startPoint.getY();
        int x2 = endPoint.getX();
        int y2 = endPoint.getY();
        int x3;
        if (y1 > y2){ // if upwards movement        
            if(x1 > x2){ //leftwards
                x1 = x1 + 10;//D
                x2 = x2 - 5;
            }
            else{//rightwards
                x1 = x1 - 10;//D
                x2 = x2 + 5;
            }
            x3 = x2;
        }
        else{ // if downwards movement
            if(x1 > x2){
                x1 = x1 + 5;
                x2 = x2 - 10;//D
            }
            else{
                x1 = x1 - 5;
                x2 = x2 + 10;//D  
            }
            x3 = x1;
        }
        int [] nxPoints = {x1,x2,x3};
        return nxPoints;
    }

    @Override
    public int[] calculateYVertices(Point startPoint, Point endPoint) {
        int y1 = startPoint.getY();
        int y2 = endPoint.getY();
        int y3;
        if (y1 > y2){ // if upwards movement
            y2 = y2 - 10;//D
            y1 = y1 + 5;            
            y3 = y1;
        }
        else{ // if downwards movement
            y1 = y1 - 10;//D
            y2 = y2 + 5;
            y3 = y2;
        }
        int [] nyPoints = {y1,y2,y3};
        return nyPoints;
    }
    
}
