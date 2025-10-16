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
Pide una nota (de 0 a 10) y muestra un mensaje según el rango:

    0–4 → Suspenso
    5 → Aprobado
    6 → Bien
    7–8 → Notable
    9–10 → Sobresaliente

El mensaje mostrará la nota introducida por el usuario y su calificación dependiendo de ésta.
Controlar los errores de forma que si introduce una nota no válida muestre también un mensaje de error indicándolo.
 */

package u3.tasks;

import java.util.Scanner;

public class task3 {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nota = 0;

        System.out.print("Introduce una nota (0-10): ");
        if (!sc.hasNextInt()) {
            System.out.println("No has introducido un número válido.");
            System.exit(1);
        }
        nota = sc.nextInt();

        if (nota <= 4) {
            System.out.println("Has suspendido con un " + nota);
        } else if (nota == 5) {
            System.out.println("Has aprobado con un " + nota);
        } else if (nota == 6) {
            System.out.println("Has sacado un bien con un " + nota);
        } else if (nota >= 7 && nota <= 8) {
            System.out.println("Has sacado un notable con un " + nota);
        } else if (nota >= 9 && nota <= 10) {
            System.out.println("Has sacado un sobresaliente con un " + nota);
        } else {
            System.out.println("Nota no válida.");
        }
    }
}
