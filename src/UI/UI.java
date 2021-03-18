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
                String doorToken[] =currentLine.split(",Kapi:");
                String characterToken[] = doorToken[0].split(":");
                String enemyCharacter=  characterToken[1];
                String enemyDoor = doorToken[1];
                enemyData.add(enemyCharacter);
                enemyData.add(enemyDoor);
            }

        }

        //testing parsing output :
        System.out.print(enemyData);
        return  enemyData;
    }
}
