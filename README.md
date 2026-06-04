# Enfoque 2: Arquitectura Monolítica por Capas

Esta rama contiene la segunda fase del proyecto: El Ssistema de Gestión de préstamo de libros estructurado usando **Arquitectura Monolítica por Capas**.

A diferencia del enfoque anterior, el código se ha organizado separando las resposabilidades en varias clases.

---

## Estructura del Proyecto y Capas

El proyecto organiza sus componentes dentro del paquete principal `library` de la siguiente manera:

```text
src/main/java/library/
├── controller/          <-- CAPA DE PRESENTACIÓN (Controladores Web)
│   ├── BookController.java
│   ├── HomeController.java
│   ├── LoanController.java
│   └── MemberController.java
├── service/             <-- CAPA DE LÓGICA DE NEGOCIO (Servicios)
│   ├── BookService.java
│   ├── LoanService.java
│   └── MemberService.java
├── repository/          <-- CAPA DE ACCESO A DATOS (Repositorios Spring Data JPA)
│   ├── BookRepository.java
│   ├── LoanRepository.java
│   └── MemberRepository.java
├── model/               <-- MODELO DE DATOS / ENTIDADES ANÉMICAS
│   ├── Book.java
│   ├── Loan.java
│   └── Member.java
└── LibraryApplication.java
```

## Análisis de la Arquitectura por Capas
Se implementa una arquitectura por capas, respetando una jerarquía de dependencias estrictamente unidireccional (la capa superior conoce a la inferior, pero no al revés):

1. Capa de Presentación (controller/ y templates/)
Responsabilidad: Gestionar las peticiones HTTP y renderizar las vistas del usuario.


2. Capa de Lógica de Negocio (service/)
Responsabilidad: Orquestar los procesos y validar las reglas del negocio (por ejemplo, comprobar la disponibilidad de un libro antes de procesar un préstamo).


3. Capa de Acceso a Datos (repository/ y model/)
Responsabilidad: Gestionar la persistencia de la información en el sistema de almacenamiento.


## Limitaciones de este Enfoque (Frente a DDD)
Aunque esta arquitectura resuelve el desorden del código espagueti, tiene ciertos problemas arquitectónicos tradicionales que justifican el salto hacia DDD:

**Modelos Anémicos:** Las clases en model/ son simples contenedores de datos (Getters y Setters) sin comportamiento ni validaciones internas de negocio. La lógica está en los servicios.

**Acoplamiento a la Tecnología:** La capa de negocio (service) depende directamente de las abstracciones de persistencia (repository), lo que dificulta cambiar de infraestructura tecnológia.

## Tecnologías Utilizadas
**Framework Principal:** Spring Boot

**Motor de Plantillas (UI):** Thymeleaf (.html)

**Persistencia:** Spring Data JPA con Base de Datos H2 (en memoria).

## Cómo Ejecutar este Enfoque
1. Entrar en la rama:

```Bash
git checkout feature/monolitico-capas
```
2. Ejecutar la aplicación desde la terminal mediante Maven o directamente dándole Run a LibraryApplication en IntelliJ:

```Bash
./mvnw spring-boot:run
```

3. Abrir tu navegador web e ingresar a: http://localhost:8080 para interactuar con el sistema a través de la interfaz gráfica.