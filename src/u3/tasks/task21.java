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
Crea una aplicación en Java que trabaje con una frase introducida por el usuario y realice diversas operaciones con las palabras que la componen.

    Solicita al usuario que introduzca una frase completa (por ejemplo:
    "El sol brilla en el cielo y el cielo es azul").

    El programa debe mostrar por pantalla:

        La primera palabra de la frase.

        La última palabra de la frase.

        El número de veces que se repite una palabra específica, que también será solicitada al usuario.

    Para resolver el ejercicio, no se deben usar arrays ni colecciones.
    Solo puedes utilizar los métodos de la clase String, como:

        substring()

        indexOf()

        lastIndexOf()

        trim()

        toLowerCase()

        contains()

        length()

    La comparación de palabras no debe distinguir mayúsculas y minúsculas.

----------------------------------------------------------------------------------------------------------------------------------------

Ejemplo de ejecución:

Introduce una frase: El sol brilla en el cielo y el cielo es azul

Primera palabra: El

Última palabra: azul

Introduce la palabra que deseas contar: cielo

La palabra 'cielo' aparece 2 veces en la frase.
*/

package u3.tasks;

import java.util.Scanner;

public class task21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una frase: ");
        String frase = scanner.nextLine();

        // Obtener la primera palabra
        String primeraPalabra = frase.substring(0, frase.indexOf(" "));
        System.out.println("Primera palabra: " + primeraPalabra);

        // Obtener la última palabra
        String ultimaPalabra = frase.substring(frase.lastIndexOf(" ") + 1);
        System.out.println("Última palabra: " + ultimaPalabra);

        // Contar ocurrencias de una palabra específica
        System.out.print("Introduce la palabra que deseas contar: ");
        String palabraContar = scanner.nextLine();

        int contador = 0;
        int indice = 0;
        while ((indice = frase.toLowerCase().indexOf(palabraContar.toLowerCase(), indice)) != -1) {
            contador++;
            indice += palabraContar.length();
        }

        System.out.println("La palabra '" + palabraContar + "' aparece " + contador + " veces en la frase.");
    }

}
