package UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    public UI() throws FileNotFoundException {
        //Testing parseMap
        parseMap("src/harita.txt");
    }

    private ArrayList<String> parseMap(String mapPath) throws FileNotFoundException {
        ArrayList<String> enemyData= new ArrayList<>();
        File map = new File(mapPath);
        Scanner mapScanner = new Scanner(map);
        while (mapScanner.hasNextLine()){
            //Karakter:Gargamel,Kapi:A
            String currentLine = mapScanner.nextLine();
            if(currentLine.contains("Karakter") || currentLine.contains("karakter")){
                // get the enemy's character :
                if(currentLine.contains("Gargamel")|| currentLine.contains("gargamel"))
                    enemyData.add("Gargamel");
                else
                    enemyData.add("Azman");

                // get the enemy's door
                // using "api" to ignore Kapi capitalaization
                String doorToken[] = currentLine.split("api:");
                String door = doorToken[1];
                enemyData.add(door);
            }

        }

        //testing parsing output :
        System.out.print(enemyData);
        return  enemyData;
    }
}
