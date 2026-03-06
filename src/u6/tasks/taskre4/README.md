Desarrollar una aplicación en Java para gestionar alumnos y las asignaturas en las que están matriculados.
Crear la clase Asignatura

Atributos:

    nombre (String)

    nota (double)

    horasSemanales (int)

Métodos:

    Constructor

    Getters y Setters

    toString()

Crear la clase Alumno

Atributos:

    nombre (String)

    edad (int)

    asignaturas (ArrayList<Asignatura>)

Métodos:

    Constructor que le pase por parámetro el nombre y la edad del alumno e inicialice el array asignaturas con la asignatura de programación con nota inicial 0 y horas semanales 7h.
    Método agregarAsignatura que le pase por parámetro una asignatura y la añada al array asignaturas.

    Método calcularMedia() → devuelve la media de las notas

    toString()

Crear un ArrayList<Alumno> misAlumnos donde almacenaremos todos los alumnos que vamos creando
Clase Main

    Crear al menos 2 alumnos con datos ficticios.

    Cada alumno debe tener al menos 3 asignaturas

    Mostrar por pantalla:

        Nombre del alumno

        Edad

        Todas sus asignaturas

        Nota media del alumno

        Media general de todos los alumnos

OBLIGATORIO

Para mostrar los datos debes usar:

    Un for para recorrer la lista de alumnos

    Dentro, otro for para recorrer la lista de asignaturas de cada alumno

Es obligatorio el uso de for anidados
Ejemplo de salida esperada

Alumno: María López
Edad: 20
Asignaturas:
- Programación | Nota: 8.5 | Horas: 7
- Bases de Datos | Nota: 7.0 | Horas: 4
- Entornos de Desarrollo | Nota: 9.0 | Horas: 3
  Media: 8.16

Alumno: Juan Pérez
Edad: 21
Asignaturas:
- Programación | Nota: 6.5 | Horas: 7
- Sistemas | Nota: 7.5 | Horas: 5
- Lenguajes de Marcas | Nota: 8.0 | Horas: 4
  Media: 7.33

Media general del grupo: 7.75

Parte EXTRA

Añadir un método que:

    Muestre la asignatura con mayor nota de todos los alumnos.

    Muestre el alumno con mayor media.

    Permita buscar un alumno por nombre.
