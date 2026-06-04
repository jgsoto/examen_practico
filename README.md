# Arquitectura de Software: Evolución de Código

Este repositorio contiene el desarrollo de un proyecto práctico diseñado para evidenciar y contrastar la aplicación de tres enfoques de arquitectura y estructuración de software, implementado en **Java**.

## Enunciado del Proyecto
> "Realizar un proyecto con el tema y lenguaje de programación (a excepción de tipo propietario) de su elección, el cual debe contener lo siguiente: Código Espagueti, Monolítico por capas, Enfoque DDD. Cada una debe estar en una rama diferente con su respectivo Readme."

El propósito es resolver el mismo problema de negocio (**Gestion de prestamo de libros en una biblioteca**) a través de tres etapas evolutivas, demostrando los beneficios de la separación de responsabilidades y el diseño guiado por el dominio.

---

## Estructura de Ramas (Branches)

El proyecto está dividido en tres ramas distintas. Cada una cuenta con su propio archivo `README.md` que detalla la implementación y las decisiones técnicas tomadas:

### 1. `feature/codigo-espagueti`
* **Enfoque:** Código espagueti (Big Ball of Mud).
* **Descripción:** Toda la lógica de negocio, interfaz de usuario y manejo de datos se encuentra acoplada en un único flujo, demostrando los problemas de mantenibilidad y escalabilidad.

### 2. `feature/monolitico-capas`
* **Enfoque:** Arquitectura Monolítica por Capas.
* **Descripción:** Separación técnica de responsabilidades dividida en capas claras: Presentación (Controladores), Lógica de Negocio (Servicios) y Acceso a Datos (Repositorios/Modelos).

### 3. `feature/ddd`
* **Enfoque:** Diseño Guiado por el Dominio (Domain-Driven Design).
* **Descripción:** Implementación centrada en el modelo de negocio. Se evidencian conceptos clave de DDD como Entidades, Objetos de Valor (Value Objects), Agregados (Aggregates) y persistencia desacoplada.

---

## Tecnologías Utilizadas
* **Lenguaje:** Java
* **Persistencia:** En memoria / Simulación de almacenamiento de datos.

---

## Cómo Explorar el Proyecto
Puedes cambiar entre las diferentes ramas para revisar el código de cada enfoque usando los comandos de Git o el selector de ramas en la interfaz de GitHub:

```bash
# Para revisar el código espagueti
git checkout feature/codigo-espagueti

# Para revisar el monolítico por capas
git checkout feature/monolitico-capas

# Para revisar el enfoque DDD
git checkout feature/ddd
