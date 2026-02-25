Crear la clase Receta (nombre, dificultad, tiempo, descripción) y una clase Principal.

Crear una variable global misRecetas de tipo ArrayList  en la clase Receta que será donde iremos almacenando todas las recetas que se van creando.

Añadir 3 recetas con datos ficticios al array misRecetas.

Crear el método validarDificultad que le pase un String con la dificultad insertada y nos devuelva un booleano indicando si el valor es correcto. Los valores posibles son: fácil, media, difícil.

Crear el método "mostrarDetalle" que mostrará todos los datos de una receta bien formateados.

Crear método "crearReceta" para ir creando recetas. El método solicitará todos los datos necesarios para crear una receta y devolverá un objeto de tipo Receta. Se deberá validar la dificultad de la receta antes de crearla.

Crear un método "mostrarRecetas" para mostrar una lista con todas las recetas insertadas (sólo mostrará el nombre receta).

Método "buscarReceta" para buscar una receta en concreto. Solicitará el nombre de una receta y buscará en la lista la receta indicada, si la encuentra muestra todos los datos de la receta y si no un mensaje indicando que la receta no existe y si quiere o no crearla.

Crear un método "buscarPorDificultad" que le pase por parámetro la dificultad y que devuelva un String con todos los nombres de las recetas que tengan esa dificultad. El formato del string que se devuelve será los nombres de las recetas separados por comas. Y en caso de NO haber ninguna coincidencia un texto indicando "NO se ha encontrado ninguna receta con esta dificultad".

Por último crear un menú que haga uso de todos los métodos creados.

Opciones:
1) Crear Receta.
2) Mostrar Nombres Recetas.
3) Buscar receta por nombre.
4) Buscar recetas por dificultad.
5) Modificar descripción de una receta.
6) Salir.
