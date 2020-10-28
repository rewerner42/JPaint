package calcs;

import model.interfaces.IShape;
import controller.Point;

public class Intersection {

    public static boolean intersect(IShape shape, Point selectionBeginning, Point selectionEnding){
        return contains(shape,selectionBeginning,selectionEnding);
    }

    private static boolean contains(IShape shape, Point selectionBeginning, Point selectionEnding){
        Point sPoint = shape.getStartPoint();
        Point ePoint = shape.getEndPoint();

        int x1 = sPoint.getX();
        int x2 = ePoint.getX();
        int x3 = sPoint.getX();
        int x4 = ePoint.getX();
        int y1 = sPoint.getY();
        int y2 = ePoint.getY();
        int y3 = ePoint.getY();
        int y4 = sPoint.getY();

        int [] x = {x1,x2,x3,x4};
        int [] y = {y1,y2,y3,y4};

        int maxX = Math.max(selectionBeginning.getX(),selectionEnding.getX());
        int minX = Math.min(selectionBeginning.getX(),selectionEnding.getX());
        int minY = Math.min(selectionBeginning.getY(),selectionEnding.getY());
        int maxY = Math.max(selectionBeginning.getY(),selectionEnding.getY());

        for (int i = 0; i<4; i++){
            if (isIn(x[i],y[i],maxX, minX, minY, maxY)) {
                return true;
            }
        }
        for(int i = 0; i<4; i++){
            for(int j = i+1; j<4; j++ ){
                if(crosses(x[i],y[i],x[j],y[j],maxX, minX, minY, maxY)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isIn(int x, int y, int maxX , int minX, int minY, int maxY){
        if (x <= maxX && x >= minX && y <= maxY && y >= minY) {
            return true;
        }
        return false;
    }
    private static boolean crosses(int x1, int y1, int x2, int y2, int maxX , int minX, int minY, int maxY){
        if((x1 <= maxX && x2 >= minX && y1 >= maxY && y2 <= minY )|| (x1 >= maxX && x2 <= minX && y1 <= maxY && y2 >= minY) 
                || (x2 <= maxX && x1 >= minX && y2 >= maxY && y1 <= minY )|| (x2 >= maxX && x1 <= minX && y2 <= maxY && y1 >= minY ) ){
            return true;
        }
        return false;
    }
}
