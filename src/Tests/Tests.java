package Tests;

import UI.*;
import Core.*;

import java.io.FileNotFoundException;

public class Tests {


    public Tests() {
    }

    public void testHeap() throws FileNotFoundException {
        // func to check if minimum heap stores tiles in correct order
        Gargamel gargamel = new Gargamel();
        gargamel.setLocation(new Location(3, 5));
        LazySmurf lazySmurf = new LazySmurf();
        GameBoardPanel boardPanel = new GameBoardPanel(lazySmurf);
        boardPanel.getBoard()[0][5].setDistance(4);
        boardPanel.getBoard()[7][1].setDistance(19);
        gargamel.getShortestPath(boardPanel, lazySmurf.getLocation());
    }
}
