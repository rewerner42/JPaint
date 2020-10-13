package model.shapes;

import java.util.ArrayList;
import java.util.Iterator;

import model.interfaces.IShape;
import model.interfaces.IShapeList;

public class NonArtisticShapeList implements IShapeList{
    
    private ArrayList<IShape> canvasShapes = new ArrayList<>();

    public NonArtisticShapeList(){

    }

    public void addShape(IShape shape){
        canvasShapes.add(shape);
    }

    public void removeShape(IShape shape){
        canvasShapes.remove(shape);
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
