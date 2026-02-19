
Crea una clase llamada Persona que represente una persona autor del libro.

La clase debe tener los siguientes atributos privados:

    nombre (String)
    nacionalidad (String)

La clase debe incluir:

    Un constructor con todos los atributos
    Métodos get/set de todos los atributos
    Método toString con los datos bien formateados

Crea una clase llamada Libro que represente un libro de la biblioteca.

La clase debe tener los siguientes atributos privados:

    isbn (String)

    titulo (String)

    autor (Persona)

    anioPublicacion (int)

    prestado (boolean)

    Crear un constructor con todos los datos pasados por parámetro.
    Crear un constructor con año publicación por defecto 2000, autor por defecto (nombre "sin especificar" y nacionalidad "Española") y prestado false. El resto de datos se pasarán por parámetro.
    Métodos get y set para todos los atributos
    Un método prestar() que marque el libro como prestado
    Un método devolver() que marque el libro como no prestado
    Un método mostrarInfo() que muestre por consola toda la información del libro bien formateada

Crea una clase Biblioteca con el método main.

En esta clase:

    Declara un array de objetos Libro que pueda almacenar todos los libros que se creen.

    Crea 5 objetos Libro con datos inventados (utilizar los dos constructores que se han declarado en la clase Libro).

    Guarda los objetos en el array.

    Muestra la información de todos los libros usando el método mostrarInfo().

    Crea un menú que permita:

        Presta uno de los libros. Que pinte por consola el isbn y título de los libros que no está prestados.
        Devolver libros. 
        Dar de alta un libro nuevo. No se permiten libros repetidos.
        Dar de baja un libro de la biblioteca.
        Filtrar para mostrar todos los libros de un autor en concreto.
        Mostrar el título y nombre de autor de todos los libros.  
        Mostrar todos los libros con su información bien formateada.
        Salir.

** IMPORTANTE USO DE MÉTODOS Y ESTRUCTURAR BIEN EL CÓDIGO.
