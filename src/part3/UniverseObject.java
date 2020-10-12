package part3;

import part3.actions.Action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class UniverseObject {
    private List<Action> currentActions = new ArrayList<>();
    private List<Action> finishedActions = new ArrayList<>();

    public List<Action> getCurrentActions() {
        return Collections.unmodifiableList(currentActions);
    }

    public List<Action> getFinishedActions() {
        return Collections.unmodifiableList(finishedActions);
    }

    public void startAction(Action action) {
        if (!currentActions.contains(action)) {
            currentActions.add(action);
            action.startPerforming(this);
        }
    }

    public void finishAction(Action action) {
        if (!currentActions.contains((action)))
            throw new IllegalArgumentException("Нельзя завершить действие, которое ещё не началось");
        currentActions.remove(action);

        if (!finishedActions.contains(action)) {
            finishedActions.add(action);
            action.finishPerforming(this);
        }
    }

    public abstract String getName();
}
