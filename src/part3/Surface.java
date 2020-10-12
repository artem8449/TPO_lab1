package part3;

public class Surface extends UniverseObject {
    private SurfaceType type;

    public Surface(SurfaceType type) {
        this.type = type;
    }

    public SurfaceType getType() {
        return type;
    }

    @Override
    public String getName() {
        return "Поверхность из материала: " + getType();
    }
}
