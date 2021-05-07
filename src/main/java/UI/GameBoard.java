package UI;
import Core.Player;

import javax.swing.*;
import java.io.FileNotFoundException;


public class GameBoard extends JFrame {
    public GameBoard(Player playerCharacter) throws FileNotFoundException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.add(new GameBoardPanel(playerCharacter));
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}


