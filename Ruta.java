import java.util.ArrayList;
import java.util.List;

public class Ruta {
    private String nombre;
    private List<Estacion> estaciones;

    public Ruta(String nombre) {
        this.nombre = nombre;
        this.estaciones = new ArrayList<>();
    }

    public void agregarEstacion(Estacion estacion) {
        estaciones.add(estacion);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Estacion> getEstaciones() {
        return estaciones;
    }

    /**
     * Verifica si esta ruta contiene una estación con el nombre dado.
     */
    public boolean contieneEstacion(String nombre) {
        for (Estacion e : estaciones) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna el número de paradas entre dos estaciones en esta ruta.
     * Retorna -1 si la estacion no esta en la ruta y si lo está es +1.
     */
    public int numParadas(String nombreInicio, String nombreFin) {
        int idxInicio = -1;
        int idxFin = -1;
        for (int i = 0; i < estaciones.size(); i++) {
            String n = estaciones.get(i).getNombre();
            if (n.equalsIgnoreCase(nombreInicio)) idxInicio = i;
            if (n.equalsIgnoreCase(nombreFin))   idxFin   = i;
        }
        if (idxInicio == -1 || idxFin == -1) return -1;
        return Math.abs(idxFin - idxInicio);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
