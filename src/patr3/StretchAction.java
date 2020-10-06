package patr3;

public class StretchAction implements Action {
    @Override
    public String getDescription() {
        return "простиралась поверхность";
    }

    @Override
    public void setLightLevel(UniverseObject obj, Person pers) {

    }

    @Override
    public String getLightLevel(UniverseObject obj) {
        return null;
    }
}
