import java.util.List;

public class Main {
    public static void main(String[] args) {
        SistemaTransmilenio sistema = new SistemaTransmilenio();

        // -- Estaciones
        Estacion portal80   = new Estacion("Portal 80",   "alto",  15);
        Estacion americas   = new Estacion("Américas",    "medio",  8);
        Estacion eldorado   = new Estacion("El Dorado",   "bajo",   3);
        Estacion transv86   = new Estacion("Transversal 86", "medio", 6);

        sistema.agregarEstacion(portal80);
        sistema.agregarEstacion(americas);
        sistema.agregarEstacion(eldorado);
        sistema.agregarEstacion(transv86);

        // -- Rutas
        Ruta rutaC = new Ruta("C");
        rutaC.agregarEstacion(portal80);
        rutaC.agregarEstacion(transv86);
        rutaC.agregarEstacion(americas);
        rutaC.agregarEstacion(eldorado);

        Ruta rutaA = new Ruta("A");
        rutaA.agregarEstacion(americas);
        rutaA.agregarEstacion(eldorado);

        Ruta rutaB = new Ruta("B");
        rutaB.agregarEstacion(portal80);
        rutaB.agregarEstacion(americas);
        rutaB.agregarEstacion(eldorado);

        sistema.agregarRuta(rutaC);
        sistema.agregarRuta(rutaA);
        sistema.agregarRuta(rutaB);

        try {
            // Servicio 1
            System.out.println("=== Servicio 1: Tiempo de espera ===");
            System.out.println("Portal 80 -> " + sistema.getTiempoEspera("Portal 80") + " min");
            System.out.println("Américas  -> " + sistema.getTiempoEspera("Américas")  + " min");

            // Servicio 2
            System.out.println("\n=== Servicio 2: Rutas ordenadas ===");
            List<String> ordenadas = sistema.getRutasOrdenadas();
            for (String nombre : ordenadas) {
                System.out.println("  " + nombre);
            }

            // Servicio 4
            System.out.println("\n=== Servicio 4: Rutas directas Portal 80 -> El Dorado ===");
            List<String> directas = sistema.getRutasDirectas("Portal 80", "El Dorado");
            if (directas.isEmpty()) {
                System.out.println("  No hay rutas directas.");
            } else {
                for (String r : directas) {
                    System.out.println("  " + r);
                }
            }

            // Excepción esperada
            System.out.println("\n=== Estación inexistente (excepción esperada) ===");
            sistema.getTiempoEspera("Inexistente");

        } catch (TransmilenioException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
