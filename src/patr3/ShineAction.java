package patr3;

public class ShineAction implements Action {
    @Override
    public String getDescription() {
        return "Она блестела,";
    }

    @Override
    public void setLightlevel(Universe_object obj) {

        SerfaceType type = SerfaceType.GOLD;
        double max = 100;
        if (obj.type == type){
            obj.lightlevel = Double.POSITIVE_INFINITY;
        }
        else{
            obj.lightlevel = Math.random() * max;
        }
    }

    @Override
    public String getLightLevel(Universe_object obj) {
        if (obj.lightlevel < Double.POSITIVE_INFINITY) {
            String res = "с яркостью" + Double.toString(obj.lightlevel);
        }
        else  return "как... впрочем, этому невозможно подобрать сравнение";
        return "ярко";
    }
}
