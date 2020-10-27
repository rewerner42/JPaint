package model.shapes;

import java.util.Iterator;

import model.interfaces.IShape;
import model.interfaces.IShapeList;

public class NullShapeList implements IShapeList {
    public NullShapeList() {

    }

    @Override
    public Iterator<IShape> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addShape(IShape shape) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeShape(IShape shape) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean containsShape(IShape shape) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clearList() {
        // TODO Auto-generated method stub

    }    
}
