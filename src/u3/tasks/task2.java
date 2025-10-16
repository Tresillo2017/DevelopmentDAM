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
Crear una aplicación que solicite dos valores numéricos y mostrar cual es el número mayor introducido o si son iguales (indicándolo).
 */

package u3.tasks;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;

        System.out.print("Introduce el primer número: ");
        if (!sc.hasNextInt()) {
            System.out.println("No has introducido un número");
            System.exit(1);
        }
        num1 = sc.nextInt();

        System.out.print("Introduce el segundo número: ");
        if (!sc.hasNextInt()) {
            System.out.println("No has introducido un número");
            System.exit(1);
        }
        num2 = sc.nextInt();

        if (num1 > num2) {
            System.out.println("El número mayor es: " + num1);
        } else if (num1 < num2) {
            System.out.println("El número mayor es: " + num2);
        } else {
            System.out.println("Los números son iguales.");
        }
    }
}
