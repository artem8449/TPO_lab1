package patr3;

public class JumpTolegAction implements Action {
    @Override
    public String getDescription() {
        return "вскочил на ноги";
    }

    @Override
    public void setLightLevel(UniverseObject obj, Person pers) {

        pers.standUp = 1;

    }

    @Override
    public String getLightLevel(UniverseObject obj) {
        return null;
    }
}
