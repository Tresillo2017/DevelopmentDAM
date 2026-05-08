Se desea desarrollar una aplicación en Java que permita gestionar los libros de una biblioteca utilizando una base de datos MySQL.

La aplicación deberá conectarse a una base de datos mediante JDBC y permitir realizar operaciones básicas sobre una tabla de libros.

Debes crear una base de datos llamada: biblioteca_db (utiliza el script adjunto).

Crea una clase llamada ConexionBD con el método mySQLConnect() que nos devuelva una conexión a la base de datos biblioteca_db (Connection).

Crea una clase llamada Libro. La clase tendrá los siguientes atributos: id, titulo, autor, genero, precio, disponible.

La clase debe incluir:

Constructor con todos los atributos excepto id.
Constructor con todos los atributos.
Getters y setters.
Método toString().
Crea una clase llamada LibroDAO.

Esta clase será la encargada de realizar las operaciones con la base de datos.

Debe contener los siguientes métodos:

insertarLibro(Libro libro): Permite insertar un nuevo libro en la base de datos.

mostrarLibros(): Muestra todos los libros almacenados en la base de datos.
buscarPorAutor(String autor): Busca y muestra los libros cuyo autor coincida total o parcialmente con el texto introducido.
actualizarPrecio(int id, double nuevoPrecio): Actualiza el precio de un libro a partir de su id.
eliminarLibro(int id): Elimina un libro de la base de datos a partir de su id
Todos los métodos deberán utilizar PreparedStatement.

Crea una clase llamada Main que contenga el método main.

El programa deberá mostrar un menú por consola como el siguiente:

===== MENÚ BIBLIOTECA =====
1. Insertar libro
2. Mostrar todos los libros
3. Buscar libros por autor
4. Actualizar precio de un libro
5. Eliminar libro
0. Salir
   Elige una opción:

El menú deberá repetirse hasta que el usuario elija la opción 0.


Requisitos obligatorios
El programa debe cumplir los siguientes requisitos:

Usar JDBC para conectarse a MySQL.
Usar la clase Connection.
Usar PreparedStatement.
Usar ResultSet para mostrar datos.
Controlar posibles errores con try-catch.
Cerrar correctamente los recursos utilizados.
Pedir los datos al usuario mediante Scanner.
Organizar el código en varias clases.