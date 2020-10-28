package controller.commands;

import calcs.Intersection;
import controller.*;
import model.interfaces.*;
import model.shapes.NonArtisticShapeList;
import model.shapes.ShapeList;

public class SelectCommand implements ICommand,IUndoable{
    
    private IShapeList thisSelection;
    private IShapeList selectedShapeList;
    private IShapeList shapeList;
    private Point selectionBeginning;
    private Point selectionEnding;

    public SelectCommand (Point startPoint, Point endPoint, IShapeList shapeList, IShapeList selectedShapeList){
        this.shapeList = shapeList;
        this.selectedShapeList = selectedShapeList;
        this.selectionBeginning = startPoint;
        this.selectionEnding = endPoint;
        this.thisSelection = new NonArtisticShapeList();
    }
    @Override
    public void run(){
        System.out.println("Now Selecting.");
        addToList();
        CommandHistory.add(this);
    }
    @Override
    public void redo(){
        addToList(this.thisSelection);
    }
    @Override 
    public void undo(){
        removeFromList();
    }

    private void addToList(){
        selectedShapeList.clearList();
        for (IShape shape:this.shapeList){
            if (Intersection.intersect(shape,this.selectionBeginning,this.selectionEnding)){
                System.out.println(shape);
                this.selectedShapeList.addShape(shape);
                this.thisSelection.addShape(shape);
            }
        }
        doArt();
    }
    private void addToList(IShapeList list){
        list.clearList();
        for (IShape shape:list){
            if (Intersection.intersect(shape,this.selectionBeginning,this.selectionEnding)){
                System.out.println(shape);
                this.selectedShapeList.addShape(shape);
            }
        }
        doArt();
    }
    private void removeFromList(){
        for (IShape shape:thisSelection){
            this.selectedShapeList.removeShape(shape);
        }
        doArt();
    }

    private void doArt(){
        ShapeList temp = (ShapeList) this.shapeList;
        temp.makeArt();
    }
}
