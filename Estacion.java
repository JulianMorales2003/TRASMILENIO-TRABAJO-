public class Estacion {
    private String nombre;
    private String nivelOcupacion; // "alto", "medio", "bajo"
    private int tiempoEspera;

    public Estacion(String nombre, String nivelOcupacion, int tiempoEspera) {
        this.nombre = nombre;
        this.nivelOcupacion = nivelOcupacion;
        this.tiempoEspera = tiempoEspera;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivelOcupacion() {
        return nivelOcupacion;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    @Override
    public String toString() {
        return nombre + " [" + nivelOcupacion + ", espera: " + tiempoEspera + " min]";
    }
}
