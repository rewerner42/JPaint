package model.interfaces;

public interface IShapeList extends Iterable<IShape>{
    public void addShape(IShape shape);
    public void removeShape(IShape shape);
    public boolean containsShape(IShape shape);
    public void clearList();
}
