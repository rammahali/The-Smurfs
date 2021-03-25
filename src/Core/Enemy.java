package Core;

public abstract class Enemy extends Character {
    int hitPoints;

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Enemy() {}
 }


