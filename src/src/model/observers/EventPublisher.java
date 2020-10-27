package model.observers;

import java.util.ArrayList;

import model.interfaces.IShapeList;
import model.interfaces.IListener;

public class EventPublisher {

    private ArrayList<IListener> listeners;
    
    public EventPublisher(){
        listeners = new ArrayList<>();
    }

    public void addListeners(IListener listener){
        listeners.add(listener);
    }

    public void removeListeners(IListener listener){
        this.listeners.remove(listener);
    }

    public void notifyListeners(IShapeList selectedShapeList, IShapeList shapeList){
        for(IListener listener:this.listeners){
            listener.update(selectedShapeList, shapeList);
        }
    }
}
