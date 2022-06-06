package game;

public class Juego {

    private final Nivel nivel;
    private final Pregunta[] preguntas;

    public Juego(Nivel nivel, Pregunta[] preguntas) {
        this.nivel = nivel;
        this.preguntas = preguntas;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public Pregunta[] getPreguntas() {
        return preguntas;
    }

}
