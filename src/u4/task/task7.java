/*
 * Copyright (c) 2026.  Tomas Palma Sanchez
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
Crear una aplicación que solicite 5 nombres y los guarde en un array.

Una vez insertados todos los nombres vamos a crearnos un menú:

1) insertar otro nombre al array

2) Borrar un elemento del array indicando la posición del elemento a borrar.

3) Mostrar los elementos del array.

4) Salir.
*/
package u4.task;
import java.util.Arrays;
import java.util.Scanner;

public class task7 {
    public static void main(String[] args) {
        String[] nombres = new String[5];
        Scanner scanner = new Scanner(System.in);

        // Solicitar 5 nombres
        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce el nombre " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
        }

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1) Insertar otro nombre");
            System.out.println("2) Borrar un nombre");
            System.out.println("3) Mostrar nombres");
            System.out.println("4) Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Insertar otro nombre
                    System.out.print("Introduce el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    nombres = Arrays.copyOf(nombres, nombres.length + 1);
                    nombres[nombres.length - 1] = nuevoNombre;
                    break;
                case 2:
                    // Borrar un nombre
                    System.out.print("Introduce la posición del nombre a borrar (1-" + nombres.length + "): ");
                    int posicion = scanner.nextInt() - 1;
                    if (posicion >= 0 && posicion < nombres.length) {
                        String[] nuevosNombres = new String[nombres.length - 1];
                        for (int i = 0, j = 0; i < nombres.length; i++) {
                            if (i != posicion) {
                                nuevosNombres[j++] = nombres[i];
                            }
                        }
                        nombres = nuevosNombres;
                    } else {
                        System.out.println("Posición inválida.");
                    }
                    break;
                case 3:
                    // Mostrar nombres
                    System.out.println("Nombres:");
                    for (String nombre : nombres) {
                        System.out.println("- " + nombre);
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
