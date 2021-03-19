package Core;

import javax.swing.*;

public class Tile extends JButton {
   private boolean hasGold;
   private boolean hasMushroom;
   private boolean isWall;

    public Tile() {}

    public boolean HasGold() {
        return hasGold;
    }

    public void setHasGold(boolean hasGold) {
        this.hasGold = hasGold;
    }

    public boolean HasMushroom() {
        return hasMushroom;
    }

    public void setHasMushroom(boolean hasMushroom) {
        this.hasMushroom = hasMushroom;
    }

    public boolean isWall() {
        return isWall;
    }

    public void setWall(boolean wall) {
        isWall = wall;
    }
}
