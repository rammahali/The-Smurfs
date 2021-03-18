 public abstract class Enemy extends Character{
     public Enemy() {}
 }

 class Gargamel extends Enemy{
    public Gargamel(){
        this.setName("Gargamel");
        this.setType("Enemy");
        this.setSteps(1);
    }
 }

 class Azman extends Enemy{
    public Azman(){
        this.setName("Azman");
        this.setType("Enemy");
        this.setSteps(2);
    }
 }