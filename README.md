# 📚 Library Management System - Team 21

Sistema de gestión de biblioteca en Java que permite administrar libros, usuarios y préstamos. Este proyecto sigue un enfoque de **Programación Orientada a Objetos (POO)** y maneja excepciones personalizadas para un mejor control de errores.

## 📂 Estructura del Proyecto

```
library-management/
├── bin/                  
├── src/                 
│   ├── Main.java         
│   ├── models/           
│   │   ├── Book.java
│   │   ├── Patron.java
│   │   ├── Borrow.java
│   ├── services/         
│   │   ├── BookServ.java
│   │   ├── PatronServ.java
│   │   ├── BorrowServ.java
│   ├── exceptions/       
│   │   ├── BookExcep.java
│   │   ├── PatronExcep.java
│   │   ├── BorrowExcep.java
├── README.md            
```

- **`models/`** → Contiene las clases principales del sistema, como `Book`, `Patron` y `Borrow`.  
- **`services/`** → Maneja la lógica de la biblioteca, como la gestión de libros (`BookServ.java`), usuarios (`PatronServ.java`) y préstamos (`BorrowServ.java`).  
- **`exceptions/`** → Contiene clases de excepciones personalizadas para manejar errores de manera específica.  
- **`bin/`** → Carpeta donde se generan los archivos `.class` después de compilar el código.  
- **`Main.java`** → Archivo principal que ejecuta el sistema.  

---

## 🚀 Cómo Clonar y Ejecutar el Proyecto

### 1️⃣ Clonar el Repositorio
```bash
https://github.com/pizzerolaa/javaDelivery1
cd javaDelivery1
```

### 2️⃣ Compilar el Proyecto
```bash
javac src\Main.java src\models\*.java src\services\*.java src\exceptions\*.java
```
Esto compilará todos los archivos .java y generará los archivos .class dentro de bin/.

### 3️⃣ Ejecutar el Proyecto
```bash
java -cp bin Main
```
Esto ejecutará la aplicación en la terminal.

## 🛠 Tecnologías Utilizadas
- Java (JDK 11 o superior)
- VSCode (Editor recomendado)
- Git (Para control de versiones)

## 📌 Funcionalidades Implementadas

### Gestión de Libros
- ✅ Agregar nuevos libros al inventario
- ✅ Eliminar libros del sistema
- ✅ Mostrar todos los libros disponibles
- ✅ Editar información de libros existentes
- ✅ Buscar libros por ISBN

### Gestión de Usuarios (Patrons)
- ✅ Registrar nuevos usuarios
- ✅ Eliminar usuarios del sistema
- ✅ Ver lista de usuarios registrados
- ✅ Editar información de contacto de usuarios
- ✅ Buscar usuarios por ID

### Gestión de Préstamos
- ✅ Prestar libros a usuarios registrados
- ✅ Registrar devoluciones de libros
- ✅ Ver todos los préstamos activos
- ✅ Consultar libros prestados por usuario

## 🔄 Flujo del Programa

El sistema presenta un menú principal con las siguientes opciones:
1. Book Management
2. Patron Management
3. Borrow Management
4. Search
5. Exit

Cada opción lleva a un submenú con funciones específicas relacionadas con esa área.

## 🔍 Búsqueda

El sistema cuenta con capacidades de búsqueda avanzadas:
- Búsqueda de libros por ISBN
- Búsqueda de usuarios por ID, mostrando su información y libros prestados

## ⚠️ Manejo de Excepciones

El sistema implementa excepciones personalizadas para manejar errores comunes:
- `BookExcep`: Para errores relacionados con la gestión de libros
- `PatronExcep`: Para errores relacionados con la gestión de usuarios
- `BorrowExcep`: Para errores relacionados con préstamos y devoluciones

## 👥 Equipo de Desarrollo - Team 21

- Fernando Antonio Lopez Garcia - A01643685
- Santos Alejandro Arellano Olarte - A01643742
- Roberto Anwar Teigeiro Aguilar - A01643651
- Diego Michell Villa Duran - A00836723
- Sadrac Aramburo Enciso - A01643639
