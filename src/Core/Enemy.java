package Core;

public abstract class Enemy extends Character {
    int hitPoints;
    Tile door;

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Tile getDoor() {
        return door;
    }

    public void setDoor(Tile door) {
        this.door = door;
    }

    public Enemy() {
        super();
    }

    public Enemy(String name, int steps, int hitPoints, Tile door) {
        super(name, "Enemy", steps);
        setHitPoints(hitPoints);
        setDoor(door);
    }
 }


