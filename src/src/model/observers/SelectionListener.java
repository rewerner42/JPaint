package model.observers;

import model.interfaces.IApplicationState;
import model.interfaces.IListener;
import model.interfaces.IShapeList;

public class SelectionListener implements IListener{

    IApplicationState appState;

    public SelectionListener(IApplicationState appState){
        this.appState = appState;
    }

    public void update(IShapeList selectedShapeList, IShapeList shapeList){
        this.appState.updateSelectedShapeList(selectedShapeList, shapeList);
    }
}
