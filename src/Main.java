import UI.PlayerSelection;
import UI.UI;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Don't forget to change the project working directory ../The-Smurfs
        new PlayerSelection().setVisible(true);
        new UI("Lazy Smurf");
    }
}

