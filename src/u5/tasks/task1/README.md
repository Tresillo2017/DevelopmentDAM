Realizar una aplicación Java que permita gestionar coches.

Crear una clase Coche con los atributos: matrícula, color, alerones, marca, modelo y debemos de saber si está alquilado o no.

Crear mínimo un constructor por defecto, otro que le pase por parámetro la matrícula y si está o no alquilado y otro en el que se le pasen todos los parámetros.

Crear los métodos get/set para todos los atributos.

Crear otra clase, Principal donde en el método main crearemos 4 objetos Coche. Dos alquilados y otros dos no alquilados.

Insertar los coches creados en un arrayList misCoches.

Crear un método alquilar al que le pasaremos por parámetro un array de coches. El método no devolverá nada.
En el método solicitaremos una matrícula por teclado y comprobaremos si la matrícula coincide con alguna de los coches del array. Si coincide, comprobamos si el coche con dicha matrícula está o no alquilado y en caso de no estar alquilado cambiamos el estado "alquilado" y mostramos un mensaje indicándolo. En caso de estar ya alquilado mostraremos un mensaje indicando que no se puede alquilar dicho coche y volveremos a solicitar otra matrícula.

Crear un menú que de la opción de alquilar o devolver coches alquilados.