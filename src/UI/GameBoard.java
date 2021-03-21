package UI;

import Core.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
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


class GameBoardPanel extends JPanel implements ActionListener {
    private Tile[][] tile = new Tile[11][13];
    private JLabel pointsLabel = new JLabel();
    private int points = 0;
    private LazySmurf lazySmurf = new LazySmurf();
    private SmartSmurf smartSmurf = new SmartSmurf();
    private String currentPlayer;
    private ImageIcon lazySmurfICon = new ImageIcon(new ImageIcon("src/Images/lazySmurf.png").getImage());
    private ImageIcon smartSmurfICon = new ImageIcon(new ImageIcon("src/Images/smartSmurf.png").getImage());
    private ImageIcon goldIcon = new ImageIcon(new ImageIcon("src/Images/gold.png").getImage());
    private ImageIcon mushroomIcon = new ImageIcon(new ImageIcon("src/Images/mushroom.png").getImage());
    private int playerX = 5, playerY = 6;
    private ArrayList<Tile> objectTiles = new ArrayList<>();
    private Timer objectsTimer;


    public GameBoardPanel(String playerCharacter) throws FileNotFoundException {
        //TODO: Fix smart smurf wall bug
        // Fix smart smurf going over objects bug
        // Fix wall boundaries out of limit bug

        initialize(playerCharacter);
    }


    private void initialize(String playerCharacter) throws FileNotFoundException {
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        populateBoard();
        instantiate(playerCharacter, parseMap("src/Core/harita.txt"));
        instantiateRandomObjects();
        startTimer();
    }


    private void instantiate(String playerCharacter, ArrayList<String> enemyData) {
        // set the current player to the selected character
        currentPlayer = playerCharacter;

        // instantiate players
        if (playerCharacter.equals("Lazy Smurf"))
            instantiateLazySmurf();
        else
            instantiateSmartSmurf();

        // instantiate enemies
        for (int i = 0; i < enemyData.size() - 1; i++)

            instantiateEnemyAtDoor(enemyData.get(i), enemyData.get(i + 1));
    }

    private void instantiateLazySmurf() {
        tile[5][6].setIcon(lazySmurfICon);
        tile[5][6].setEnabled(true);
    }

    private void instantiateSmartSmurf() {
        tile[5][6].setIcon(smartSmurfICon);
        tile[5][6].setEnabled(true);
    }

    private void instantiateEnemyAtDoor(String enemy, String door) {
        switch (door) {
            case "A":
                tile[0][3].setText("");
                tile[0][3].setEnabled(true);
                tile[0][3].setBackground(Color.white);
                tile[0][3].setIcon(new ImageIcon(new ImageIcon("src/Images/" + enemy + ".png").getImage()));
                break;
            case "B":
                tile[0][10].setText("");
                tile[0][10].setEnabled(true);
                tile[0][10].setBackground(Color.white);
                tile[0][10].setIcon(new ImageIcon(new ImageIcon("src/Images/" + enemy + ".png").getImage()));
                break;
            case "C":
                tile[5][0].setText("");
                tile[5][0].setEnabled(true);
                tile[5][0].setBackground(Color.white);
                tile[5][0].setIcon(new ImageIcon(new ImageIcon("src/Images/" + enemy + ".png").getImage()));
                break;
            case "D":
                tile[10][3].setText("");
                tile[10][3].setEnabled(true);
                tile[10][3].setBackground(Color.white);
                tile[10][3].setIcon(new ImageIcon(new ImageIcon("src/Images/" + enemy + ".png").getImage()));
                break;
        }
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
                String[] doorToken = currentWord.split("api:");
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
        tile[0][3].setBackground(Color.DARK_GRAY);
        tile[0][3].setIsWall(true);
        tile[0][10].setText("B");
        tile[0][10].setBackground(Color.DARK_GRAY);
        tile[0][10].setIsWall(true);
        tile[5][0].setText("C");
        tile[5][0].setBackground(Color.DARK_GRAY);
        tile[5][0].setIsWall(true);
        tile[10][3].setText("D");
        tile[10][3].setBackground(Color.DARK_GRAY);
        tile[10][3].setIsWall(true);
        //testing parsing output :
        System.out.print(enemyData);
        return enemyData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        hideObjects();
        if(currentPlayer.equals("Lazy Smurf"))
            tile[playerX][playerY].setIcon(lazySmurfICon);
        else
            tile[playerX][playerY].setIcon(smartSmurfICon);

    }

    private void instantiateRandomObjects() {
        showRandomGold();
        showRandomMushroom();
    }

