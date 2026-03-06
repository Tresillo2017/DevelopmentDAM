Aplicación Películas

Crear una aplicación en Java utilizando Programación Orientada a Objetos que permita gestionar una colección de películas. El objetivo es aplicar conceptos como clases, objetos, atributos, métodos, ArrayList, encapsulamiento, control de errores, bucles y condiciones.
1. Clase Pelicula

Debes crear una clase Pelicula que contenga la siguiente información:

    String titulo

    String genero (Ej: Acción, Comedia, Drama, Ciencia Ficción...)

    int anyoEstreno

    double duracion (en minutos)

Desde la clase Pelicula, deberás crear un ArrayList de objetos Pelicula llamado listaPeliculas donde se almacenarán todas las películas.
Métodos requeridos:

    Constructor con todos los atributos.

    Métodos get y set para cada atributo.

    Método toString() que devuelva todos los datos de la película de forma clara y legible.

2. Clase Principal / Aplicación
   Inicialización:

   La lista de Peliculas debe iniciarse con 3 películas predefinidas (pueden tener los datos que quieras).

3. Menú (en consola)

Tu aplicación debe mostrar un menú con las siguientes opciones:

    Insertar película

        Solicita al usuario los datos de una nueva película (título, género, año de estreno, duración).

        Crea un nuevo objeto Pelicula y añádelo a la lista.

    Total de películas

        Muestra cuántas películas hay actualmente en la lista.

    Buscar por palabra clave

        Solicita una palabra.

        Busca y muestra todas las películas cuyo título contenga esa palabra (ignorando mayúsculas/minúsculas).

        Si no hay coincidencias, muestra un mensaje informativo.

    Buscar título exacto

        Solicita al usuario un título completo.

        Indica si existe una película con ese título exactamente (sin distinguir mayúsculas).

        Muestra sus datos si se encuentra, o un mensaje si no.

    Buscar por posición

        Solicita una posición (número entero).

        Muestra la película ubicada en esa posición del ArrayList.

        Si la posición no es válida, muestra un mensaje de error.

    Mostrar todas las películas

        Recorre y muestra todas las películas almacenadas en la lista, una por una.

    Fin del programa

        Muestra un mensaje de despedida y termina el programa.

**IMPORTANTE: USO DE MÉTODOS Y REUTILIZACIÓN DE MÉTODOS