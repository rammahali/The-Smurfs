package Core;

public class Gargamel extends Enemy{
    public Gargamel(){
        super();
        this.setName("Gargamel");
        this.setSteps(2);
        this.setHitPoints(15);
    }
    public Gargamel(Tile door){
        super("Gargamel", 2, 15, door);
    }
}
