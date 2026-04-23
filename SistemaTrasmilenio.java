import java.util.*;

public class SistemaTransmilenio {

    private List<Ruta>    rutas;
    private List<Troncal> troncales;
    private Map<String, Estacion> estaciones; 

    public SistemaTransmilenio() {
        rutas      = new ArrayList<>();
        troncales  = new ArrayList<>();
        estaciones = new HashMap<>();
    }

    public void agregarEstacion(Estacion estacion) {
        estaciones.put(estacion.getNombre().toLowerCase(), estacion);
    }

    public void agregarRuta(Ruta ruta) {
        rutas.add(ruta);
    }

    public void agregarTroncal(Troncal troncal) {
        troncales.add(troncal);
    }

    //  SERVICIO 1: Tiempo de espera de una estación

    /**
     * Retorna el tiempo de espera en minutos de la estación con el nombre dado.
     * @param nombreEstacion nombre de la estación
     * @return tiempo de espera en minutos
     * @throws TransmilenioException si la estación no existe en el sistema
     */
    public int getTiempoEspera(String nombreEstacion) throws TransmilenioException {
        Estacion e = estaciones.get(nombreEstacion.toLowerCase());
        if (e == null) {
            throw new TransmilenioException(
                "La estación '" + nombreEstacion + "' no existe en el sistema.");
        }
        return e.getTiempoEspera();
    }

    //  SERVICIO 2: Rutas ordenadas alfabéticamente

    /**
     * Retorna los nombres de todas las rutas del sistema ordenados alfabéticamente.
     * @return lista de nombres de rutas en orden alfabético
     */
    public List<String> getRutasOrdenadas() {
        List<String> nombres = new ArrayList<>();
        for (Ruta r : rutas) {
            nombres.add(r.getNombre());
        }
        Collections.sort(nombres);
        return nombres;
    }

    //  SERVICIO 4: Rutas directas entre dos estaciones sin transbordo, ordenadas por número de paradas y luego alfabético
   
    /**
     * Retorna las rutas que permiten ir de inicio a fin sin trasbordos.
     *
     * @param nombreInicio estación de origen
     * @param nombreFin    estación de destino
     * @return lista ordenada de nombres de rutas directas
     * @throws TransmilenioException si alguna de las estaciones no existe
     */
    public List<String> getRutasDirectas(String nombreInicio, String nombreFin)
            throws TransmilenioException {

        if (!estaciones.containsKey(nombreInicio.toLowerCase())) {
            throw new TransmilenioException(
                "La estación de origen '" + nombreInicio + "' no existe en el sistema.");
        }
        if (!estaciones.containsKey(nombreFin.toLowerCase())) {
            throw new TransmilenioException(
                "La estación de destino '" + nombreFin + "' no existe en el sistema.");
        }

        List<Ruta> candidatas = new ArrayList<>();
        for (Ruta r : rutas) {
            if (r.contieneEstacion(nombreInicio) && r.contieneEstacion(nombreFin)) {
                candidatas.add(r);
            }
        }

        candidatas.sort((r1, r2) -> {
            int paradas1 = r1.numParadas(nombreInicio, nombreFin);
            int paradas2 = r2.numParadas(nombreInicio, nombreFin);
            if (paradas1 != paradas2) {
                return Integer.compare(paradas1, paradas2);
            }
            return r1.getNombre().compareTo(r2.getNombre());
        });

        List<String> resultado = new ArrayList<>();
        for (Ruta r : candidatas) {
            resultado.add(r.getNombre());
        }
        return resultado;
    }

    public void importarRutas(String archivo) {
        // Falta implementar las rutas
    }

    public void exportarRutas(String archivo) {
        // Falta implementar las rutas de estacion a estacion
    }
}
