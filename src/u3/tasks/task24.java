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
Realiza una aplicación que nos pida un número de ventas a introducir.

Una vez recogido nos pedirá el precio de cada una de esas ventas por teclado.

Al final mostrara la suma del precio de todas las ventas. Piensa que es lo que se repite y lo que no.

** Utiliza el bloque try catch para tratar las excepciones.
*/

package u3.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0;
        try {
            System.out.print("Introduce el número de ventas: ");
            int numVentas = scanner.nextInt();
            for (int i = 1; i <= numVentas; i++) {
                System.out.print("Introduce el precio de la venta " + i + ": ");
                double precio = scanner.nextDouble();
                total += precio;
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida. Por favor, introduce un número.");
        } finally {
            scanner.close();
        }
        System.out.println("La suma total de las ventas es: " + total);
    }
}
