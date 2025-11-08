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
    public static int obtenerNumero(Scanner scanner, int min, int max) {
        while (true) {
            System.out.print("Introduce un número entre " + min + " y " + max + ": ");
            if (!scanner.hasNext()) {
                System.out.println("No se recibió entrada. Saliendo.");
                System.exit(1);
            }
            if (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                scanner.nextLine(); // consumir el resto de la línea
                if (numero >= min && numero <= max) {
                    return numero;
                }
                System.out.println("Número fuera de rango. Inténtalo de nuevo.");
            } else {
                // no es un entero: consumir la línea completa y avisar
                scanner.nextLine();
                System.out.println("Entrada inválida. Debes introducir un número entero.");
            }
        }
    }

    public static void main(String[] args) {
        int suma = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < 5; i++) {
                int numero = obtenerNumero(scanner, 100, 999);
                suma += numero;
            }
            System.out.println("La suma de los 5 números obtenidos es: " + suma);
        }
    }
}
