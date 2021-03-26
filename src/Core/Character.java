package Core;

import UI.GameBoardPanel;

import java.util.Arrays;
import java.util.PriorityQueue;

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

    public ArrayList<Tile> getShortestPath(GameBoardPanel boardPanel, Location destination) {
        // Retrieve start and end tiles
        Tile start = boardPanel.getTile(this.location);
        Tile end = boardPanel.getTile(destination);

        Tile[][] board = boardPanel.getBoard();


        start.setDistance(0);

        // Minimum heap to store node with shortest distance
        PriorityQueue<Tile> unvisited = new PriorityQueue<>();

        // Add unvisited tiles to heap
        // O(n log n)
        for (Tile[] row : board) {
            for (Tile tile: row) {
                tile.setDistance(-1);
                unvisited.add(tile);
            }
        }

        Tile closestTile = unvisited.poll();

        // Calculate shortest path
        while (!unvisited.isEmpty()) {
            // defines tile with shortest distance and removes from heap
            closestTile = unvisited.poll();
            ArrayList<Tile> neighborTiles = boardPanel.getNeighbours(closestTile);
            if (closestTile.equals(end)) {
                break;
            }

            for (Tile neighborTile: neighborTiles) {
                int newDistance = closestTile.getDistance() + 1;
                if (newDistance < neighborTile.getDistance()) {
                    neighborTile.setDistance(newDistance);
                    neighborTile.setPrevious(closestTile);
                }
            }
        }

        ArrayList<Tile> shortestPath = new ArrayList<>();

        Tile previousTile = closestTile;

        while (previousTile != null) {
            shortestPath.add(previousTile);
            previousTile = previousTile.getPrevious();
        }
        
        return shortestPath;

    }
}


