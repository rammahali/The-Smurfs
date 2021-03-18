 public abstract class Player extends Character{
  Player(){}
}


class LazySmurf extends Player {
    public LazySmurf() {
        this.setName("Lazy Smurf");
        this.setType("Player");
        this.setSteps(1);
    }
}

class SmartSmurf extends Player{
    public SmartSmurf(){
        this.setName("Smart Smurf");
        this.setType("Player");
        this.setSteps(2);
    }
}