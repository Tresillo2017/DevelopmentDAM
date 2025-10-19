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
Crear una aplicación que pida por consola el nombre y edad de un usuario y luego muestre un menú con 3 opciones:

1) Nombre. Que muestre el nombre y su longitud.
2) Edad. Mostrar la edad y si es mayor de edad. En caso de que sea menor indicar cuanto le falta para llegar a la mayoría de edad.
3) Salir.
*/

package u3.tasks;

import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();

        System.out.println("Seleccione una opción:");
        System.out.println("1) Nombre");
        System.out.println("2) Edad");
        System.out.println("3) Salir");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Nombre: " + nombre);
                System.out.println("Longitud del nombre: " + nombre.length());
                break;
            case 2:
                System.out.println("Edad: " + edad);
                if (edad >= 18) {
                    System.out.println("Es mayor de edad.");
                } else {
                    System.out.println("Es menor de edad. Le faltan " + (18 - edad) + " años para llegar a la mayoría de edad.");
                }
                break;
            case 3:
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}
