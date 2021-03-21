package UI;

import Core.LazySmurf;
import Core.Location;
import Core.SmartSmurf;
import Core.Tile;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameBoardPanel extends JPanel {
    private Tile[][] board = new Tile[11][13];
    private LazySmurf lazySmurf = new LazySmurf();
    private SmartSmurf smartSmurf = new SmartSmurf();
    private Core.Location Location;

    public GameBoardPanel(String playerCharacter) throws FileNotFoundException {
        initialize(playerCharacter);
    }


    private void initialize(String playerCharacter) throws FileNotFoundException {
        populateBoard();
        instantiate(playerCharacter, parseMap("src/Core/harita.txt"));
    }


    private void instantiate(String playerCharacter, ArrayList<String> enemyData) {

        if (playerCharacter.equals("Lazy Smurf")) {
            instantiateLazySmurf();
        }

        if (playerCharacter.equals("Smart Smurf")) {
            instantiateLazySmurf();
        }

        //TODO: instantiate enemies
    }

    private void instantiateLazySmurf() {
        //TODO: implement lazy Smurf instantiation
    }

    private void instantiateSmartSmurf() {
        //TODO: implement smart Smurf instantiation
    }

    private void populateBoard() {
        this.setLayout(new GridLayout(11, 13, 0, 0));
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                board[i][j] = new Tile();
                board[i][j].setEnabled(false);
                this.add(board[i][j]);
            }
        }
    }


    private ArrayList<String> parseMap(String mapPath) throws FileNotFoundException {

        ArrayList<String> enemyData = new ArrayList<>();
        File map = new File(mapPath);
        Scanner mapScanner = new Scanner(map);
        int i = 0;
        int j = 0;
        while (mapScanner.hasNext()) {
            //Karakter:Gargamel,Kapi:A
            String currentWord = mapScanner.next();
            if (currentWord.contains("Karakter") || currentWord.contains("karakter")) {
                // get the enemy's character :
                if (currentWord.contains("Gargamel") || currentWord.contains("gargamel"))
                    enemyData.add("Gargamel");
                else
                    enemyData.add("Azman");

                // get the enemy's door :using "api" to ignore Kapi capitalaization
                String[] doorToken = currentWord.split("api:");
                String door = doorToken[1];
                enemyData.add(door);
            }

            // if the current line doesn't contain "Karakter", then it should be "1" or "0" , 0 indicates for wall

            if (currentWord.equals("0")) {
                board[i][j].setBackground(Color.gray);
                board[i][j].setIsWall(true);
                if (j < 13) {
                    j++;
                }

                if (j == 13) {
                    j = 0;
                    i++;
                }
            }
            if (currentWord.equals("1")) {
                board[i][j].setBackground(Color.white);
                board[i][j].setIsWall(false);
                if (j < 13) {
                    j++;
                }

                if (j == 13) {
                    j = 0;
                    i++;
                }
            }

        }

        board[0][3].setText("A");
        board[0][3].setBackground(Color.orange);
        board[0][10].setText("B");
        board[0][10].setBackground(Color.orange);
        board[5][0].setText("C");
        board[5][0].setBackground(Color.orange);
        board[10][3].setText("D");
        board[10][3].setBackground(Color.orange);

        //testing parsing output :
        System.out.print(enemyData);
        return enemyData;
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void setBoard(Tile[][] board) {
        this.board = board;
    }

    public Tile getTile(Location location) {
        return board[location.getY()][location.getX()];
    }
}
