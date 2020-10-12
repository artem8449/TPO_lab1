package part3.actions;

import part3.UniverseObject;

public abstract class Action {
    public abstract String getDescription();
    public void startPerforming(UniverseObject actor) {
        System.out.println(actor.getName() + " начал(а) действие: " + getDescription());
    }
    public void finishPerforming(UniverseObject actor) {
        System.out.println(actor.getName() + " закончил(а) действие: " + getDescription());
    }
}
