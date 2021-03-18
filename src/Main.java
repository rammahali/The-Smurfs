public class Main {
    public static void main(String[] args) {

        new Main().testClasses();
    }
     protected void testClasses(){
        LazySmurf lazySmurf = new LazySmurf();
        SmartSmurf smartSmurf = new SmartSmurf();
        Gargamel gargamel = new Gargamel();
        Azman azman = new Azman();
        Gold gold = new Gold();
        Mushroom mushroom = new Mushroom();
        System.out.println(lazySmurf.getName());
        System.out.println(smartSmurf.getName());
        System.out.println(gargamel.getName());
        System.out.println(azman.getName());
        System.out.println(mushroom.getType());
    }
}

