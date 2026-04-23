# 🚌 TRASMILENIO-TRABAJO
 
Trabajo en clase — **Desarrollo Orientado por Objetos**  
Escuela Colombiana de Ingeniería Julio Garavito · 2026-1
 
---
 
## 👥 Integrantes
 
| Nombre | GitHub |
|---|---|
| Julian Morales | @JulianMorales2003 |
| Sergio Buitrago | @sergiobuitragos |
| Jhonatan Peña Mora | @jhonatanpenamora-png |
 
---
 
## 📋 Descripción
 
Implementación en Java de un sistema de información para **TransMilenio**, que modela troncales, rutas y estaciones, y ofrece consultas sobre tiempos de espera y rutas disponibles entre estaciones.

 ## 🏗️ Diagrama de clases
El diagrama de clases se encuentra en el archivo *TransmilenioAstah.asta* incluido en este repositorio. Para visualizarlo abrirlo con [Astah Community](https://astah.net/products/astah-community/).
 
El sistema está compuesto por las siguientes clases:
 
- *Estacion* — nombre, nivel de ocupación (alto/medio/bajo) y tiempo de espera en minutos.
- *Ruta* — nombre y lista ordenada de estaciones en las que para.
- *Troncal* — nombre, velocidad promedio (metros/minuto) y estaciones que la conforman.
- *SistemaTransmilenio* — clase principal que agrega y coordina rutas, troncales y estaciones, y expone los servicios del sistema.

 
## ⚙️ Servicios implementados
 
### Servicio 1 — Tiempo de espera de una estación
```java
int getTiempoEspera(String nombreEstacion) throws TransmilenioException
```
Dado el nombre de una estación, retorna su tiempo de espera en minutos.
 
Cada estación tiene un nivel de ocupación (alto, medio o bajo) al que le corresponde un tiempo de espera definido al momento de crearla. Este servicio simplemente consulta ese valor directamente desde el objeto `Estacion`. Si el nombre ingresado no corresponde a ninguna estación registrada en el sistema, se lanza una `TransmilenioException` con un mensaje descriptivo.
 
---
 
### Servicio 2 — Rutas ordenadas alfabéticamente
```java
List<String> getRutasOrdenadas()
```
Retorna los nombres de todas las rutas del sistema ordenados alfabéticamente.
 
El sistema mantiene internamente una lista de objetos `Ruta`. Este servicio extrae los nombres de todas ellas, los almacena en una nueva lista y aplica `Collections.sort()` para ordenarlas. El resultado es una lista de `String` lista para mostrar al usuario. No lanza excepción porque si no hay rutas simplemente retorna una lista vacía.
 
---
 
### Servicio 4 — Rutas directas entre dos estaciones
```java
List<String> getRutasDirectas(String nombreInicio, String nombreFin) throws TransmilenioException
```
Dado el nombre de dos estaciones, retorna las rutas que permiten ir de una a otra **sin transbordos**, ordenadas:
1. De menor a mayor por número de paradas.
2. Alfabéticamente por nombre de ruta en caso de empate.
El servicio primero valida que ambas estaciones existan en el sistema, lanzando `TransmilenioException` en caso contrario. Luego filtra las rutas que contienen ambas estaciones. Para cada ruta candidata se calcula el número de paradas entre las dos estaciones buscando sus posiciones en la lista y calculando la diferencia de índices. Finalmente se ordena el resultado usando un `Comparator` compuesto que aplica primero el criterio de paradas y luego el alfabético.

---
## 🗂️ Decisiones de diseño
 
| Colección | Uso | Justificación |
|---|---|---|
| HashMap<String, Estacion> | Estaciones en SistemaTransmilenio | Búsqueda O(1) por nombre — el enunciado indica que estas son consultas muy frecuentes |
| ArrayList<Ruta> | Rutas en SistemaTransmilenio | Permite iterar y ordenar con Collections.sort / Comparator |
| ArrayList<Estacion> | Estaciones dentro de cada Ruta y Troncal | El orden importa (define la secuencia de paradas), y se necesita acceso por índice para contar paradas |
 
---

## 📝 Conclusiones
 
- El diseño del sistema se basó en el diagrama de clases elaborado en clase, respetando las relaciones y responsabilidades definidas en el modelo UML.
- Se priorizó el uso de colecciones adecuadas para cada caso: HashMap para búsquedas rápidas por nombre de estación y ArrayList donde el orden secuencial de las paradas es relevante.
- Se incluyó una clase Main con el único propósito de probar las funcionalidades implementadas durante el desarrollo. Esta clase *no es parte del sistema* y no es necesaria para el funcionamiento del proyecto; se conserva en el repositorio únicamente como evidencia de las pruebas realizadas.
- El manejo de errores se centralizó en TransmilenioException, siguiendo las buenas prácticas de diseño orientado a objetos vistas en el curso.
---

## 🚧 Métodos pendientes de implementación
 
Los siguientes métodos están declarados en `SistemaTransmilenio` pero aún no implementados, ya que corresponden a servicios que serán desarrollados en las siguientes sesiones del trabajo:
 
| Método | Servicio |
|---|---|
| `importarRutas(String archivo)` | Persistencia — importar ruta desde archivo de texto |
| `exportarRutas(String archivo)` | Persistencia — exportar rutas directas a archivo de texto |
 
