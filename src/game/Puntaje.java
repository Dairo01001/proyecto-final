package game;

public class Puntaje {

    private final String nombre;
    private final String grupo;
    private final int puntaje;

    public Puntaje(String nombre, String grupo, int puntaje) {
        this.nombre = nombre;
        this.grupo = grupo;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public int getPuntaje() {
        return puntaje;
    }
}
