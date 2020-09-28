package patr3;

import java.util.Stack;

public class Person {
    public Person(PersonName name, Stack<Action> actions) {
        this.name = name;
        this.actions = actions;
    }

    Integer standup = 0;

    Double seelightlevel = 0.0;

    public Stack<Action> getActions() {
        return actions;
    }

    public void setActions(Stack<Action> actions) {
        this.actions = actions;
    }

    private Stack<Action> actions;

    public Action getState() {
        return state;
    }

    public Double getSeelightlevel() {
        return seelightlevel;
    }

    public Integer getStandup() {
        return standup;
    }

    private Action state;

    public PersonName getName() {
        return name;
    }

    PersonName name;

    public boolean doAction(){
        if( actions.size() > 0 ) {
            Action newAction = actions.pop();
            state = newAction;
            return true;
        }
        return false;
    }
}