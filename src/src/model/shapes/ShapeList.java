package model.shapes;

import java.util.ArrayList;
import java.util.Iterator;

import model.ShapeDrawer;
import model.interfaces.IShape;

public class ShapeList implements Iterable<IShape>{
    
    private ArrayList<IShape> canvasShapes = new ArrayList<>();

    private final ShapeDrawer shapeDrawer;

    public ShapeList(ShapeDrawer shapeDrawer){
        this.shapeDrawer = shapeDrawer;
    }

    public void addShape(IShape shape){
        canvasShapes.add(shape);
        makeArt();
    }

    public void removeShape(IShape shape){
        canvasShapes.remove(shape);
        makeArt();
    }

    private void makeArt(){
        this.shapeDrawer.worker(this);
    }

    @Override
    public Iterator<IShape> iterator(){
        return canvasShapes.iterator();
    }

}
