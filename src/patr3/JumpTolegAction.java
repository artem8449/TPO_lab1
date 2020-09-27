package patr3;

public class JumpTolegAction implements Action {
    @Override
    public String getDescription() {
        return "вскочил на ноги";
    }

    @Override
    public void setLightlevel(Universe_object obj, Person pers) {

    }

    @Override
    public String getLightLevel(Universe_object obj) {
        return null;
    }
}
