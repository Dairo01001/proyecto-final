package util;

import game.Pregunta;
import game.TipoPregunta;
import java.io.File;
import java.util.Scanner;

public class Read {

    private static final String URI = Constantes.DIR + Constantes.SEPARATOR + "src" + Constantes.SEPARATOR + "data" + Constantes.SEPARATOR + "preguntas.txt";

    public static Pregunta[] getPreguntas(int num) {
        Pregunta preguntas[] = new Pregunta[num];
        int count = 0;

        try {
            File doc = new File(URI);
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
                            
                            TipoPregunta  tipo = tipoPregunta == 1 ? TipoPregunta.SELECION_MULTIPLE : TipoPregunta.FALSO_VERDADERO;
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
}
