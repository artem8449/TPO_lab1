package patr3;

import java.util.Stack;

public class Universe_object {


    private Stack<Action> actions;
    Universe_objectName name;
    Double lightLevel = 0.0;
    SerfaceType type;
    private Action state;



    public Universe_object(Universe_objectName name, Stack<Action> actions, SerfaceType type) {
        this.name = name;
        this.actions = actions;
        this.type = type;
    }



    public Stack<Action> getActions() {
        return actions;
    }

    public void setActions(Stack<Action> actions) {
        this.actions = actions;
    }

    public Action getState() {
        return state;
    }

    public Universe_objectName getName() {
        return name;
    }

    public SerfaceType getType() {
        return type;
    }

    public void setLightLevel(double level) {
        this.lightLevel = level;
    }

    public Double getLightLevel() {
       return lightLevel;
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
