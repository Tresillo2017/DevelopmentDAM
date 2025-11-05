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

package u3.examples;

import java.util.Scanner;

public class examplemethods {

    public static int sumar(int a, int b) {
        int resultado = a + b;
        return resultado;
    }

    /*
    Metodo para sumar dos numeros enteros que solicitara por scanner los numeros,
    los sumara y devolvera el resultado.
    @return
    */
    public static int sumarConScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el primer numero: ");
        int a = scanner.nextInt();
        System.out.print("Introduce el segundo numero: ");
        int b = scanner.nextInt();
        int resultado = a + b;
        scanner.close();
        return resultado;
    }

    public static void main(String[] args) {
        int suma1 = sumar(5, 10);
        System.out.println("La suma de 5 y 10 es: " + suma1);

        int suma2 = sumarConScanner();
        System.out.println("La suma introducida es: " + suma2);
    }

}
