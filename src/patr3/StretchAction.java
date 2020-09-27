package patr3;

public class StretchAction implements Action {
    @Override
    public String getDescription() {
        return "простиралась поверхность";
    }

    @Override
    public void setLightlevel(Universe_object obj, Person pers) {

    }

    @Override
    public String getLightLevel(Universe_object obj) {
        return null;
    }
}
