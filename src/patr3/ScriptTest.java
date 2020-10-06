package patr3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScriptTest {

    Script script;
    Action[] zafodActions, universeActions;

    JumpTolegAction jumpTolegAction = new JumpTolegAction();
    WatchAroundActon watchAroundActon = new WatchAroundActon();
    StretchAction stretchAction = new StretchAction();
    ShineAction shineAction = new ShineAction();

    @Before
    public void setUp() {
        script = new Script(0);

        zafodActions = new Action[script.actNum];
        zafodActions[0] = jumpTolegAction;
        zafodActions[1] = watchAroundActon;
        universeActions = new Action[script.actNum];
        universeActions[0] = stretchAction;
        universeActions[1] = shineAction;

    }

    @Test
    public void initScene() {
        assertEquals(script.zafod.getName(), PersonName.ZAFOD);
        assertEquals(script.planet.getName(), UniverseObjectName.PLANET);
        assertEquals(script.zafod.getActions().size(), script.actNum);
        assertEquals(script.planet.getActions().size(), script.actNum);
        assertEquals(script.planet.getType(), SerfaceType.GOLD);
    }

    @Test
    public void scriptPath() {
        int i = 0;
        while(script.nextState()) {
            assertEquals(script.planet.getState(), universeActions[i]);
            assertEquals(script.zafod.getState(), zafodActions[i]);
            i++;
        }

    }

    @Test
    public void lightLevelPlanet()  {

        double lightLevel = Double.POSITIVE_INFINITY;
        stretchAction.getDescription();
        shineAction.getDescription();
        shineAction.setLightLevel(script.planet, script.zafod);
        shineAction.getLightLevel(script.planet);
        jumpTolegAction.getDescription();
        watchAroundActon.getDescription();
        watchAroundActon.setLightLevel(script.planet, script.zafod);


        assertEquals(script.planet.getLightLevel(), lightLevel, 1E-5);


        }


    @Test
    public void lightLevelPerson()  {

        double lightLevel = Double.POSITIVE_INFINITY;
        stretchAction.getDescription();
        shineAction.getDescription();
        shineAction.setLightLevel(script.planet, script.zafod);
        shineAction.getLightLevel(script.planet);
        jumpTolegAction.getDescription();
        jumpTolegAction.setLightLevel(script.planet, script.zafod);
        watchAroundActon.getDescription();
        watchAroundActon.setLightLevel(script.planet, script.zafod);

        assertEquals(script.zafod.getSeeLightLevel(), lightLevel, 1E-5);

    }


    }


