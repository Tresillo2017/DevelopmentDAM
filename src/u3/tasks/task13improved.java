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
Id solicitando números y sumando hasta que el número introducido sea 0.
Cuando se introduzca el 0 no seguimos pidiendo más números y mostramos el resultado de la suma.

MOSTRAR EL RESULTADO PINTANDO LOS NÚMEROS INTRODUCIDOS Y EL RESULTADO FINAL.

Por ejemplo:
2 + 5 + 100 + 20 = 127
*/

package u3.tasks;

import java.util.Scanner;

public class task13improved {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int suma = 0;
        int numero;
        StringBuilder numerosIntroducidos = new StringBuilder();

        do {
            System.out.print("Introduce un número (0 para terminar): ");
            numero = scanner.nextInt();
            if (numero != 0) {
                suma += numero;
                if (numerosIntroducidos.length() > 0) {
                    numerosIntroducidos.append(" + ");
                }
                numerosIntroducidos.append(numero);
            }
        } while (numero != 0);

        System.out.println(numerosIntroducidos.toString() + " = " + suma);
        scanner.close();
    }
}
