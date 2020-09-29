package patr3;

import java.util.Stack;

public class Person {
    
    Integer standUp = 0;
    Double seeLightLevel = 0.0;
    private Stack<Action> actions;
    private Action state;
    PersonName name;

    public Person(PersonName name, Stack<Action> actions) {
        this.name = name;
        this.actions = actions;
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

    public Double getSeeLightLevel() {
        return seeLightLevel;
    }

    public Integer getStandUp() {
        return standUp;
    }
    
    public PersonName getName() {
        return name;
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