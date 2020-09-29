package patr3;

public class WatchAroundActon implements Action{

    @Override
    public String getDescription() {
        return "начал осматриваться";
    }

    @Override
    public void setLightLevel(Universe_object obj, Person pers) {
        if(pers.standUp == 1)
            pers.seeLightLevel = obj.lightLevel;

    }

    @Override
    public String getLightLevel(Universe_object obj) {
        return null;
    }
}
