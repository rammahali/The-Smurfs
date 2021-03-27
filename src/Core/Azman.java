package Core;

public class Azman extends Enemy{
    public Azman(){
        super();
    }
    public Azman(Tile door){
        super("Azman", 1, 15, door);
    }
}
