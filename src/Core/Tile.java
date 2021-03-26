package Core;

import javax.swing.*;

public class Tile extends JButton implements Comparable<Tile> {
    private boolean hasGold;
    private boolean hasMushroom;
    private boolean isWall;
    private int distance = -1; // ~= infinity

    public Tile() {
    }

    public boolean HasGold() {
        return hasGold;
    }

    public void setHasGold(boolean hasGold) {
        this.hasGold = hasGold;
    }

    public boolean HasMushroom() {
        return hasMushroom;
    }

    public void setHasMushroom(boolean hasMushroom) {
        this.hasMushroom = hasMushroom;
    }

    public boolean isWall() {
        return isWall;
    }

    public void setIsWall(boolean wall) {
        isWall = wall;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


    @Override
    public int compareTo(Tile tile) {
        if (this.distance == -1 && tile.distance > -1) {
            return 1;
        }
        if (this.distance > -1 && tile.distance == -1) {
            return -1;
        }
        return Integer.compare(this.distance, tile.distance);
    }
}
