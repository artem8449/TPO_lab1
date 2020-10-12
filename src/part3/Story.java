package part3;

import part3.actions.*;

public class Story {
    public static void main(String[] args) {
        Person zafod = new Person("Зафод");
        StandUpAction standUp = new StandUpAction();
        LookAroundAction lookAround = new LookAroundAction();

        StretchAction stretch = new StretchAction();
        ShineAction shine = new ShineAction(ShineLevel.HIGHEST);
        Surface goldenSurface = new Surface(SurfaceType.GOLD);
        Planet goldenPlanet = new Planet(goldenSurface);
        goldenPlanet.getSurface().startAction(stretch);
        goldenPlanet.getSurface().startAction(shine);

        zafod.startAction(standUp);
        zafod.finishAction(standUp);
        zafod.startAction(lookAround);

        for (Action action : goldenPlanet.getSurface().getCurrentActions()) {
            if (action.getClass() == StretchAction.class) {
                System.out.println("Во все стороны простиралась поверхность из материала: " +
                        goldenPlanet.getSurface().getType());
            }
            if (action.getClass() == ShineAction.class) {
                System.out.println("Поверхность блестела...");
                if (((ShineAction)action).getShineLevel() == ShineLevel.HIGHEST) {
                    System.out.println("...как ничто другое во Вселенной.");
                }
            }
        }

    }
}
