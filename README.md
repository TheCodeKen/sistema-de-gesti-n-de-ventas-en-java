# Java Sales Management System

![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue)
![Eclipse](https://img.shields.io/badge/IDE-Eclipse-purple?logo=eclipseide)
![Status](https://img.shields.io/badge/Status-Functional-success)

## Descripción

Sistema de gestión de ventas y almacén desarrollado en Java,
utilizando Java Swing para la interfaz gráfica, programación
orientada a objetos, algoritmos y estructuras de datos.

El sistema permite administrar clientes, productos, ventas,
inventario y reportes mediante una interfaz gráfica de escritorio,
utilizando archivos de texto para la persistencia de datos.

Proyecto académico desarrollado durante el segundo ciclo de
Computación e Informática en Cibertec, en el curso de
Algoritmos y Estructura de Datos (2024).

## Funcionalidades

- Registro, consulta, modificación y eliminación de clientes.
- Registro, consulta, modificación y eliminación de productos.
- Gestión de inventario y control de stock.
- Registro de ventas y detalle de ventas.
- Generación de reportes.
- Validación de campos y manejo de excepciones en productos.
- Persistencia de información mediante archivos TXT.
- Interfaz gráfica con imágenes e iconos.

## Tecnologías utilizadas

| Tecnología | Propósito |
|------------|-----------|
| Java | Lenguaje de programación |
| Java Swing | Interfaz gráfica de escritorio |
| Eclipse IDE | Entorno de desarrollo original |
| Java Collections / Arrays | Gestión de estructuras de datos |
| Java I/O | Lectura y escritura de archivos |
| Git | Control de versiones |
| GitHub | Alojamiento del código fuente |

## Conceptos aplicados

- Programación orientada a objetos (POO).
- Encapsulamiento.
- Clases y objetos.
- Constructores.
- Arreglos y estructuras de datos.
- Algoritmos de búsqueda.
- Operaciones CRUD.
- Programación orientada a eventos.
- Manejo de excepciones.
- Persistencia de archivos.
- Separación de responsabilidades mediante paquetes.

## Estructura del proyecto

```
java-sales-management-system/
|
|-- src/
|   |-- arreglo/
|   |   |-- Arreglo_Cliente.java
|   |   |-- Arreglo_DetalleVenta.java
|   |   |-- Arreglo_Producto.java
|   |   |-- Arreglo_Ventas.java
|   |
|   |-- clases/
|   |   |-- Cliente.java
|   |   |-- DetalleVenta.java
|   |   |-- Producto.java
|   |   |-- Ventas.java
|   |
|   |-- gui/
|       |-- Menu_Principal.java
|       |-- Ventana_Almacen.java
|       |-- Ventana_Clientes.java
|       |-- Ventana_Productos.java
|       |-- Ventana_Reportes.java
|       |-- Ventana_Ventas.java
|
|-- Media/
|-- Clientes.txt
|-- DetalleVenta.txt
|-- Productos.txt
|-- Ventas.txt
|-- .classpath
|-- .project
|-- .gitignore
|-- README.md
```

## Requisitos

- JDK 25 (versión probada).
- Eclipse IDE (opcional).
- Git (opcional).

## Instalación y ejecución

### Desde Eclipse

1. Descargar o clonar el repositorio.
2. Abrir Eclipse IDE.
3. Seleccionar File > Import.
4. Seleccionar General > Existing Projects into Workspace.
5. Seleccionar la carpeta del proyecto.
6. Configurar un JDK compatible en Java Build Path.
7. Ejecutar la clase gui.Menu_Principal.

### Desde PowerShell

Ejecutar los siguientes comandos desde la carpeta raíz del proyecto:

```powershell
New-Item -ItemType Directory -Path build -Force

$archivos = Get-ChildItem src -Recurse -Filter *.java |
ForEach-Object { $_.FullName }

javac -encoding UTF-8 -d build $archivos

java -cp build gui.Menu_Principal
```

## Persistencia de datos

El sistema utiliza archivos de texto para almacenar la información
sin necesidad de instalar un motor de base de datos.

| Archivo | Contenido |
|---------|-----------|
| Clientes.txt | Información de clientes |
| Productos.txt | Información de productos |
| Ventas.txt | Registro de ventas |
| DetalleVenta.txt | Detalles de cada venta |

## Mejoras realizadas

- Corrección de rutas absolutas de recursos gráficos.
- Uso de rutas relativas para mejorar la portabilidad.
- Validación de campos obligatorios en productos.
- Control de excepciones numéricas en productos.
- Validación de precios y cantidades de stock.
- Pruebas de compilación y ejecución con Java 25.
- Organización del repositorio mediante Git.
- Exclusión de archivos compilados y temporales.

## Mejoras futuras

- Implementación de una base de datos relacional.
- Incorporación del patrón MVC.
- Implementación de pruebas unitarias con JUnit.
- Sistema de autenticación y autorización.
- Exportación de reportes a PDF y Excel.
- Mejora de la interfaz gráfica.

## Contexto académico

- Institución: Cibertec.
- Carrera: Computación e Informática.
- Curso: Algoritmos y Estructura de Datos.
- Ciclo: Segundo ciclo.
- Año: 2024.

## Estado del proyecto

Proyecto académico funcional, revisado y actualizado para
formar parte de un portafolio de desarrollo de software.
