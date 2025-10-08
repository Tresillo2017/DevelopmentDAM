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
Declara tres variables de tipo booleano: esAlumno, tieneBeca y esExtranjero.
Asígnales un valor (el que tu quieras).
Utilizando el método println() pinta por consola si cumple la condición de matrícula gratuita:

<< ser alumno y (tener beca o ser extranjero) >>
*/
package u2.tasks;

public class task7 {
    public static void main(String[] args) {
        boolean esAlumno = true;
        boolean tieneBeca = false;
        boolean esExtranjero = true;
        int edad = 18;

        boolean matriculaGratuita = esAlumno && (tieneBeca || esExtranjero);
        System.out.println("¿Cumple la condición de matrícula gratuita? " + matriculaGratuita);

        // Parking fratis si esAlumno y no tiene beca
        boolean parkingGratis = esAlumno && !tieneBeca;
        System.out.println("¿Cumple la condición de parking gratuito? " + parkingGratis);

        // Con comedor gratis si no tiene beca o tiene entre 18 y 30 años
        boolean comedorGratis = !tieneBeca || (edad >= 18 && edad <= 30);
        System.out.println("¿Cumple la condición de comedor gratuito? " + comedorGratis);
    }
}
