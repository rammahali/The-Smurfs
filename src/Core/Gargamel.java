package Core;

public class Gargamel extends Enemy{
    public Gargamel(){
        super();
    }
    public Gargamel(Tile door){
        super("Gargamel", 2, 15, door);
    }
}
