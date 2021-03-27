package Tests;

import UI.*;
import Core.*;

import java.util.ArrayList;

public class Tests {


    public Tests() {
    }

    public void testAll() {
        testHeap();
        System.out.println(testTileComparator());
        System.out.println(testTileNeighbors());
    }


    public void testHeap() {
        // func to check if minimum heap stores tiles in correct order
        Gargamel gargamel = new Gargamel();
        gargamel.setLocation(new Location(3, 5));
        LazySmurf lazySmurf = new LazySmurf();
        try {
            GameBoardPanel boardPanel = new GameBoardPanel(lazySmurf);
            boardPanel.getBoard()[0][5].setDistance(4);
            boardPanel.getBoard()[7][1].setDistance(19);
        }
        catch (Exception ignored) {
        }
    }

    public boolean testTileNeighbors() {
        Gargamel gargamel = new Gargamel();
        gargamel.setLocation(new Location(3, 5));
        LazySmurf lazySmurf = new LazySmurf();
        try {
            GameBoardPanel boardPanel = new GameBoardPanel(lazySmurf);
            boardPanel.getTile(new Location(0, 5)).setDistance(4);
            boardPanel.getTile(new Location(7, 1)).setDistance(19);
            ArrayList<Tile> neighbours = boardPanel.getNeighbours(boardPanel.getTile(new Location(1, 3)));
            return neighbours.size() == 3;
        }
        catch (Exception ignored) {
            return false;
        }
    }

    public boolean testTileComparator() {
        Tile tile1 = new Tile();
        tile1.setDistance(5);
        Tile tile2 = new Tile(); // distance == -1
        Tile tile3 = new Tile(); // distance == -1

        boolean equality;
        equality = tile2.compareTo(tile3) == 0;

        boolean biggerThan = tile1.compareTo(tile2) < 0;
        biggerThan &= tile2.compareTo(tile1) > 0;

        return equality && biggerThan;
    }
}
