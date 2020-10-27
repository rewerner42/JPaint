package controller;

import controller.commands.*;
import model.interfaces.IApplicationState;
import model.interfaces.IListener;
import view.EventName;
import view.interfaces.IUiModule;
import model.observers.Clipboard;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final IListener clipBoard;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.clipBoard = new Clipboard();
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteShapeCommand(applicationState.getSelected(),applicationState.getShapes()).run());
        uiModule.addEvent(EventName.COPY, () -> new CopyCommand(applicationState).run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteCommand(applicationState).run());

        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().run());
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().run());
    }
}
