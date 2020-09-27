package patr3;

import java.util.Stack;

public class Universe_object {
    public Universe_object(Universe_objectName name, Stack<Action> actions, SerfaceType type) {
        this.name = name;
        this.actions = actions;
        this.type = type;
    }

    private Stack<Action> actions;

    Universe_objectName name;

    Double lightlevel;

    SerfaceType type;

    public Stack<Action> getActions() {
        return actions;
    }

    public void setActions(Stack<Action> actions) {
        this.actions = actions;
    }

    public Action getState() {
        return state;
    }

    private Action state;

    public Universe_objectName getName() {
        return name;
    }

    public SerfaceType getType() {
        return type;
    }

    public void setLightlevel(double level) {
        this.lightlevel = level;
    }

    public boolean doAction(){
        if( actions.size() > 0 ) {
            Action newAction = actions.pop();
            state = newAction;
            return true;
        }
        return false;
    }




}
