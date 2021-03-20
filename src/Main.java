import UI.PlayerSelection;
import UI.GameBoard;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Don't forget to change the project working directory ../The-Smurfs
        new PlayerSelection().setVisible(true);
    }
}

