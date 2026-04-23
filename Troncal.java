import java.util.ArrayList;
import java.util.List;

public class Troncal {
    private String nombre;
    private double velocidadPromedio; // metros/minuto
    private List<Estacion> estaciones;

    public Troncal(String nombre, double velocidadPromedio) {
        this.nombre = nombre;
        this.velocidadPromedio = velocidadPromedio;
        this.estaciones = new ArrayList<>();
    }

    public void getEstacion(Estacion estacion) {
        estaciones.add(estacion);
    }

    public boolean contieneEstacion(String nombre) {
        for (Estacion e : estaciones) {
            if (e.getNombre().equalsIgnoreCase(nombre)) return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public double getVelocidadPromedio() {
        return velocidadPromedio;
    }

    public List<Estacion> getEstaciones() {
        return estaciones;
    }
}
