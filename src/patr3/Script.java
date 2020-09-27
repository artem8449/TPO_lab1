package patr3;

import java.util.Stack;

public class Script {

    int actNum = 2;
    Person zafod;
    Universe_object planet;
    JumpTolegAction jumpTolegAction = new JumpTolegAction();
    WatchAroundActon watchAroundActon = new WatchAroundActon();
    StretchAction stretchAction = new StretchAction();
    ShineAction shineAction = new ShineAction();

    public void restart(){
        Stack<Action> zafodActions = new Stack<>();

        zafodActions.push(jumpTolegAction);

        zafodActions.push(watchAroundActon);
        zafod = new Person(PersonName.ZAFOD, zafodActions);

        Stack<Action> universeActions = new Stack<>();

        universeActions.push(stretchAction);

        universeActions.push(shineAction);
        planet = new Universe_object(Universe_objectName.PLANET, universeActions, SerfaceType.GOLD);
    }

    public void start(){
        stretchAction.getDescription();
        shineAction.getDescription();
        shineAction.setLightlevel(planet, zafod);
        shineAction.getLightLevel(planet);
        jumpTolegAction.getDescription();
        watchAroundActon.getDescription();
        watchAroundActon.setLightlevel(planet, zafod);

    }

    public Script(){
        restart();
        start();
    }

    public boolean nextState(){
        boolean bodyNext = planet.doAction();
        boolean fortNext = zafod.doAction();
        return !fortNext || !bodyNext;
    }
}
