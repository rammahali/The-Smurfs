package Core;

import javax.swing.*;
import java.util.ArrayList;

public class Tile extends JButton implements Comparable<Tile> {
    private boolean hasGold;
    private boolean hasMushroom;
    private boolean isWall;
    private int distance = -1; // ~= infinity
    private Tile previous;
    private Location tileLocation;
    private ArrayList<Character> paths = new ArrayList<>(); // Stores characters with path over this tile

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

    public Tile getPrevious() {
        return previous;
    }

    public void setPrevious(Tile previous) {
        this.previous = previous;
    }

    public Location getTileLocation() {
        return tileLocation;
    }

    public void setTileLocation(Location location) {
        this.tileLocation = location;
    }

    public ArrayList<Character> getPaths() {
        return paths;
    }

    public void setPaths(ArrayList<Character> paths) {
        this.paths = paths;
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
