# Enfoque 3: Diseño Guiado por el Dominio (Domain-Driven Design - DDD) 

Esta rama contiene el  Sistema de Gestión de Biblioteca utilizando **Domain-Driven Design (DDD)**.

A diferencia de la arquitectura por capas tradicional, aquí rompemos el acoplamiento técnico. El núcleo del software se organiza alrededor de las reglas del negocio (el Dominio).

---

## Estructura de Paquetes (DDD)

El proyecto se estructura siguiendo el flujo de dependencias de adentro hacia afuera (el Dominio no depende de nada, todos dependen del Dominio):

```text
library/
├── domain/                      <-- EL CORAZÓN DE LA APLICACIÓN (Cero frameworks)
│   ├── model/                   <-- Entidades y Agregados
│   │   ├── Book.java            <-- Entidad con comportamiento/reglas
│   │   ├── BookTitle.java       <-- Objeto de Valor (Value Object)
│   │   ├── Member.java          
│   │   └── Loan.java  
|   ├── model/                   <-- Objeto de Valor (Value Object) 
│   │   └── BookTitle.java               
│   ├── repository/              <-- Contratos / Interfaces de persistencia
│   │   ├── BookRepository.java
│   │   ├── MemberRepository.java
│   │   └── LoanRepository.java
│   └── exception/               <-- Excepciones de negocio explícitas
│       ├── BookUnavailableException.java
│       ├── BookAlreadyAvailableException.java
│       └── LoanAlreadyReturnedException.java
│
├── application/                 <-- CAPA DE APLICACIÓN (Casos de Uso)
│   └── usecase/                 <-- Orquestadores puros de la lógica
│       ├── RegisterBookUseCase.java
│       ├── RegisterMemberUseCase.java
│       ├── BorrowBookUseCase.java
│       ├── ReturnBookUseCase.java
│       └── ... (demás casos de uso)
│
├── infrastructure/              <-- CAPA DE INFRAESTRUCTURA (Detalles Técnicos)
│   ├── persistence/             <-- Modelos anémicos exclusivos para ORM
│   │   ├── JpaBookEntity.java
│   │   ├── JpaMemberEntity.java
│   │   └── JpaLoanEntity.java
│   ├── jpa/                     <-- Interfaces nativas de Spring Data JPA
│   │   ├── SpringDataBookRepository.java
│   │   └── ...
│   └── repository/              <-- Implementación real de adaptadores
│       ├── BookRepositoryImpl.java <-- Traduce de Dominio a JPA y viceversa
│       └── ...
│
├── interfaces/                  <-- CAPA DE ADAPTADORES DE ENTRADA (User Interface)
│   └── controller/              <-- Controladores web de Spring Boot
│       ├── HomeController.java
│       └── ...
└── LibraryApplication.java
```
## Conceptos Clave de DDD Evidenciados
Este diseño soluciona las deficiencias del monolito por capas mediante la aplicación de patrones tácticos de DDD:

1. ***Modelos Ricos vs. Modelos Anémicos:*** 
Las clases en domain.model ya no son simples bolsas de Getters y Setters. Ahora poseen comportamiento y protegen sus invariantes (reglas de negocio).

2. ***Objetos de Valor (Value Objects)***
Se introduce BookTitle.java como un Value Object. No tiene una identidad única (ID), es inmutable y encapsula sus propias validaciones (por ejemplo, asegurar que el título no sea nulo ni vacío).

3. ***Inversión de Dependencias y Desacoplamiento de Persistencia***
En domain.repository se definen Interfaces puras que responden a lo que el negocio necesita, ignorando por completo la tecnología de almacenamiento.
En infrastructure se implementan los detalles. BookRepositoryImpl actúa como un adaptador: utiliza SpringDataBookRepository y mapea las entidades puras del dominio (Book) hacia las entidades de base de datos (JpaBookEntity). Si mañana cambiamos H2/JPA por MongoDB, el código del dominio permanece intacto.

4. ***Casos de Uso Dirigidos (Application Layer)***
Las clases en application.usecase (como BorrowBookUseCase) reemplazan los servicios gigantes de la arquitectura por capas. Cada clase tiene una única responsabilidad: coordinar la ejecución de un flujo de negocio específico, interactuando únicamente con las interfaces del dominio.

## Tecnologías Utilizadas
- ***Núcleo del Dominio y Aplicación:*** Java (Sin dependencias de Spring).

- ***Capa de Infraestructura e Interfaces:*** Spring Boot, Spring Data JPA, H2 Database y Thymeleaf para la UI.

Cómo Ejecutar este Enfoque
Asegúrate de estar en esta rama:

```Bash
git checkout feature/enfoque-ddd
```

Ejecuta la aplicación mediante Maven o desde tu IDE dándole Run a LibraryApplication:

```Bash
./mvnw spring-boot:run
```
Accede a http://localhost:8080 para interactuar con el sistema.

## Conclusión del Proyecto
A través de estas tres ramas, se ha evidenciado el ciclo completo de madurez en el desarrollo de software: desde el caos centralizado del Código Espagueti, pasando por la separación técnica ordenada pero rígidamente acoplada del Monolito por Capas, hasta alcanzar la máxima flexibilidad, robustez y orientación al negocio que ofrece Domain-Driven Design.