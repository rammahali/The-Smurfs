package Core;

public abstract class Object {
    private String type;
    private int points;

    public Object() {}

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

class Gold extends Object{
    public Gold() {
        this.setType("Gold");
        this.setPoints(5);
    }
}

class Mushroom extends Object{
    public Mushroom() {
        this.setType("Mushroom");
        this.setPoints(20);
    }
}
