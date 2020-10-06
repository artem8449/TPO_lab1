package patr3;

import java.util.Stack;

public class Script {

    int actNum = 2;
    Person zafod;
    UniverseObject planet;
    JumpTolegAction jumpToLegAction = new JumpTolegAction();
    WatchAroundActon watchAroundActon = new WatchAroundActon();
    StretchAction stretchAction = new StretchAction();
    ShineAction shineAction = new ShineAction();

    public void restart(int var){
        Stack<Action> zafodActions = new Stack<>();
        zafodActions.push(jumpToLegAction);
        zafodActions.push(watchAroundActon);

        zafod = new Person(PersonName.ZAFOD, zafodActions);
        Stack<Action> universeActions = new Stack<>();
        universeActions.push(stretchAction);
        universeActions.push(shineAction);

        if (var == 0)
            planet = new UniverseObject(UniverseObjectName.PLANET, universeActions, SerfaceType.GOLD);
        else
            planet = new UniverseObject(UniverseObjectName.PLANET, universeActions, SerfaceType.SILVER);
    }

    public void start(){
        stretchAction.getDescription();
        shineAction.getDescription();
        shineAction.setLightLevel(planet, zafod);
        shineAction.getLightLevel(planet);
        jumpToLegAction.getDescription();
        watchAroundActon.getDescription();
        watchAroundActon.setLightLevel(planet, zafod);

    }

    public Script(int variant){
        restart(variant);
    //    start();
    }

    public boolean nextState(){
        boolean planetNext = planet.doAction();
        boolean zafodNext = zafod.doAction();
        return !zafodNext || !planetNext;
    }
}
