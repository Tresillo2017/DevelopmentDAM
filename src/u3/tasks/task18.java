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
Crear un método "obtenerNumero" que tenga dos parámetros de entrada de tipo entero y devuelva un valor de tipo entero.
El primer parámetro lo utilizaremos para saber el número mínimo permitido y el segundo parámetro para saber el número máximo permitido.
El método deberá solicitar por teclado un número y comprobar que el número introducido es mayor o igual que el mínimo permitido y menor o igual que el máximo permitido.
Si el número es válido retornaremos dicho número. En caso de no ser válido tendremos que volver a solicitar otro número.

Una vez implementado el método "obtenerNumero" desde el método main lo utilizaremos para crear una aplicación que solicite 5 números que sean mayores que 100 y menores que 999. Iremos sumando todos los números y al final mostraremos la suma de los 5 números obtenidos.
*/
package u3.tasks;

import java.util.Scanner;

public class task18 {
    public static int obtenerNumero(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        do {
            System.out.print("Introduce un número entre " + min + " y " + max + ": ");
            numero = scanner.nextInt();
            if (numero < min || numero > max) {
                System.out.println("Número inválido. Por favor, inténtalo de nuevo.");
            }
        } while (numero < min || numero > max);
        return numero;
    }

    public static void main(String[] args) {
        int suma = 0;
        for (int i = 0; i < 5; i++) {
            int numero = obtenerNumero(100, 999);
            suma += numero;
        }
        System.out.println("La suma de los 5 números obtenidos es: " + suma);
    }
}
