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
Crear el método “esPerfecto”:

Un número perfecto es un número entero positivo que es igual a la suma de sus divisores propios positivos (excluyendo el número mismo). Por ejemplo, el número 6 es perfecto porque sus divisores son 1, 2 y 3, y la suma de estos es 1 + 2 + 3 = 6. Es decir, la suma coincide con el número.

Pasos a seguir:

1. Declarar el método: El método esPerfecto debe tener como parámetro de entrada un número entero (el número entero que vamos a verificar) y devolverá un valor booleano (true si el número es perfecto, false si no lo es).

2. Sumar divisores: Usaremos un bucle para encontrar todos los divisores del número que son menores que él. Iremos sumando todos los números que sean divisores.

** Recordad que los divisores son los números que al dividirlos por el número indicado el resto da 0.

3. Comparar la suma de los divisores con el número: Si la suma de los divisores propios es igual al número especificado, entonces el número es perfecto.

Desde el método main solicitaremos un número por teclado y utilizaremos el método esPerfecto para saber si el número introducido por el usuario es perfecto o no. Mostrar por consola el número introducido diciendo si es o no perfecto.

Seguiremos solicitando números y diciendo si son perfectos o no hasta que se introduzca un número NO perfecto.
*/
package u3.tasks;

import java.util.Scanner;

public class repex1 {

    public static boolean esperfecto(int numero) {
        int suma = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        if (suma == numero) {
            System.out.println("El número " + numero + " es perfecto.");
        } else {
            System.out.println("El número " + numero + " no es perfecto.");
        }
        return suma == numero;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numer;
        do {
            System.out.print("Introduce un número entero positivo: ");
            numer = scanner.nextInt();
            esperfecto(numer);
        } while (numer > 0 && (numer == 6 || numer == 28 || numer == 496 || numer == 8128)); // Números perfectos conocidos
        scanner.close();
    }
}
