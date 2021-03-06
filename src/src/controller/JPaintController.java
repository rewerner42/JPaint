package controller;

import java.io.IOException;

import controller.commands.*;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
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
        uiModule.addEvent(EventName.DELETE,
                () -> new DeleteShapeCommand(applicationState.getSelected(), applicationState.getShapes()).run());
        uiModule.addEvent(EventName.COPY, () -> new CopyCommand(applicationState).run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteCommand(applicationState).run());
        
        uiModule.addEvent(EventName.GROUP, () -> {
            try {
                new GroupCommand(applicationState).run();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        
        uiModule.addEvent(EventName.UNGROUP, () -> {
            try {
                new UnGroupCommand(applicationState).run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().run());
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().run());

        
    }
}
