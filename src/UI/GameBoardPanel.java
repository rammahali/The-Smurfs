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

public class GameBoardPanel extends JPanel implements ActionListener {
    private Tile[][] board = new Tile[11][13];
    private JLabel pointsLabel = new JLabel();
    private int points = 0;
    private ArrayList<Tile> objectTiles = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Timer objectsTimer;
    private Player currentPlayer;

    public GameBoardPanel(Player playerCharacter) throws FileNotFoundException {
        //TODO: Fix smart smurf wall bug
        // Fix smart smurf going over objects bug
        // Fix wall boundaries out of limit bug

        initialize(playerCharacter);
    }


    private void initialize(Player playerCharacter) throws FileNotFoundException {
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        populateBoard();
        instantiate(playerCharacter, parseMap("src/Core/harita.txt"));
        instantiateRandomObjects();
        startTimer();
    }


    private void instantiate(Player playerCharacter, ArrayList<String> enemyData) {

        // instantiate player
         instantiatePlayerCharacter(playerCharacter);

        // instantiate enemies
        for (int i = 0; i < enemyData.size() - 1; i++)

            instantiateEnemyAtDoor(enemyData.get(i), enemyData.get(i + 1));
    }

    private void instantiatePlayerCharacter(Player playerCharacter) {
        currentPlayer= playerCharacter;
        currentPlayer.setLocation(new Location(5,6));
        board[5][6].setIcon(getIcon(currentPlayer.getName()));
        board[5][6].setEnabled(true);

    }


    private void instantiateEnemyAtDoor(String enemy, String door) {
        switch (door) {
            case "A":
                board[0][3].setText("");
                board[0][3].setEnabled(true);
                board[0][3].setBackground(Color.white);
                board[0][3].setIcon(getIcon(enemy));
                if(enemy.equals("Gargamel")){
                    Gargamel gargamel = new Gargamel();
                    gargamel.setLocation(new Location(0,3));
                    enemies.add(gargamel);
                }
                else{
                    Azman azman = new Azman();
                    azman.setLocation(new Location(0,3));
                    enemies.add(azman);
                }

                break;
            case "B":
                board[0][10].setText("");
                board[0][10].setEnabled(true);
                board[0][10].setBackground(Color.white);
                board[0][10].setIcon(getIcon(enemy));
                if(enemy.equals("Gargamel")){
                    Gargamel gargamel = new Gargamel();
                    gargamel.setLocation(new Location(0,10));
                    enemies.add(gargamel);
                }
                else{
                    Azman azman = new Azman();
                    azman.setLocation(new Location(0,10));
                    enemies.add(azman);
                }
                break;
            case "C":
                board[5][0].setText("");
                board[5][0].setEnabled(true);
                board[5][0].setBackground(Color.white);
                board[5][0].setIcon(getIcon(enemy));

                if(enemy.equals("Gargamel")){
                    Gargamel gargamel = new Gargamel();
                    gargamel.setLocation(new Location(5,0));
                    enemies.add(gargamel);
                }
                else{
                    Azman azman = new Azman();
                    azman.setLocation(new Location(5,0));
                    enemies.add(azman);
                }
                break;
            case "D":
                board[10][3].setText("");
                board[10][3].setEnabled(true);
                board[10][3].setBackground(Color.white);
                board[10][3].setIcon(getIcon(enemy));

                if(enemy.equals("Gargamel")){
                    Gargamel gargamel = new Gargamel();
                    gargamel.setLocation(new Location(10,3));
                    enemies.add(gargamel);
                }
                else{
                    Azman azman = new Azman();
                    azman.setLocation(new Location(10,3));
                    enemies.add(azman);
                }
                break;
        }


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

            // if the current line doesn't contain "Karakter", then it should be "1" or "0" , 0 indicates for wall.

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
        board[0][3].setBackground(Color.DARK_GRAY);
        board[0][3].setIsWall(true);
        board[0][10].setText("B");
        board[0][10].setBackground(Color.DARK_GRAY);
        board[0][10].setIsWall(true);
        board[5][0].setText("C");
        board[5][0].setBackground(Color.DARK_GRAY);
        board[5][0].setIsWall(true);
        board[10][3].setText("D");
        board[10][3].setBackground(Color.DARK_GRAY);
        board[10][3].setIsWall(true);
        //testing parsing output :
        System.out.print(enemyData);
        return enemyData;
    }

