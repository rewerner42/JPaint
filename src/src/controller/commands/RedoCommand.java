package controller.commands;

import controller.CommandHistory;
import model.interfaces.ICommand;

public class RedoCommand implements ICommand{
    @Override
    public void run(){
        CommandHistory.redo();
    }
}
