package patr3;

public class WatchAroundActon implements Action{

    @Override
    public String getDescription() {
        return "начал осматриваться";
    }

    @Override
    public void setLightLevel(UniverseObject obj, Person pers) {
        if(pers.standUp == 1)
            pers.seeLightLevel = obj.lightLevel;

    }

    @Override
    public String getLightLevel(UniverseObject obj) {
        return null;
    }
}
