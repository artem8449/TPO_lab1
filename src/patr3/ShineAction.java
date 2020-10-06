package patr3;

public class ShineAction implements Action {

    @Override
    public String getDescription() {
        return "Она блестела,";
    }

    @Override
    public void setLightLevel(UniverseObject obj, Person pers) {

        SerfaceType type = SerfaceType.GOLD;
        double max = 100;
        if (obj.type == type){
            obj.lightLevel = Double.POSITIVE_INFINITY;
        }
        else{
            obj.lightLevel = Math.random() * max;
        }
    }

    @Override
    public String getLightLevel(UniverseObject obj) {
        if (obj.lightLevel < Double.POSITIVE_INFINITY) {
            String res = "с яркостью" + Double.toString(obj.lightLevel);
        }
        else  return "как... впрочем, этому невозможно подобрать сравнение";
        return "ярко";
    }
}
