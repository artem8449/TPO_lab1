package patr3;

public interface Action {
    String getDescription();
    void setLightLevel(UniverseObject obj, Person pers);
    String getLightLevel(UniverseObject obj);

}