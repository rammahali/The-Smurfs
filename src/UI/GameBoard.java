package UI;

import Core.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameBoard extends JFrame {
    public GameBoard(String playerCharacter) throws FileNotFoundException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.add(new GameBoardPanel(playerCharacter));
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}


class GameBoardPanel extends JPanel {
    private Tile[][] tile = new Tile[11][13];
    private LazySmurf lazySmurf = new LazySmurf();
    private SmartSmurf smartSmurf = new SmartSmurf();
    private Location Location;

    public GameBoardPanel(String playerCharacter) throws FileNotFoundException {
        initialize(playerCharacter);
    }



    private void  initialize(String playerCharacter) throws FileNotFoundException {
        populateBoard();
        instantiate(playerCharacter,parseMap("src/Core/harita.txt"));
    }



    private void instantiate(String playerCharacter,ArrayList<String> enemyData){

        if(playerCharacter.equals("Lazy Smurf")){
           instantiateLazySmurf();
        }

        if(playerCharacter.equals("Smart Smurf")){
         instantiateLazySmurf();
        }

        //TODO: instantiate enemies
    }

    private void instantiateLazySmurf(){
     //TODO: implement lazy Smurf instantiation
    }

    private void instantiateSmartSmurf(){
        //TODO: implement smart Smurf instantiation
    }

    private void populateBoard() {
        this.setLayout(new GridLayout(11, 13, 0, 0));
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                tile[i][j] = new Tile();
                tile[i][j].setEnabled(false);
                this.add(tile[i][j]);
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
                String doorToken[] = currentWord.split("api:");
                String door = doorToken[1];
                enemyData.add(door);
            }

            // if the current line doesn't contain "Karakter", then it should be "1" or "0" , 0 indicates for wall

            if (currentWord.equals("0")) {
                tile[i][j].setBackground(Color.gray);
                tile[i][j].setIsWall(true);
                if (j < 13) {
                    j++;
                }

                if (j == 13) {
                    j = 0;
                    i++;
                }
            }
            if (currentWord.equals("1")) {
                tile[i][j].setBackground(Color.white);
                tile[i][j].setIsWall(false);
                if (j < 13) {
                    j++;
                }

                if (j == 13) {
                    j = 0;
                    i++;
                }
            }

        }

        tile[0][3].setText("A");
        tile[0][3].setBackground(Color.orange);
        tile[0][10].setText("B");
        tile[0][10].setBackground(Color.orange);
        tile[5][0].setText("C");
        tile[5][0].setBackground(Color.orange);
        tile[10][3].setText("D");
        tile[10][3].setBackground(Color.orange);

        //testing parsing output :
        System.out.print(enemyData);
        return enemyData;
    }
}
