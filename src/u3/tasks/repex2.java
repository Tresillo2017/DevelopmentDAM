/*
 * Copyright (c) 2025.  Tomas Palma Sanchez
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/*
Menu de Opciones: El programa presenta un menu dodne el susuario puede elegir agregar una tarea, mostrar las tareas agregadas o salir del programa
1) Agregar Tarea
2) Mostrar Tareas
3) Salir

- Agregar Tarea: Al seleccionar la opcion 1, el usuario puede ingresar la descripcion de la tarea (String longitud maxima 20char) y la duracion (un entero que indica la
                    duracion de la tarea en minutos, los valores permitidos son desde 1 a 60 minutos). Estos datos, una vez recogidos y validados se almacenaran en una variable tipo string tareas.

Siguiendo el siguiente formato, os doy un ejemplo
---------
1. Hacer ejercicios programacion - 30 minutos
2. Estudiar examen - 60 minutos
3. ...
---------

- Mostrar tareas: Al seleccionar la opcion 2, el programa muestra el numero total de tareas agregadas y el string con todas las tareas que han sido agregadas.
                    Si no se ha agregado ninguna tarea, se informa al usuario

- Salir del Programa: La opcion 3 permite al usuario salir del programa.

** Importante control de errores y codigo legible y bien estructurado
*/

package u3.tasks;

import java.util.Scanner;

public class repex2 {

    // Shared state for tasks and their count (fixes pass-by-value issue)
    private static String tareas = "";
    private static int contadorTareas = 0;

    public static void opcion1(Scanner sc) {
        sc.nextLine(); // Limpiar el buffer
        System.out.print("Introduce la descripcion de la tarea (max 20 caracteres): ");
        String descripcion = sc.nextLine();
        while (descripcion.length() > 20) {
            System.out.print("Descripcion demasiado larga. Introduce nuevamente (max 20 caracteres): ");
            descripcion = sc.nextLine();
        }

        System.out.print("Introduce la duracion de la tarea en minutos (1-60): ");
        while (!sc.hasNextInt()) {
            System.out.print("Entrada invalida. Introduce un numero (1-60): ");
            sc.next(); // descartar token no valido
        }
        int duracion = sc.nextInt();
        while (duracion < 1 || duracion > 60) {
            System.out.print("Duracion invalida. Introduce nuevamente (1-60 minutos): ");
            while (!sc.hasNextInt()) {
                System.out.print("Entrada invalida. Introduce un numero (1-60): ");
                sc.next();
            }
            duracion = sc.nextInt();
        }

        contadorTareas++;
        tareas += contadorTareas + ". " + descripcion + " - " + duracion + " minutos\n";
        System.out.println("Tarea agregada exitosamente.");
    }

    public static String mostrarTareas() {
        if (contadorTareas == 0) {
            return "No se han agregado tareas.";
        } else {
            return "Numero total de tareas: " + contadorTareas + "\n" + tareas;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu de Opciones:");
            System.out.println("1) Agregar Tarea");
            System.out.println("2) Mostrar Tareas");
            System.out.println("3) Salir");
            System.out.print("Selecciona una opcion: ");

            while (!sc.hasNextInt()) {
                System.out.print("Opcion invalida. Introduce un numero (1-3): ");
                sc.next();
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    opcion1(sc);
                    break;
                case 2:
                    System.out.println(mostrarTareas());
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion invalida. Intenta nuevamente.");
            }
        } while (opcion != 3);

        sc.close();
    }
}
