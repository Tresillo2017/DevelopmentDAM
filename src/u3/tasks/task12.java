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
Crea un programa en Java que genere un número secreto entre 1 y 100 (puedes usar Math.random() para ello).
El usuario deberá intentar adivinar el número introduciendo valores por teclado.

El programa debe ir dando pistas:

    Si el número introducido es mayor que el secreto, mostrará “El número es demasiado grande”.

    Si es menor, mostrará “El número es demasiado pequeño”.

El bucle continuará mientras el usuario no adivine el número.
Cuando lo adivine, el programa mostrará un mensaje de felicitación e indicará el número de intentos realizados.
AYUDA:

    Para calcular el número secreto utilizamos la formular:
        numeroSecreto = (int) (Math.random() * 100) + 1

    Utilizar un bucle while.

    Contar el número de intentos.

    Mostrar mensajes de ayuda al usuario.

-----------------------------------------------------------------------------------------------------
Ejemplo de ejecución:

Adivina el número (entre 1 y 100): 50

El número es demasiado pequeño.

Adivina el número: 75

El número es demasiado grande.

Adivina el número: 62

¡Correcto! Has adivinado el número en 3 intentos.

------------------------------------------------------------------------------------------------------------
*/
package u3.tasks;

import java.util.Scanner;

public class task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroSecreto = (int) (Math.random() * 100) + 1;
        int intentos = 0;
        int numeroUsuario = 0;

        System.out.println("Adivina el número (entre 1 y 100): ");

        while (numeroUsuario != numeroSecreto) {
            if (scanner.hasNextInt()) {
                numeroUsuario = scanner.nextInt();
                intentos++;
                if (numeroUsuario < numeroSecreto) {
                    System.out.println("El número es demasiado pequeño. Intenta de nuevo:");
                } else if (numeroUsuario > numeroSecreto) {
                    System.out.println("El número es demasiado grande. Intenta de nuevo:");
                } else {
                    System.out.println("¡Correcto! Has adivinado el número en " + intentos + " intentos.");
                }
            } else {
                System.out.println("No has introducido un número válido.");
                scanner.next();
            }
        }

        scanner.close();
    }
}
