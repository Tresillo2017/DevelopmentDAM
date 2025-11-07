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
Crea un programa en Java que tenga un método llamado "calcularAreaCirculo". Este método debe recibir como parámetro de entrada el radio de un círculo (un número de tipo double) y devolver el área del círculo (también un número de tipo double). La fórmula para calcular el área de un círculo es:
display style stack text end text with on top text Area end text equals pi cross times text radio end text squared

Usa el valor de la constante PI de la clase Math para representar π (pi) en el cálculo.

Desde el método main debemos invocar al método "calcularAreaCirculo" y pintar lo que nos devuelve el método.

Hacer un bucle en el main que solicite 5 radios y vaya mostrando el área para cada uno de los radios recogidos.
*/
package u3.tasks;

public class task17 {
    public static void main(String[] args) {
        double[] radios = {3.0, 5.5, 7.2, 10.0, 12.5};

        for (double radio : radios) {
            double area = calcularAreaCirculo(radio);
            System.out.println("El área del círculo con radio " + radio + " es: " + area);
        }
    }

    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
}
