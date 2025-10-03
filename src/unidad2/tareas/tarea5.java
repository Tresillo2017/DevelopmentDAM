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
    Declara una variable de tipo String que contenga tu nombre completo.
    Con la ayuda de los métodos de la clase String:
        Pinta por consola la longitud de tu nombre.
        Muestra el primer carácter de tu nombre.
        Muestra el último carácter de tu nombre.
        Indicar si vuestro nombre contiene la letra 'a'.
 */
package unidad2.tareas;

public class tarea5 {
    public static void main(String[] args) {
        String nombreCompleto = "Tomas Palma Sanchez";

        // Longitud del nombre
        int longitud = nombreCompleto.length();
        System.out.println("Longitud de mi nombre: " + longitud);

        // Primer carácter
        char primerCaracter = nombreCompleto.charAt(0);
        System.out.println("Primer carácter de mi nombre: " + primerCaracter);

        // Último carácter
        char ultimoCaracter = nombreCompleto.charAt(longitud - 1);
        System.out.println("Último carácter de mi nombre: " + ultimoCaracter);

        // Contiene la letra 'a'
        boolean contieneA = nombreCompleto.toLowerCase().contains("a");
        System.out.println("¿Mi nombre contiene la letra 'a'? " + contieneA);
    }
}
