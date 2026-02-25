Se desea crear una aplicación que permita representar grupos musicales y sus componentes.

Crear una clase llamada Musico con los siguientes atributos privados:

    nombre (String) → Nombre del músico.

    edad (int) → Edad del músico.

    puesto (String) → Rol dentro del grupo (ejemplo: vocalista, guitarrista, baterista, bajista, etc.).

La clase debe incluir:

    Constructor con todos los parámetros.

    Métodos getters y setters para cada atributo.

    Método toString() que devuelva la información del músico en formato legible.

Crear una clase llamada GrupoMusical con los siguientes atributos privados:

    nombreGrupo (String) → Nombre del grupo musical.

    componentes (Array de objetos Musico) → Músicos que forman el grupo.

    web (String) → Página web oficial del grupo.

    anyoCreacion (int) → Año de creación del grupo.

La clase debe incluir:

    Constructor con todos los parámetros.

    Otro constructor que pase por parámetro el nombre del grupo y la web. El año de creación se inicializará con el año actual y los componentes los inicializaremos con un array vacío.

    Métodos getters y setters.

    Método toString() que muestre toda la información del grupo, incluyendo los datos de sus componentes.

En la clase Principal (dentro del método main):

    Crear varios objetos de tipo Musico con datos ficticios.

    Crear dos grupos musicales distintos, asignando a cada uno sus correspondientes músicos.

    Almacenar los dos grupos musicales en un array de objetos GrupoMusical llamado listaGrupos.

    Mostrar por consola la información completa de los grupos almacenados en el array.
