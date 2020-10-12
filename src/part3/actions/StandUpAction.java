package part3.actions;

public class StandUpAction extends Action {
    @Override
    public String getDescription() {
        return "Вскочить на ноги";
    }

    @Override
    public int hashCode() {
        return getDescription().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        return (obj instanceof StandUpAction);
    }
}
