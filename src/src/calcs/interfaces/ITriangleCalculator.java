package calcs.interfaces;

import controller.Point;

public interface ITriangleCalculator {
    public int[] calculateXVertices(Point startPoint, Point endPoint);
    public int[] calculateYVertices(Point startPoint, Point endPoint);
}
