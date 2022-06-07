package util;

import game.Pregunta;
import game.TipoPregunta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Read {

    public static final String URI = Constantes.DIR + Constantes.SEPARATOR + "src" + Constantes.SEPARATOR + "data" + Constantes.SEPARATOR;

    public static Pregunta[] getPreguntas(int num) {
        Pregunta preguntas[] = new Pregunta[num];
        int count = 0;

        try {
            File doc = new File(URI + "preguntas.txt");
            try ( Scanner sc = new Scanner(doc)) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();

                    if (count < num) {

                        if (line.startsWith("->")) {
                            String config[] = line.split(",");

                            int numLines = Integer.parseInt(config[1]);
                            int numLinesEnumciado = Integer.parseInt(config[2]);
                            int tipoPregunta = Integer.parseInt(config[3]);
                            int numOpciones = Integer.parseInt(config[4]);

                            String enumciando = "";

                            for (int i = 0; i < numLinesEnumciado; i++) {
                                enumciando += sc.nextLine();
                            }

                            TipoPregunta tipo = tipoPregunta == 1 ? TipoPregunta.SELECION_MULTIPLE : TipoPregunta.FALSO_VERDADERO;
                            String respuesta = sc.nextLine();

                            String opciones[] = new String[numOpciones];

                            for (int i = 0; i < numOpciones; i++) {
                                opciones[i] = sc.nextLine();
                            }

                            preguntas[count] = new Pregunta(enumciando, tipo, respuesta);
                            preguntas[count++].setOpciones(opciones);
                        }
                    }
                }
            }

        } catch (Exception e) {
        }

        return preguntas;
    }

    public static ArrayList<String[]> getPuntajes() {
        ArrayList<String[]> puntajes = new ArrayList<>();

        try {
            File doc = new File(URI + "puntajes.txt");
            try ( Scanner sc = new Scanner(doc)) {
                while (sc.hasNextLine()) {
                    puntajes.add(sc.nextLine().split(","));
                }
            }
            
            return puntajes;
        } catch (FileNotFoundException e) {
        }
       return puntajes;
    }
    
    public static boolean setPuntaje(String nombre, String grupo, int puntaje)  {
        try {
            FileWriter flWriter = new FileWriter(URI + "puntajes.txt", true);
            try (BufferedWriter bfWriter = new BufferedWriter(flWriter)) {
                bfWriter.write(nombre + "," + grupo + "," + puntaje + "\n");
            }
            
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
