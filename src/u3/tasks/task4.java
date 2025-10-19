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
Crear un programa que solicite por teclado la estación del año favorita del usuario y le muestre según la opción seleccionada un mensaje u otro.

** Hacer dos versiones, una utilizando if y otra utilizando switch...case.
*/

package u3.tasks;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su estación del año favorita (primavera, verano, otoño, invierno): ");
        String estacion = scanner.nextLine().toLowerCase();

        // Versión utilizando if
        if (estacion.equals("primavera")) {
            System.out.println("¡La primavera es una estación llena de flores y colores!");
        } else if (estacion.equals("verano")) {
            System.out.println("¡El verano es perfecto para disfrutar del sol y la playa!");
        } else if (estacion.equals("otoño")) {
            System.out.println("¡El otoño trae consigo hojas caídas y un clima fresco!");
        } else if (estacion.equals("invierno")) {
            System.out.println("¡El invierno es ideal para disfrutar de la nieve y el calor del hogar!");
        } else {
            System.out.println("Estación no reconocida.");
        }

        // Versión utilizando switch...case
        switch (estacion) {
            case "primavera":
                System.out.println("¡La primavera es una estación llena de flores y colores!");
                break;
            case "verano":
                System.out.println("¡El verano es perfecto para disfrutar del sol y la playa!");
                break;
            case "otoño":
                System.out.println("¡El otoño trae consigo hojas caídas y un clima fresco!");
                break;
            case "invierno":
                System.out.println("¡El invierno es ideal para disfrutar de la nieve y el calor del hogar!");
                break;
            default:
                System.out.println("Estación no reconocida.");
                break;
        }

        scanner.close();
    }
}