    private ImageIcon getIcon(String iconName){

        return new ImageIcon(new ImageIcon("src/Images/"+iconName+".png").getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        hideObjects();
        int x =  currentPlayer.getLocation().getX();
        int y = currentPlayer.getLocation().getY();
        board[x][y].setIcon(getIcon(currentPlayer.getName()));
        board[x][y].setEnabled(true);
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
        Tile playerTile = board[5][6];
        while (drawnGold < goldCount) {
            x = random.nextInt(11);
            y = random.nextInt(13);

            if (!board[x][y].isWall() && !objectTiles.contains(board[x][y]) && board[x][y] != playerTile) {
                board[x][y].setHasGold(true);
                board[x][y].setIcon(getIcon("gold"));
                board[x][y].setEnabled(true);
                objectTiles.add(board[x][y]);
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
        Tile playerTile = board[5][6];
        while (drawnMushroom < MushroomCount) {
            x = random.nextInt(11);
            y = random.nextInt(13);

            if (!board[x][y].isWall() && !objectTiles.contains(board[x][y]) && board[x][y] != playerTile) {
                board[x][y].setHasMushroom(true);
                board[x][y].setIcon(getIcon("mushroom"));
                board[x][y].setEnabled(true);
                objectTiles.add(board[x][y]);
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
        for (Tile objectTile : objectTiles) {
            if (objectTile.HasGold()) {
                objectTile.setHasGold(false);
                objectTile.setIcon(null);
            } else {
                objectTile.setHasMushroom(false);
                objectTile.setIcon(null);
            }
        }
    }

    private void movePlayerUp(Player playerCharacter) {
        int steps = playerCharacter.getSteps();
        int x = currentPlayer.getLocation().getX();
        int y = currentPlayer.getLocation().getY();
        Tile nextTile = board[x - steps][y];
        Tile currentTile = board[x][y];
        if (!nextTile.isWall()) {
            currentTile.setIcon(null);
            currentTile.setEnabled(false);
            nextTile.setIcon(getIcon(currentPlayer.getName()));
            nextTile.setEnabled(true);
            currentPlayer.getLocation().setX(x-steps);
        }
    }

    private void movePlayerDown(Player playerCharacter) {
        int steps = playerCharacter.getSteps();
        int x = currentPlayer.getLocation().getX();
        int y = currentPlayer.getLocation().getY();
        Tile nextTile = board[x + steps][y];
        Tile currentTile = board[x][y];
        if (!nextTile.isWall()) {
            currentTile.setIcon(null);
            currentTile.setEnabled(false);
            nextTile.setIcon(getIcon(currentPlayer.getName()));
            nextTile.setEnabled(true);
            currentPlayer.getLocation().setX(x+steps);
        }
    }

    private void movePlayerRight(Player playerCharacter) {
        int steps = playerCharacter.getSteps();
        int x = currentPlayer.getLocation().getX();
        int y = currentPlayer.getLocation().getY();
        Tile nextTile = board[x][y + steps];
        Tile currentTile = board[x][y];

        if (!nextTile.isWall()) {
            currentTile.setIcon(null);
            currentTile.setEnabled(false);
            nextTile.setIcon(getIcon(currentPlayer.getName()));
            nextTile.setEnabled(true);
            currentPlayer.getLocation().setY(y+steps);
        }
    }

    private void movePlayerLeft(Player playerCharacter) {
        int steps = playerCharacter.getSteps();
        int x = currentPlayer.getLocation().getX();
        int y = currentPlayer.getLocation().getY();
        Tile nextTile = board[x][y - steps];
        Tile currentTile = board[x][y];
        if (!nextTile.isWall()) {
            currentTile.setIcon(null);
            currentTile.setEnabled(false);
            nextTile.setIcon(getIcon(currentPlayer.getName()));
            nextTile.setEnabled(true);
            currentPlayer.getLocation().setY(y-steps);
        }
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


    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                   movePlayerLeft(currentPlayer);
                    break;
                case KeyEvent.VK_RIGHT:
                    movePlayerRight(currentPlayer);
                    break;

                case KeyEvent.VK_UP:
                    movePlayerUp(currentPlayer);

                    break;
                case KeyEvent.VK_DOWN:
                    movePlayerDown(currentPlayer);
                    break;

            }
        }

    }

}
