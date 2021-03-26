import Tests.*;
public class Main {
    public static void main(String[] args)  {
        Tests tests = new Tests();
        try {
            tests.testAll();
        }
        catch (Exception ignored) {

        }
    }
}

