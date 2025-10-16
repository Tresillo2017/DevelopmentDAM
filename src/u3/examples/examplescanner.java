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

public class examplescanner {
    public static void  main(String[] args) {
        Scanner sctxt = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int edad = 0;

        System.out.print("Introduce tu edad: ");
        if (!sc.hasNextInt()) {
            System.out.println("No has introducido un número");
            System.exit(1);
        }
        edad = sc.nextInt();
        System.out.println("Tu edad es: " + edad);

        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }

        System.out.print("Introduce tu nombre: ");
        if (sctxt.hasNextLine()) {
            System.out.println("No has introducido un texto");
            System.exit(1);
        }
        String nombre = sctxt.nextLine();
        System.out.println("Tu nombre es: " + nombre);

    }
}
