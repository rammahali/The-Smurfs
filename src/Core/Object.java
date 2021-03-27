package Core;

public abstract class Object {
    private String type;
    private int points;

    public Object() {}

    public Object(String type, int points) {
        setType(type);
        setPoints(points);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}


