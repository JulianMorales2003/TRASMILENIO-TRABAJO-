# 🚌 TRASMILENIO-TRABAJO
 
Trabajo en clase — **Desarrollo Orientado por Objetos**  
Escuela Colombiana de Ingeniería Julio Garavito · 2026-1
 
---
 
## 👥 Integrantes
 
| Nombre | GitHub |
|---|---|
| Julian Morales | @JulianMorales2003 |
| Sergio Buitrago | @sergiobuitragos |
| Jhonatan Peña Mora | @jhonatanpenamora- |
 
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
Lanza `TransmilenioException` si la estación no existe en el sistema.
 
---
 
### Servicio 2 — Rutas ordenadas alfabéticamente
```java
List<String> getRutasOrdenadas()
```
Retorna los nombres de todas las rutas del sistema ordenados alfabéticamente.
 
---
 
### Servicio 4 — Rutas directas entre dos estaciones
```java
List<String> getRutasDirectas(String nombreInicio, String nombreFin) throws TransmilenioException
```
Dado el nombre de dos estaciones, retorna las rutas que permiten ir de una a otra **sin transbordos**, ordenadas:
1. De menor a mayor por número de paradas.
2. Alfabéticamente por nombre de ruta en caso de empate.
Lanza `TransmilenioException` si alguna de las dos estaciones no existe.
 
---
