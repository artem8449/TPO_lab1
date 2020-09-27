package patr3;

public class WatchAroundActon implements Action{

    @Override
    public String getDescription() {
        return "начал осматриваться";
    }

    @Override
    public void setLightlevel(Universe_object obj, Person pers) {
        pers.seelightlevel = obj.lightlevel;

    }

    @Override
    public String getLightLevel(Universe_object obj) {
        return null;
    }
}
