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
Crea un programa en Java que genere una contraseña de forma automática a partir de varios nombres de frutas introducidos por el usuario.

Pasos:

    Crea un método llamado crearContrasenya() que devuelva un String con la contraseña generada.

    Dentro del método:

        Solicita al usuario 5 nombres de frutas mediante teclado.

        De cada fruta introducida, toma los dos primeros caracteres.

        Une esos fragmentos para formar una contraseña final.

    Desde el método main(), invoca al método crearContrasenya() y muestra por pantalla la contraseña generada.
    Implementar control de errores
*/
package u3.tasks;

import java.util.Scanner;

public class task19 {
    public static String crearContrasenya(Scanner scanner) {
        StringBuilder contrasenya = new StringBuilder();
        int frutasValidas = 0;
        while (frutasValidas < 5) {
            System.out.print("Introduce el nombre de una fruta (" + (frutasValidas + 1) + "/5): ");
            if (!scanner.hasNext()) {
                System.out.println("No se recibió entrada. Saliendo.");
                System.exit(1);
            }
            String fruta = scanner.nextLine().trim();
            // Validar que no esté vacía
            if (fruta.isEmpty()) {
                System.out.println("Error: El nombre de la fruta no puede estar vacío. Inténtalo de nuevo.");
                continue;
            }
            // Validar que solo contenga letras
            if (!fruta.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
                System.out.println("Error: El nombre de la fruta solo puede contener letras. Inténtalo de nuevo.");
                continue;
            }
            // Validar que tenga al menos 2 caracteres
            if (fruta.length() < 2) {
                System.out.println("Error: El nombre de la fruta debe tener al menos 2 caracteres. Inténtalo de nuevo.");
                continue;
            }
            // Si llegamos aquí, la fruta es válida
            contrasenya.append(fruta.substring(0, 2).toLowerCase());
            frutasValidas++;
        }
        return contrasenya.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String contrasenyaGenerada = crearContrasenya(scanner);
            System.out.println("La contraseña generada es: " + contrasenyaGenerada);
        }
    }
}
