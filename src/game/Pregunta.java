package game;

public class Pregunta {

    public static final int NUMERO_OPCIONES = 3;

    private final String pregunta;
    private final TipoPregunta tipo;
    private final String respuesta;
    private String[] opciones;

    public Pregunta(String pregunta, TipoPregunta tipo, String respuesta) {
        this.pregunta = pregunta;
        this.tipo = tipo;
        this.respuesta = respuesta;
        this.opciones = new String[NUMERO_OPCIONES];
    }

    public String getPregunta() {
        return pregunta.replaceAll(";", ";\n");
    }

    public TipoPregunta getTipo() {
        return tipo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public boolean respuestaCorrecta(String resp) {
        System.out.println(respuesta + " == " + resp);
        return respuesta.equals(resp);
    }

    @Override
    public String toString() {
        return "Pregunta [" + "pregunta: " + pregunta + ", tipo: " + tipo + ", respuesta: " + respuesta + ']';
    }

}
