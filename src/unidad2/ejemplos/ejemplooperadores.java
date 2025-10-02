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

package unidad2.ejemplos;

public class ejemplooperadores {
    public static void main(String[] args) {

        // Operaciones Aritmeticas
        double num1 = 10;
        int num2 = 3;
        double resultado = 0f; // f al final indica que es float

        // Suma
        resultado = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + resultado);

        // Resta
        resultado = num1 - num2;
        System.out.println(num1 + " - " + num2 + " = " + resultado);

        // Multiplicación
        resultado = num1 * num2;
        System.out.println(num1 + " * " + num2 + " = " + resultado);

        // División
        resultado = num1 / num2;
        System.out.println(num1 + " / " + num2 + " = " + resultado);

        // Resto division
        resultado = num1 % num2;
        System.out.println(num1 + " % " + num2 + " = " + resultado);

        // Suma y asignacion
        double r = 100;
//        r = r + num1;
        r += num1;
        System.out.println(r + " += " + num1 + " = " + r);
    }
}
