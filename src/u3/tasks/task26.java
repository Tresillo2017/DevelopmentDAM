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
Programa en Java una aplicación de consola que permita ir introduciendo notas de alumnos, calcular estadísticas y controlar los posibles errores de introducción de datos.

El programa debe cumplir los siguientes requisitos:
1. Menú principal (bucle)

El programa mostrará repetidamente el siguiente menú hasta que el usuario elija la opción 3:

1. Añadir nota
2. Mostrar estadísticas
3. Salir

2. Opción 1: Añadir nota

Cuando el usuario elija la opción 1, el programa debe:

    Llamar a un método llamado pedirNota que retorna un double con la nota.

    Este método debe:

        Pedir al usuario una nota.

        Utilizar try..catch para controlar que el usuario introduce un número real (double).

            Si introduce texto u otro valor no numérico, se debe mostrar un mensaje de error y volver a pedir la nota.

        Validar que la nota esté en el rango 0 a 10.

            Si está fuera de ese rango, se mostrará un mensaje de error y se volverá a pedir la nota.

        El método solo devolverá una nota cuando sea correcta.

    En el main (dentro de la opción 1), cada vez que se añada una nota correcta, se deberá actualizar estas variables (que tendrás declaradas al principio del main):

    int contadorNotas → cantidad de notas introducidas.

    double sumaNotas → suma de todas las notas.

    double notaMaxima → la nota más alta introducida.
    double notaMinima → la nota más baja introducida.


Pista: la primera vez que se introduce una nota, notaMaxima y notaMinima deberán tomar el valor de esa nota.

3. Opción 2: Mostrar estadísticas

Cuando el usuario elija la opción 2, el programa deberá:

    Comprobar si se ha introducido al menos una nota.

        Si no hay notas, mostrar el mensaje: "No hay notas registradas todavía."

    Si hay notas, debe llamar a un método calcularMedia

       Este método:

    Recibe por parámetro la suma de las notas (de tipo double) y el número de notas (de tipo int).

    Devuelve un double con la media (suma / contador).

    Después, el programa mostrará por pantalla:

    Número total de notas introducidas.

    Nota media.

    Nota máxima.

    Nota mínima.

4. Opción 3: Salir

Al elegir la opción 3, el programa:

    Mostrará un mensaje de despedida, por ejemplo:

    "Saliendo del programa. ¡Hasta pronto!"

    Terminará la ejecución.

Resumen de lo que debe incluir el programa:

    Un bucle para el menú.

    Al menos dos métodos:

        pedirNota() → usa try..catch y validación.

        calcularMedia.

    Uso de try..catch para controlar errores de entrada al pedir la nota.

    Uso de variables acumuladoras y de control:

        contadorNotas, sumaNotas, notaMaxima, notaMinima.
*/
package u3.tasks;

import java.util.Scanner;

public class task26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int contadorNotas = 0;
        double sumaNotas = 0;
        double notaMaxima = 0;
        double notaMinima = 0;

        int opcion = 0;

        while (true) {
            // Mostrar menú
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Añadir nota");
            System.out.println("2. Mostrar estadísticas");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor introduce un número válido.");
                continue;
            }

            if (opcion == 1) {
                // Opción 1: Añadir nota
                double nota = pedirNota(scanner);

                contadorNotas++;
                sumaNotas += nota;

                // Primera nota
                if (contadorNotas == 1) {
                    notaMaxima = nota;
                    notaMinima = nota;
                } else {
                    // Actualizar máxima y mínima
                    if (nota > notaMaxima) {
                        notaMaxima = nota;
                    }
                    if (nota < notaMinima) {
                        notaMinima = nota;
                    }
                }

                System.out.println("Nota añadida correctamente: " + nota);

            } else if (opcion == 2) {
                // Opción 2: Mostrar estadísticas
                if (contadorNotas == 0) {
                    System.out.println("No hay notas registradas todavía.");
                } else {
                    double media = calcularMedia(sumaNotas, contadorNotas);
                    System.out.println("\n=== ESTADÍSTICAS ===");
                    System.out.println("Número total de notas: " + contadorNotas);
                    System.out.println("Nota media: " + media);
                    System.out.println("Nota máxima: " + notaMaxima);
                    System.out.println("Nota mínima: " + notaMinima);
                }

            } else if (opcion == 3) {
                // Opción 3: Salir
                System.out.println("Saliendo del programa. ¡Hasta pronto!");
                break;

            } else {
                System.out.println("Opción inválida. Por favor elige 1, 2 o 3.");
            }
        }

        scanner.close();
    }

    public static double pedirNota(Scanner scanner) {
        double nota = -1;
        boolean notaValida = false;

        while (!notaValida) {
            System.out.print("Introduce una nota (0-10): ");

            try {
                nota = Double.parseDouble(scanner.nextLine());

                // Validar rango 0-10
                if (nota >= 0 && nota <= 10) {
                    notaValida = true;
                } else {
                    System.out.println("Error: La nota debe estar entre 0 y 10.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor introduce un número real válido.");
            }
        }

        return nota;
    }

    public static double calcularMedia(double sumaNotas, int contadorNotas) {
        return sumaNotas / contadorNotas;
    }
}
