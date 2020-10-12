package part3.actions;

public class LookAroundAction extends Action {

    @Override
    public String getDescription() {
        return "Осмотреться";
    }

    @Override
    public int hashCode() {
        return getDescription().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        return (obj instanceof LookAroundAction);
    }

}