    private void showRandomGold() {
        Random random = new Random();
        int x;
        int y;
        int goldCount = 5;
        int drawnGold = 0;
        Tile playerTile = tile[5][6];
        while (drawnGold < goldCount) {
            x = random.nextInt(11);
            y = random.nextInt(13);

            if (!tile[x][y].isWall() && !objectTiles.contains(tile[x][y]) && tile[x][y] != playerTile) {
                tile[x][y].setHasGold(true);
                tile[x][y].setIcon(goldIcon);
                tile[x][y].setEnabled(true);
                objectTiles.add(tile[x][y]);
                drawnGold++;
            }
        }
    }

    private void showRandomMushroom() {
        Random random = new Random();
        int x;
        int y;
        int MushroomCount = random.nextInt(20);
        int drawnMushroom = 0;
        Tile playerTile = tile[5][6];
        while (drawnMushroom < MushroomCount) {
            x = random.nextInt(11);
            y = random.nextInt(13);

            if (!tile[x][y].isWall() && !objectTiles.contains(tile[x][y]) && tile[x][y] != playerTile) {
                tile[x][y].setHasMushroom(true);
                tile[x][y].setIcon(mushroomIcon);
                tile[x][y].setEnabled(true);
                objectTiles.add(tile[x][y]);
                drawnMushroom++;
            }
        }
    }

    private void startTimer() {
        objectsTimer = new Timer(5000, this);
        objectsTimer.setRepeats(false);
        objectsTimer.start();
    }

    private void hideObjects() {
        for (int i = 0; i < objectTiles.size(); i++) {
            if (objectTiles.get(i).HasGold()) {
                objectTiles.get(i).setHasGold(false);
                objectTiles.get(i).setIcon(null);
            } else {
                objectTiles.get(i).setHasMushroom(false);
                objectTiles.get(i).setIcon(null);
            }
        }
    }

    private void movePlayerUp(Player playerCharacter) {
        int steps = playerCharacter.getSteps();
        int x = playerX;
        int y = playerY;
        Tile nextTile = tile[x - steps][y];
        Tile currentTile = tile[x][y];
        if (!nextTile.isWall()) {
            currentTile.setIcon(null);
            currentTile.setEnabled(false);
            nextTile.setIcon(new ImageIcon(new ImageIcon("src/Images/" + playerCharacter.getName() + ".png").getImage()));
            nextTile.setEnabled(true);
            playerX = playerX - steps;
        }
    }

    private void movePlayerDown(Player playerCharacter) {
        int steps = playerCharacter.getSteps();
        int x = playerX;
        int y = playerY;
        Tile nextTile = tile[x + steps][y];
        Tile currentTile = tile[x][y];
        if (!nextTile.isWall()) {
            currentTile.setIcon(null);
            currentTile.setEnabled(false);
            nextTile.setIcon(new ImageIcon(new ImageIcon("src/Images/" + playerCharacter.getName() + ".png").getImage()));
            nextTile.setEnabled(true);
            playerX = playerX + steps;
        }
    }

    private void movePlayerRight(Player playerCharacter) {
        int steps = playerCharacter.getSteps();
        int x = playerX;
        int y = playerY;
        Tile nextTile = tile[x][y + steps];
        Tile currentTile = tile[x][y];

        if (!nextTile.isWall()) {
            currentTile.setIcon(null);
            currentTile.setEnabled(false);
            nextTile.setIcon(new ImageIcon(new ImageIcon("src/Images/" + playerCharacter.getName() + ".png").getImage()));
            nextTile.setEnabled(true);
            playerY = playerY + steps;
        }
    }

    private void movePlayerLeft(Player playerCharacter) {
        int steps = playerCharacter.getSteps();
        int x = playerX;
        int y = playerY;
        Tile nextTile = tile[x][y - steps];
        Tile currentTile = tile[x][y];
        if (!nextTile.isWall()) {
            currentTile.setIcon(null);
            currentTile.setEnabled(false);
            nextTile.setIcon(new ImageIcon(new ImageIcon("src/Images/" + playerCharacter.getName() + ".png").getImage()));
            nextTile.setEnabled(true);
            playerY = playerY - steps;
        }
    }


    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (currentPlayer.equals("Lazy Smurf"))
                        movePlayerLeft(lazySmurf);
                    else
                        movePlayerLeft(smartSmurf);


                    break;
                case KeyEvent.VK_RIGHT:
                    if (currentPlayer.equals("Lazy Smurf"))
                        movePlayerRight(lazySmurf);
                    else
                        movePlayerRight(smartSmurf);
                    break;

                case KeyEvent.VK_UP:
                    if (currentPlayer.equals("Lazy Smurf"))
                        movePlayerUp(lazySmurf);
                    else
                        movePlayerUp(smartSmurf);
                    break;
                case KeyEvent.VK_DOWN:
                    if (currentPlayer.equals("Lazy Smurf"))
                        movePlayerDown(lazySmurf);
                    else
                        movePlayerDown(smartSmurf);
                    break;

            }
        }

    }

}
