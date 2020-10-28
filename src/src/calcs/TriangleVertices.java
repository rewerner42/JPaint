package calcs;

import calcs.interfaces.ITriangleCalculator;
import controller.Point;

public class TriangleVertices {

    private ITriangleCalculator calculator;

    public TriangleVertices(){
        this.calculator = new NullStrategy();
    }

    public int[] getXVertices(Point startPoint, Point endPoint){
        int[] xPoints=this.calculator.calculateXVertices(startPoint,endPoint);
        return xPoints;
    }

    public int[] getYVertices(Point startPoint, Point endPoint){
        int[] yPoints=calculator.calculateYVertices(startPoint,endPoint);
        return yPoints;
    }
    
    public void setStrategy(ITriangleCalculator calculator){
        this.calculator = calculator;
    }

}
