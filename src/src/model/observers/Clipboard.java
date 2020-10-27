package model.observers;

import model.interfaces.IListener;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import model.shapes.NonArtisticShapeList;

public class Clipboard implements IListener {

    IShapeList clipBoard;

    public Clipboard(){
        this.clipBoard = new NonArtisticShapeList();
    }

    @Override
    public void update(IShapeList selectedShapeList, IShapeList shapeList) {
        for(IShape shape:selectedShapeList){
            this.clipBoard.addShape(shape);
        }
    }
    
}
