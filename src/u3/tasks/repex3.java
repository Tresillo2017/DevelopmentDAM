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
Crea un programa en Java que permita al usuario elegir entre dos operaciones mediante un menú:

    Calcular el factorial de un número.

    Mostrar los números del 1 al N.

    Salir.

Crear un método para calcular el factorial y que pinte el resultado (no devuelve nada). Se le pasará por parámetro al método el número sobre el que calcular el factorial.

Crear otro método para la opción 2 (mostrarNumeros).

Usar bucles, métodos y control de errores.
*/

package u3.tasks;

import java.util.Scanner;

public class repex3 {

    public static int factorial(int numero) {
        int resultado = 1;
        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static int mostrarNumeros(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
        return n;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu de Opciones:");
            System.out.println("1) Calcular el factorial de un número");
            System.out.println("2) Mostrar los números del 1 al N");
            System.out.println("3) Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce un número para calcular su factorial: ");
                    int numFactorial = sc.nextInt();
                    if (numFactorial < 0) {
                        System.out.println("El factorial no está definido para números negativos.");
                    } else {
                        int resultadoFactorial = factorial(numFactorial);
                        System.out.println("El factorial de " + numFactorial + " es: " + resultadoFactorial);
                    }
                    break;
                case 2:
                    System.out.print("Introduce un número N para mostrar los números del 1 al N: ");
                    int n = sc.nextInt();
                    if (n < 1) {
                        System.out.println("Por favor, introduce un número mayor o igual a 1.");
                    } else {
                        mostrarNumeros(n);
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del 1 al 3.");
            }
        } while (opcion != 3);

        sc.close();
    }
}
