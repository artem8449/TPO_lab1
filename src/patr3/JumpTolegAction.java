package patr3;

public class JumpTolegAction implements Action {
    @Override
    public String getDescription() {
        return "вскочил на ноги";
    }

    @Override
    public void setLightLevel(Universe_object obj, Person pers) {

        pers.standUp = 1;

    }

    @Override
    public String getLightLevel(Universe_object obj) {
        return null;
    }
}
