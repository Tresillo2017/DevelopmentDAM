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
Hacer un programa que lea 10 números y que diga si se ha introducido algún número negativo.
Al finalizar tendrá que decir la cantidad de números negativos introducidos y mostrarlos.
*/

package u3.tasks;

import java.util.Scanner;

public class task8 {
    public static void main(String[] args) {
        int negative = 0;
        String negatives = "";
        Scanner scanner = new Scanner(System.in);
        int i = 0;
            while (i < 10) {
                System.out.print("Introduce un número: ");
                int num = scanner.nextInt();
                if (num < 0) {
                    negative++;
                    negatives += num + " ";
                }
                i++;
            }
            System.out.println("Se han introducido " + negative + " números negativos.");
            System.out.println("Números negativos introducidos: " + negatives);
    }
}
