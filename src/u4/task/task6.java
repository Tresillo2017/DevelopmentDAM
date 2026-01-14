/*
 * Copyright (c) 2026.  Tomas Palma Sanchez
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
Crea un array multidimensional que almacene información sobre los personajes principales de la serie Friends.

En dicho array, cada fila deberá contener:

    El nombre del personaje

    Una breve descripción del mismo

Una vez creado el array, el programa deberá realizar las siguientes acciones:

    Recorrer el array y mostrar por pantalla, para cada personaje:

        Su nombre

        La longitud del nombre (número de caracteres)

    Solicitar al usuario que introduzca el nombre de un personaje.

        Si el nombre introducido existe en el array, se deberá mostrar por pantalla la descripción correspondiente a ese personaje.

        Si el nombre no existe, se informará al usuario mediante un mensaje adecuado.

🔹 Requisitos del ejercicio:

    Utilizar un array multidimensional.

    Recorrer el array mediante bucles.

    Comparar cadenas de texto correctamente.

    Calcular la longitud del nombre de cada personaje.

🔹 Ejemplo de salida esperada (orientativo):

Nombre: Rachel | Longitud del nombre: 6
Nombre: Ross | Longitud del nombre: 4

Introduce el nombre de un personaje: Mónica
Descripción: Chef perfeccionista y muy competitiva.
*/

package u4.task;
import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        String[][] friends = {
            {"Rachel", "Trabaja en moda y es conocida por su estilo y personalidad encantadora."},
            {"Monica", "Chef perfeccionista y muy competitiva."},
            {"Phoebe", "Músico excéntrico con un pasado interesante."},
            {"Ross", "Paleontólogo apasionado por los dinosaurios."},
            {"Chandler", "Conocido por su sentido del humor sarcástico."},
            {"Joey", "Actor en busca de éxito, amante de la comida y la diversión."}
        };

        // Mostrar nombres y longitudes
        for (int i = 0; i < friends.length; i++) {
            String nombre = friends[i][0];
            System.out.println("Nombre: " + nombre + " | Longitud del nombre: " + nombre.length());
        }

        // Solicitar nombre al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre de un personaje: ");
        String nombreBuscado = scanner.nextLine();

        // Buscar y mostrar descripción
        boolean encontrado = false;
        for (int i = 0; i < friends.length; i++) {
            if (friends[i][0].equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Descripción: " + friends[i][1]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El personaje '" + nombreBuscado + "' no existe en la lista.");
        }
    }
}
