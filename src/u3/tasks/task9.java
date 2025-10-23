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
Tarea estaciones con bucles (Tarea 4).  Utilizando el bucle "while" hacer que se repita hasta que introduzca "Invierno".

**Recuerda que para comparar cadenas de caracteres utilizamos el método equalsIgnoreCase()
** La tarea 4 tiene un switch..case donde mostramos un mensaje distinto dependiendo de la estación seleccionada.
*/

package u3.tasks;

import java.util.Scanner;

public class task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String estacion = "";
        while (!estacion.equalsIgnoreCase("Invierno")) {
            System.out.print("Introduce una estación: ");
            estacion = scanner.nextLine();
            switch (estacion.toLowerCase()) {
                case "primavera":
                    System.out.println("La primavera ha llegado.");
                    break;
                case "verano":
                    System.out.println("El verano está aquí.");
                    break;
                case "otoño":
                    System.out.println("El otoño ha comenzado.");
                    break;
                case "invierno":
                    System.out.println("El invierno ha llegado.");
                    break;
                default:
                    System.out.println("Estación no reconocida.");
            }
        }
    }
}
