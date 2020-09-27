package patr3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScriptTest {

    Script script;
    Action[] zafodActions, universeActions;

    @Before
    public void setUp() throws Exception {
        script = new Script();
        zafodActions = new Action[script.actNum];
        zafodActions[0] = new JumpTolegAction();
        zafodActions[1] = new WatchAroundActon();
        universeActions = new Action[script.actNum];
        universeActions[0] = new StretchAction();
        universeActions[1] = new ShineAction();

    }

    @Test
    public void initscene() throws Exception {
        assertEquals(script.zafod.getName(), PersonName.ZAFOD);
        assertEquals(script.planet.getName(), Universe_objectName.PLANET);
        assertEquals(script.zafod.getActions().size(), script.actNum);
        assertEquals(script.planet.getActions().size(), script.actNum);
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
    public void lightlevel() throws Exception {

        double lightlevel = Double.POSITIVE_INFINITY;
        int i = 0;
        while (script.nextState()) {
            if (i == 0) {
                assertEquals(script.planet.getLightlevel(), lightlevel, 1E-5);
                assertEquals(script.zafod.getSeelightlevel(), lightlevel, 1E-5);
                i++;
            }


        }
    }


}