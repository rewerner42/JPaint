package calcs;

import calcs.interfaces.ITriangleCalculator;
import controller.Point;

public class NullStrategy implements ITriangleCalculator {

    @Override
    public int[] calculateXVertices(Point startPoint, Point endPoint) {
        return null;
    }

    @Override
    public int[] calculateYVertices(Point startPoint, Point endPoint) {
        return null;
    }
    
}
