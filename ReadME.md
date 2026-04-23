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
