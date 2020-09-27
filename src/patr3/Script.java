package patr3;

import java.util.Stack;

public class Script {

    int actNum = 2;
    Person zafod;
    Universe_object planet;

    public void restart(){
        Stack<Action> zafodActions = new Stack<>();
        zafodActions.push(new JumpTolegAction());
        zafodActions.push(new WatchAroundActon());
        zafod = new Person(PersonName.ZAFOD, zafodActions);

        Stack<Action> universeActions = new Stack<>();
        universeActions.push(new StretchAction());
        universeActions.push(new ShineAction());
        planet = new Universe_object(Universe_objectName.PLANET, universeActions, SerfaceType.GOLD);
    }

    public Script(){
        restart();
    }

    public boolean nextState(){
        boolean fortNext = zafod.doAction();
        boolean bodyNext = planet.doAction();
        return !fortNext || !bodyNext;
    }
}
