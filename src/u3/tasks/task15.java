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
Crea una aplicación que solicite al usuario un número N entero NO negativo.
Una vez que tenemos el número calcule el factorial de dicho número utilizando el bucle for.

** El factorial de N (N!) es el producto de todos los números enteros positivos desde 1 hasta N.

Por ejemplo:
    5! = 5 x 4 x 3 x 2 x 1 = 120

Mostrar el resultado como en el ejemplo (con las operaciones realizadas) y añadir control de errores.
*/

package u3.tasks;

import java.util.Scanner;

public class task15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Introduce un número entero no negativo: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Eso no es un número entero. Inténtalo de nuevo: ");
                scanner.next();
            }
            numero = scanner.nextInt();
        } while (numero < 0);

        long factorial = 1;
        StringBuilder operaciones = new StringBuilder();

        for (int i = numero; i > 0; i--) {
            factorial *= i;
            operaciones.append(i);
            if (i > 1) {
                operaciones.append(" x ");
            }
        }

        System.out.println(numero + "! = " + operaciones.toString() + " = " + factorial);
    }
}
