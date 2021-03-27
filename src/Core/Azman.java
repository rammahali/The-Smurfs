package Core;

public class Azman extends Enemy{
    public Azman(){
        super();
        this.setName("Azman");
        this.setSteps(1);
        this.setHitPoints(5);
    }
    public Azman(Tile door){
        super("Azman", 1, 15, door);
    }
}
