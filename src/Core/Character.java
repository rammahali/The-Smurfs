package Core;

import UI.GameBoardPanel;

import java.awt.*;
import java.util.Arrays;
import java.util.PriorityQueue;

import java.util.ArrayList;

public abstract class Character {
    private int id;
    private String name;
    private String type;
    private int steps;
    private Location location;
    private ArrayList<Tile> shortestPath;

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

    public void setShortestPath(GameBoardPanel boardPanel, Location destination) {
        // Retrieve start and end tiles
        Tile start = boardPanel.getTile(this.location);
        Tile end = boardPanel.getTile(destination);

        Tile[][] board = boardPanel.getBoard();



        // Minimum heap to store node with shortest distance
        PriorityQueue<Tile> unvisited = new PriorityQueue<>();
        start.setDistance(0);
        unvisited.add(start);
        // Add unvisited tiles to heap
        // O(n log n)
        for (Tile[] row : board) {
            for (Tile tile: row) {
                if (!tile.equals(start) && !tile.isWall()) {
                    tile.setDistance(-1);
                    tile.setPrevious(null);
                    unvisited.add(tile);
                }
            }
        }

        Tile closestTile = null;
        Tile tempTile = new Tile();
        ArrayList<Tile> neighborTiles;

        // Calculate shortest path
        while (!unvisited.isEmpty()) {
            // defines tile with shortest distance and removes from heap
            closestTile = unvisited.poll();
            neighborTiles = boardPanel.getNeighbours(closestTile);
            if (closestTile.equals(end)) {
                break;
            }
            for (Tile neighborTile: neighborTiles) {
                tempTile.setDistance(closestTile.getDistance() + 1);
                if (tempTile.compareTo(neighborTile) < 0) {
                    neighborTile.setDistance(tempTile.getDistance());
                    neighborTile.setPrevious(closestTile);
                    // refresh minimum heap
                    unvisited.remove(neighborTile);
                    unvisited.add(neighborTile);
                }
            }
        }

        ArrayList<Tile> shortestPath = new ArrayList<>();

        Tile previousTile = closestTile;

        while (previousTile != null) {
            shortestPath.add(previousTile);
            previousTile.setBackground(Color.CYAN);
            previousTile = previousTile.getPrevious();
            if (previousTile.equals(start)) {
                break;
            }
        }
        this.shortestPath = shortestPath;
    }

    public ArrayList<Tile> getShortestPath() {
        return shortestPath;
    }
}


