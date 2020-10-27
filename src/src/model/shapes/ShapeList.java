package model.shapes;

import java.util.ArrayList;
import java.util.Iterator;

import model.ShapeDrawer;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

public class ShapeList implements IShapeList{
    
    private ArrayList<IShape> canvasShapes = new ArrayList<>();
    private int l = 0;
    private ShapeDrawer shapeDrawer;

    public ShapeList(ShapeDrawer shapeDrawer){
        this.shapeDrawer = shapeDrawer;
    }

    public ShapeList(){

    }

    public void addShape(IShape shape){
        canvasShapes.add(shape);
        l = l +1;
        System.out.println(l);
        makeArt();
    }

    public void removeShape(IShape shape){
        canvasShapes.remove(shape);
        l = l - 1;
        System.out.println(l);
        makeArt();
    }

    public void makeArt(){
        this.shapeDrawer.worker(this);
    }

    public boolean containsShape(IShape shape){
        for(IShape tShape:this.canvasShapes){
            if(shape == tShape){
                return true;
            }
        }
        return false;
    }
    @Override
    public void clearList() {
        canvasShapes = new ArrayList<>();
    }

    @Override
    public Iterator<IShape> iterator(){
        return canvasShapes.iterator();
    }

}
