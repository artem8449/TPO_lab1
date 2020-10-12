package part3;


import org.junit.Test;
import part3.actions.*;

import static org.junit.Assert.*;

public class StoryTest {

    @Test
    public void surfaceTypeTest() {
        Surface surface = new Surface(SurfaceType.SILVER);
        assertEquals(SurfaceType.SILVER, surface.getType());
    }

    @Test
    public void planetSurfaceTest() {
        Surface surface = new Surface(SurfaceType.GOLD);
        Planet planet = new Planet(surface);
        assertEquals(surface, planet.getSurface());
    }

    @Test
    public void personNameTest() {
        String name = "Test string";
        Person person = new Person(name);
        assertEquals(name, person.getName());
    }

    @Test
    public void storyFinishesTest() {
        try {
            Story.main(new String[] {});
        }
        catch (Exception e) {
            fail();
        }
    }

    @Test
    public void lookAroundTest() {
        Person person = new Person("Test person");
        LookAroundAction action = new LookAroundAction();
        person.startAction(action);

        assertTrue(person.getCurrentActions().contains(action));
        assertFalse(person.getFinishedActions().contains(action));

        person.finishAction(action);
        assertTrue(person.getFinishedActions().contains(action));
        assertFalse(person.getCurrentActions().contains(action));
    }

    @Test
    public void actionFinishBeforeStartTest() {
        Person person = new Person("Test person");
        LookAroundAction action = new LookAroundAction();
        try {
            person.finishAction(action);
            fail();
        }
        catch (IllegalArgumentException ignored) { }
    }

    @Test
    public void planetNameTest() {
        Surface surface = new Surface(SurfaceType.GOLD);
        Planet planet = new Planet(surface);
        assertEquals("Планета", planet.getName());
    }

    @Test
    public void shineLevelTest() {
        ShineAction shine = new ShineAction(ShineLevel.MEDIUM);
        assertEquals(ShineLevel.MEDIUM, shine.getShineLevel());
    }

    @Test
    public void actionsEqualsTest() {
        LookAroundAction lookAround = new LookAroundAction();
        ShineAction shine = new ShineAction(ShineLevel.HIGH);
        StandUpAction standUp = new StandUpAction();
        StretchAction stretch = new StretchAction();

        assertEquals(new LookAroundAction(), lookAround);
        assertEquals(new ShineAction(ShineLevel.HIGH), shine);
        assertEquals(new StandUpAction(), standUp);
        assertEquals(new StretchAction(), stretch);
    }

    @Test
    public void actionsNotEqualsTest() {
        LookAroundAction lookAround = new LookAroundAction();
        ShineAction shine = new ShineAction(ShineLevel.HIGH);
        StandUpAction standUp = new StandUpAction();
        StretchAction stretch = new StretchAction();

        assertNotEquals(lookAround, shine);
        assertNotEquals(lookAround, standUp);
        assertNotEquals(lookAround, stretch);
        assertNotEquals(shine, standUp);
        assertNotEquals(shine, stretch);
        assertNotEquals(standUp, stretch);
    }

    @Test
    public void actionsHashCodesTest() {
        LookAroundAction lookAround = new LookAroundAction();
        ShineAction shine = new ShineAction(ShineLevel.HIGH);
        StandUpAction standUp = new StandUpAction();
        StretchAction stretch = new StretchAction();

        assertEquals(new LookAroundAction().hashCode(), lookAround.hashCode());
        assertEquals(new ShineAction(ShineLevel.HIGH).hashCode(), shine.hashCode());
        assertEquals(new StandUpAction().hashCode(), standUp.hashCode());
        assertEquals(new StretchAction().hashCode(), stretch.hashCode());

        assertNotEquals(lookAround.hashCode(), shine.hashCode());
        assertNotEquals(shine.hashCode(), standUp.hashCode());
        assertNotEquals(standUp.hashCode(), stretch.hashCode());
    }

}
