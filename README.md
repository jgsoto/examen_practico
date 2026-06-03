# Enfoque 1: Código Espagueti (Big Ball of Mud)

Esta rama contiene la primera fase del proyecto: una solución funcional para un **Sistema de Gestión de Biblioteca**, implementada bajo el antipatrón de **Código Espagueti** o "Gran Bola de Lodo".

El objetivo de esta entrega es demostrar cómo la falta de estructura, aunque produce un software que "funciona", destruye la mantenibilidad, escalabilidad y testabilidad del sistema a largo plazo.

---

## Análisis de la Implementación

El código se ha centralizado por completo en una única clase (`LibrarySystem.java`) y dentro de un solo método (`main`). A continuación, se detallan los problemas arquitectónicos introducidos intencionalmente:

### 1. Ausencia de Encapsulamiento
* Las clases internas (`Book`, `Member`, `Loan`) actúan como meros contenedores de datos (estructuras anémicas).
* Sus atributos no son privados y carecen de métodos para controlar su estado. Cualquier parte del código puede modificar directamente propiedades críticas como `book.available = true` o `loan.returned = false` sin ninguna restricción ni validación previa.

### 2. Violación del Principio de Responsabilidad Única (SRP)
La clase `LibrarySystem` y su método `main` asumen simultáneamente múltiples responsabilidades que deberían estar completamente separadas:
* **Interfaz de Usuario (UI):** Manejo directo de la consola mediante `Scanner` y formateo de los mensajes con `System.out.println`.
* **Lógica de Negocio:** Validación de reglas del sistema (comprobar si un libro ya está prestado, si el miembro existe, control de secuencias autoincrementales de IDs).
* **Persistencia de Datos:** Gestión del almacenamiento en memoria a través de listas `ArrayList` locales al método.

### 3. Alto Acoplamiento y Baja Cohesión
* Todo el flujo del sistema depende de un ciclo infinito `while(true)` y un bloque `switch-case` gigante de acoplamiento rígido.
* Si se deseara cambiar la interfaz de consola por una API Web (Spring Boot) o migrar el almacenamiento de `ArrayList` a una base de datos real (SQL), se tendría que reescribir prácticamente el 100% del archivo.

### 4. Imposibilidad de Pruebas Unitarias
* Es técnicamente inviable realizar pruebas sobre la lógica de negocio (por ejemplo, validar que un libro prestado cambie su estado a no disponible) sin tener que simular entradas de teclado por consola e interceptar de forma compleja la salida estándar del sistema.

---

## Tecnologías y Requisitos
* **Lenguaje:** Java
* **Frameworks:** Ninguno (Sin dependencias externas para evidenciar el comportamiento crudo del antipatrón).
* **Entrada/Salida:** Consola estándar (`java.util.Scanner`).

---

## Cómo Ejecutar este Enfoque

1. Asegúrate de estar en esta rama:
```bash
   git checkout feature/codigo-espagueti
``` 
2. Compila el archivo principal desde tu terminal o ejecútalo directamente desde IntelliJ IDEA:

```Bash
   javac LibrarySystem.java
   java LibrarySystem
```

3. Sigue las instrucciones del menú en pantalla para registrar libros, miembros y gestionar préstamos.