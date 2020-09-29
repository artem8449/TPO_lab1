package patr3;

public interface Action {
    String getDescription();
    void setLightLevel(Universe_object obj, Person pers);
    String getLightLevel(Universe_object obj);

}