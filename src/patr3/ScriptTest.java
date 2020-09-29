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
    public void setUp() throws Exception {
        script = new Script(0);

        zafodActions = new Action[script.actNum];
        zafodActions[0] = jumpTolegAction;
        zafodActions[1] = watchAroundActon;
        universeActions = new Action[script.actNum];
        universeActions[0] = stretchAction;
        universeActions[1] = shineAction;

    }

    @Test
    public void initscene() throws Exception {
        assertEquals(script.zafod.getName(), PersonName.ZAFOD);
        assertEquals(script.planet.getName(), Universe_objectName.PLANET);
        assertEquals(script.zafod.getActions().size(), script.actNum);
        assertEquals(script.planet.getActions().size(), script.actNum);
        assertEquals(script.planet.getType(), SerfaceType.GOLD);
    }

    @Test
    public void scriptpath() throws Exception {
        int i = 0;
        while(script.nextState()) {
            assertEquals(script.planet.getState(), universeActions[i]);
            assertEquals(script.zafod.getState(), zafodActions[i]);
            i++;
        }

    }

    @Test
    public void lightlevelplanet() throws Exception {

        double lightlevel = Double.POSITIVE_INFINITY;
        stretchAction.getDescription();
        shineAction.getDescription();
        shineAction.setLightlevel(script.planet, script.zafod);
        shineAction.getLightLevel(script.planet);
        jumpTolegAction.getDescription();
        watchAroundActon.getDescription();
        watchAroundActon.setLightlevel(script.planet, script.zafod);



        assertEquals(script.planet.getLightlevel(), lightlevel, 1E-5);


        }


    @Test
    public void lightlevelperson() throws Exception {

        double lightlevel = Double.POSITIVE_INFINITY;
        stretchAction.getDescription();
        shineAction.getDescription();
        shineAction.setLightlevel(script.planet, script.zafod);
        shineAction.getLightLevel(script.planet);
        jumpTolegAction.getDescription();
        jumpTolegAction.setLightlevel(script.planet, script.zafod);
        watchAroundActon.getDescription();
        watchAroundActon.setLightlevel(script.planet, script.zafod);


        assertEquals(script.zafod.getSeelightlevel(), lightlevel, 1E-5);

    }


    }


