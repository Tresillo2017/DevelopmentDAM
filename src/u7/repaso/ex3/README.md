Ejercicio Java: Gestión de una biblioteca
Crea una aplicación en Java para gestionar los libros de una biblioteca.

El objetivo del ejercicio es practicar:

Herencia.
Clases abstractas.
Interfaces.
ArrayList.
Bucles.
Condicionales.
Objetos que tienen como atributos otros objetos.
Enunciado
Una biblioteca necesita una aplicación para registrar distintos tipos de libros, sus autores y los préstamos realizados.

Cada libro tendrá unos datos comunes, pero también existirán distintos tipos de libros con características propias.

1. Clase Autor
   Crea una clase llamada Autor con los siguientes atributos:


nombre - String
nacionalidad - String
anioNacimiento - int

La clase debe tener:

Constructor con todos los parámetros.
Getters y setters.
Método toString().
2. Clase Prestamo
   Crea una clase llamada Prestamo con los siguientes atributos:


nombreUsuario - String
fechaPrestamo - String
diasPrestamo - int

La clase debe tener:

Constructor con todos los parámetros.
Getters y setters.
Método toString().
3. Clase abstracta Libro
   Crea una clase abstracta llamada Libro con los siguientes atributos:


titulo - String
anioPublicacion - int
precioBase - double
autor - Autor
prestamos - ArrayList<Prestamo>

Ten en cuenta que:

Un libro tiene como atributo un objeto de tipo Autor.
Un libro tiene un ArrayList de objetos de tipo Prestamo.
La clase debe tener:

Constructor con todos los atributos excepto el ArrayList, que se inicializará vacío.
Getters y setters.
Método anadirPrestamo(Prestamo prestamo).
Método mostrarPrestamos(), que recorra el ArrayList y muestre todos los préstamos del libro.
Método toString().
Método abstracto:

public abstract double calcularPrecioFinal();

4. Interfaz Prestable
   Crea una interfaz llamada Prestable con el siguiente método:


void prestar(String nombreUsuario, String fechaPrestamo, int diasPrestamo);

5. Clases hijas
   Crea tres clases que hereden de Libro e implementen la interfaz Prestable.

Clase Novela
Tendrá como atributo propio:


private String genero;

El método calcularPrecioFinal() debe funcionar así:

Si el género es "fantasía" o "ciencia ficción", se suma un suplemento de 3 € al precio base.
En cualquier otro caso, el precio final será igual al precio base.
El método prestar() debe crear un nuevo objeto Prestamo y añadirlo a la lista de préstamos del libro.

Clase LibroTexto
Tendrá como atributo propio:


private String asignatura;

El método calcularPrecioFinal() debe funcionar así:

Si la asignatura es "programación", se suma un suplemento de 5 € al precio base.
En cualquier otro caso, se suma un suplemento de 2 € al precio base.
El método prestar() debe crear un nuevo objeto Prestamo y añadirlo a la lista de préstamos del libro.

Clase Comic
Tendrá como atributo propio:


private boolean esColeccionista;

El método calcularPrecioFinal() debe funcionar así:

Si el cómic es de coleccionista, el precio base se incrementa un 30%.
Si no es de coleccionista, el precio final será igual al precio base.
El método prestar() debe crear un nuevo objeto Prestamo y añadirlo a la lista de préstamos del libro.

6. Clase principal Biblioteca
   Crea una clase principal llamada Biblioteca.

En ella deberás crear un ArrayList<Libro> para guardar todos los libros de la biblioteca.


ArrayList<Libro> libros = new ArrayList<>();

El programa debe mostrar un menú con las siguientes opciones:


1. Añadir novela
2. Añadir libro de texto
3. Añadir cómic
4. Mostrar todos los libros
5. Prestar un libro
6. Mostrar préstamos de un libro
7. Calcular precio total de todos los libros
8. Salir

7. Funcionamiento del menú
   El menú debe repetirse hasta que el usuario elija la opción de salir.

Puedes usar switch, if, else if o las estructuras condicionales que consideres necesarias.

Opción 1: Añadir novela
El usuario deberá introducir los datos necesarios para crear una novela.

También deberá introducir los datos del autor.

Datos a pedir:


Título:
Año de publicación:
Precio base:
Nombre del autor:
Nacionalidad del autor:
Año de nacimiento del autor:
Género:

Después se creará el objeto Novela y se añadirá al ArrayList.

Opción 2: Añadir libro de texto
El usuario deberá introducir los datos necesarios para crear un libro de texto.

También deberá introducir los datos del autor.

Datos a pedir:


Título:
Año de publicación:
Precio base:
Nombre del autor:
Nacionalidad del autor:
Año de nacimiento del autor:
Asignatura:

Después se creará el objeto LibroTexto y se añadirá al ArrayList.

Opción 3: Añadir cómic
El usuario deberá introducir los datos necesarios para crear un cómic.

También deberá introducir los datos del autor.

Datos a pedir:


Título:
Año de publicación:
Precio base:
Nombre del autor:
Nacionalidad del autor:
Año de nacimiento del autor:
¿Es de coleccionista?

Después se creará el objeto Comic y se añadirá al ArrayList.

Opción 4: Mostrar todos los libros
El programa debe mostrar todos los libros registrados en la biblioteca.

Para ello se debe recorrer el ArrayList usando un bucle.

Opción 5: Prestar un libro
El usuario deberá introducir el título del libro que quiere prestar.

Si el libro existe, se pedirán los datos del préstamo:


Nombre del usuario:
Fecha del préstamo:
Días de préstamo:

Después se llamará al método prestar() del libro correspondiente.

Si el libro no existe, se mostrará un mensaje indicando que no se ha encontrado.

Opción 6: Mostrar préstamos de un libro
El usuario deberá introducir el título del libro.

Si el libro existe, se mostrarán todos sus préstamos usando el método mostrarPrestamos().

Si el libro no tiene préstamos, se deberá mostrar un mensaje indicándolo.

Si el libro no existe, se mostrará un mensaje indicando que no se ha encontrado.

Opción 7: Calcular precio total de todos los libros
El programa debe calcular la suma del precio final de todos los libros registrados.

Para ello se recorrerá el ArrayList y se sumará el resultado del método:


calcularPrecioFinal()

Opción 8: Salir
El programa finalizará mostrando un mensaje de despedida.