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
Crea un programa en Java que muestre medias pirámides de números por pantalla, según la opción seleccionada por el usuario en un menú.

Pasos:

    Crea dos métodos:

        pintar1

        pintar2

    Ambos métodos:

        No devuelven ningún valor.

        Reciben como parámetro de entrada el número de filas a pintar (valor entre 1 y 9).

        Muestran una media pirámide de números, cada uno con un estilo distinto:

            pintar1: pirámide ascendente.

            pintar2: pirámide descendente.

    En el método main():

        Muestra el siguiente menú:

        ************
        Menú:
        1) Pintar 1
        2) Pintar 2
        3) Salir
        ************

        Solicita por teclado al usuario que indique el número de filas (entre 1 y 9).

        Llama al método correspondiente según la opción elegida.

        El programa se repetirá hasta que el usuario elija la opción “Salir”.


Ejemplo de salida esperada

Opción 1 – Pirámide ascendente:

Si el usuario introduce 5 filas:

1
12
123
1234
12345

Opción 2 – Pirámide descendente:

Si el usuario introduce 5 filas:

12345
1234
123
12
1

Ayuda:

    Usa bucles for anidados para controlar filas y columnas.

    Asegúrate de validar que el número de filas esté entre 1 y 9 antes de pintar.

    Usa Scanner para leer los datos del usuario.*/
package u3.tasks;

public class task20 {
    public static void pintar1(int filas) {
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void pintar2(int filas) {
        for (int i = filas; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int opcion;
        do {
            System.out.println("************");
            System.out.println("Menú:");
            System.out.println("1) Pintar 1");
            System.out.println("2) Pintar 2");
            System.out.println("3) Salir");
            System.out.println("************");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1 || opcion == 2) {
                int filas;
                do {
                    System.out.print("Introduce el número de filas (1-9): ");
                    filas = scanner.nextInt();
                } while (filas < 1 || filas > 9);

                if (opcion == 1) {
                    pintar1(filas);
                } else {
                    pintar2(filas);
                }
            }
        } while (opcion != 3);
        scanner.close();
    }
}
