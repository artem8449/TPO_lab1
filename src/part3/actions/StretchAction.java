package part3.actions;

public class StretchAction extends Action {
    @Override
    public String getDescription() {
        return "Простираться";
    }

    @Override
    public int hashCode() {
        return getDescription().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        return (obj instanceof StretchAction);
    }
}
