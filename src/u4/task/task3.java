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
Crear una aplicación que pida 7 valores numéricos, deben estar dentro del rango [0,100] ambos incluidos y los meta en un array. Una vez recogidos todos los valores recorra el array y muestre el más pequeño y el más grande.

Para esto:

    Crear un método obtenerNumero sin parámetros de entrada y que devuelva un número entero. En el método solicitará por consola un número comprobará que el número está dentro del rango permitido [0,100] y si es así hará un return del valor obtenido y si no mostrará mensaje de error y volverá a solicitar el número hasta que éste sea el correcto.
    Crear un método mostrarMaxMin al que se le pasará por parámetro de entrada el array con los números recogidos anteriormente. Éste método no devolverá nada, lo que hará será recorrer el array y obtener el número máximo y mínimo y los mostrará por consola.

Importante tened en cuenta el control de errores.
*/

package u4.task;

public class task3 {
    public static void main(String[] args) {
        int[] numeros = new int[7];

        for (int i = 0; i < 7; i++) {
            numeros[i] = obtenerNumero();
        }

        mostrarMaxMin(numeros);
    }

    public static int obtenerNumero() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int numero;

        while (true) {
            System.out.print("Introduce un número entre 0 y 100: ");
            numero = scanner.nextInt();

            if (numero >= 0 && numero <= 100) {
                return numero;
            } else {
                System.out.println("Número fuera de rango. Inténtalo de nuevo.");
            }
        }
    }

    public static void mostrarMaxMin(int[] numeros) {
        int max = numeros[0];
        int min = numeros[0];

        for (int num : numeros) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        System.out.println("Número máximo: " + max);
        System.out.println("Número mínimo: " + min);
    }
}
