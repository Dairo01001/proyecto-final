package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File doc =  new File("/home/dairo/NetBeansProjects/ProyectoFinal/src/data/preguntas.txt");

        Scanner sc = new Scanner(doc);
        
        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        
        sc.close();
    }
}
