En un videoclub se pueden alquilar distintos recursos como películas, juegos o música:

Película: Código, título, número de ejemplares, director, intérpretes y genero.
Juego: Código, título, número de ejemplares, multijugador (booleano), autor.
Música: Código, título, número de ejemplares, nombre grupo musical,  año.
Aplicando el concepto de herencia, crear las clases correspondientes a los recursos.
Crear todos los métodos get/set, constructores, toString, ... que creas convenientes.

Crear un menú con las siguientes opciones:

Añadir recursos automáticamente. Se crearán varios recursos de ejemplo y se añadirán a la lista de recursos. Sólo se pueden añadir una vez a la lista.
Añadir un nuevo recurso. Se debe escoger el tipo de recurso que se desea crear y solicitar los datos necesarios para crear dicho recurso. Independientemente del recurso que sea, se debe guardar en una lista de recursos.
Mostrar recursos. Solicitar el tipo de recursos que se quiere mostrar (películas, juegos o música) y dependiendo lo que indique el usuario mostrar todos los recursos de ese tipo con toda la información bien formateada.
Dar de baja un recurso. Que solicite el código del recurso que se desea eliminar y borre de la lista el recurso indicado.
Alquilar un recurso. Se preguntará el recurso que se quiere alquilar y se restará 1 al número de ejemplares de dicho recurso. Controlar el número de ejemplares debe ser mayor de 0 para poder alquilar.
Devolver un recurso. Se preguntará el recurso que se quiere devolver y se sumará 1 al número de ejemplares de dicho recurso.
Salir.
Se tendrá muy en cuenta la creación de métodos para estructurar bien el código y el control de errores mostrando el mensaje que corresponda para que el usuario esté en todo momento informado de lo que está pasando.