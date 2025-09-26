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

package unidad2.ejemplos;

public class ejemplovariables {

    public static void main(String[] args) {
        int numVacaciones; // Declaración de variable (siempre en minusculas)
        numVacaciones = 5; // Asignación de valor

        System.out.println("Días de vacaciones: " + numVacaciones);

        String saludo;
        saludo = "Hola";
        System.out.println(saludo);

        int edad = 18;
        System.out.println("Edad: " + edad);

        final double IVA = 0.21; // Constante (siempre en mayusculas) no se puede inicializar dos veces
        // IVA = 0.10; // Error: no se puede cambiar el valor de una constante
        System.out.println("IVA: " + IVA);

    }
}
