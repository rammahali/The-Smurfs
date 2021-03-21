package Core;

import UI.GameBoard;

import java.util.ArrayList;

public abstract class Character {
    private int id;
    private String name;
    private String type;
    private int steps;
    private Location location;

    public Character() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<Tile> getShortestPath(Tile[][] board, Location destination) {
        // Retrieve start and end tiles
        Tile start = board[this.location.getX()][this.location.getY()];
        Tile end = board[destination.getX()][destination.getY()];
        ArrayList<Tile> shortestPath = new ArrayList<>();



        // TODO: Check all adjacent tiles
        //       Update distance value of tiles
        //       Add to shortestPath


        return shortestPath;

    }
}


