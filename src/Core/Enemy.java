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
        this.setType("Enemy");
    }

    public Enemy(String name, int steps, int hitPoints, Tile door) {
        this.setType("Enemy");
        setName(name);
        setSteps(steps);
        setHitPoints(hitPoints);
        setDoor(door);
    }
 }


