package Tests;

import UI.*;
import Core.*;

public class Tests {


    public Tests() {
    }

    public void testAll() {
        testHeap();
        System.out.println(testTileComparator());
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
            gargamel.getShortestPath(boardPanel, lazySmurf.getLocation());
        }
        catch (Exception ignored) {
        }
    }
    public boolean testTileComparator() {
        Tile tile1 = new Tile();
        tile1.setDistance(5);
        Tile tile2 = new Tile(); // distance == -1
        Tile tile3 = new Tile(); // distance == -1

        boolean equality;
        equality = tile2.equals(tile3);

        boolean biggerThan = tile1.compareTo(tile2) < 0;
        biggerThan &= tile2.compareTo(tile1) > 0;

        return equality && biggerThan;
    }
}
