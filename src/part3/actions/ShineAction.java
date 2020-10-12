package part3.actions;

import java.util.Objects;

public class ShineAction extends Action {
    private ShineLevel shineLevel;

    public ShineAction(ShineLevel shineLevel) {
        this.shineLevel = shineLevel;
    }

    public ShineLevel getShineLevel() {
        return shineLevel;
    }

    @Override
    public String getDescription() {
        return "Блестеть";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), shineLevel);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ShineAction))
            return false;
        return ((ShineAction)obj).getShineLevel() == getShineLevel();
    }
}
