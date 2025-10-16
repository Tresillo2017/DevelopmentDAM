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
Crea una aplicación que recoja el nombre del cliente y la cantidad de artículos comprados por teclado (Utilizar la clase Scanner para recoger los datos).

Evaluar la cantidad de artículos comprados y según esto mostrar un mensaje indicando cómo deberá pagar el cliente:

        Si la cantidad es menor de 5 pagara en efectivo,
        si es mayor de 5 y menor de 12 pagara con tarjeta,
        si es mayor de 13 pagara con cheque.

**En el mensaje debemos mostrar el nombre y la cantidad introducida y cómo se debe pagar.
*/

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduce la cantidad de artículos comprados: ");
        int cantidad = 0;
        if (scanner.hasNextInt()) {
            cantidad = scanner.nextInt();
        } else {
            System.out.println("No has introducido un número válido.");
            System.exit(1);
        }

        if (cantidad < 5) {
            System.out.println(nombre + ", has comprado " + cantidad + " artículos y debes pagar en efectivo.");
        } else if (cantidad >= 5 && cantidad <= 12) {
            System.out.println(nombre + ", has comprado " + cantidad + " artículos y debes pagar con tarjeta.");
        } else if (cantidad > 12) {
            System.out.println(nombre + ", has comprado " + cantidad + " artículos y debes pagar con cheque.");
        } else {
            System.out.println("Cantidad no válida.");
        }

        scanner.close();
    }
}
