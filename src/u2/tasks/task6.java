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
Declara 3 variables de tipo entero a, b y c con los valores 10, 20 y 30 respectivamente.
Realiza las siguientes operaciones y muestra el resultado por consola de cada una de ellas:
    Comprueba si la variable a es igual a c y distinta de b.
    Comprueba si b es mayor que a o c es menor que a.
    Niega la expresión anterior.
*/
package u2.tasks;

public class task6 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;

        // Comprueba si la variable a es igual a c y distinta de b.
        boolean condicion1 = (a == c) && (a != b);
        System.out.println("(" + a + " == " + c + ") && (" + a + " != " + b + ") = " + condicion1);

        // Comprueba si b es mayor que a o c es menor que a.
        boolean condicion2 = (b > a) || (c < a);
        System.out.println("(" + b + " > " + a + ") || (" + c + " < " + a + ") = " + condicion2);

        // Niega la expresión anterior.
        boolean condicion3 = !condicion2;
        System.out.println("!(" + "(" + b + " > " + a + ") || (" + c + " < " + a + ")) = " + condicion3);

    }
}
