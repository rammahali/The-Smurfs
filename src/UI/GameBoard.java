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


