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
Realizar una aplicación que pida números.

1º se pedirá por teclado la cantidad de números a introducir.

2º se solicitarán tantos números como se han indicado en el paso anterior.

3º Debemos ir evaluando cada número recogido para saber si es mayor, menor o igual a 0.

Por último, una vez recogidos todos los números el programa debe informar de cuántos números introducidos son mayores que 0, cuantos son menores que 0 y cuantos son iguales a 0.
*/

package u3.tasks;

import java.util.Scanner;

public class task11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos números vas a introducir?: ");
        int cantidadNumeros = sc.nextInt();

        int mayoresQueCero = 0;
        int menoresQueCero = 0;
        int igualesACero = 0;

        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            int numero = sc.nextInt();

            if (numero > 0) {
                mayoresQueCero++;
            } else if (numero < 0) {
                menoresQueCero++;
            } else {
                igualesACero++;
            }
        }

        System.out.println("Números mayores que 0: " + mayoresQueCero);
        System.out.println("Números menores que 0: " + menoresQueCero);
        System.out.println("Números iguales a 0: " + igualesACero);
    }
}
