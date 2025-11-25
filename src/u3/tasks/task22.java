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
Crear un método "formaDePago" que  tenga como parámetros de entrada un string con el nombre del cliente, y un entero con el número de artículos comprados. El método devolverá un String indicando la forma de pago (efectivo, cheque o tarjeta).

En el método se evaluará la cantidad de artículos comprados y según esto devolverá un string indicando como deberá pagar el cliente:

        Si la cantidad es menor de 5 pagara en efectivo,
        si es mayor de 5 y menor de 12 pagara con tarjeta,
        si es mayor de 13 pagara con cheque.

Crea una aplicación que recoja el nombre del cliente y la cantidad de artículos comprados por teclado (Utilizar la clase Scanner para recoger los datos). Dichos datos los utilizaremos para invocar al método y pintaremos por consola el nombre del cliente y la forma de pago.

Hacer esto hasta que el usuario no desee introducir más clientes. Para esto deberemos preguntar al usuario si desea continuar.

**En el mensaje debemos mostrar el nombre y la cantidad introducida y cómo se debe pagar.
*/

package u3.tasks;

import java.util.Scanner;

public class task22 {
    public static String formaDePago(String cliente, int cantidadArticulos) {
        if (cantidadArticulos < 5) {
            return "efectivo";
        } else if (cantidadArticulos >= 5 && cantidadArticulos <= 12) {
            return "tarjeta";
        } else {
            return "cheque";
        }
    };

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            System.out.print("Introduce el nombre del cliente: ");
            String cliente = scanner.nextLine();

            System.out.print("Introduce la cantidad de artículos comprados: ");
            int cantidadArticulos = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            String formaPago = formaDePago(cliente, cantidadArticulos);
            System.out.println("El cliente " + cliente + " con " + cantidadArticulos + " artículos debe pagar en " + formaPago + ".");

            System.out.print("¿Desea introducir otro cliente? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        scanner.close();
    }
}
