package part3;

public class Planet extends UniverseObject {
    private Surface surface;

    public Planet(Surface surface) {
        this.surface = surface;
    }

    public Surface getSurface() {
        return surface;
    }

    @Override
    public String getName() {
        return "Планета";
    }
}
