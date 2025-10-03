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
        Realizar un programa en Java que calcule el área del cuadrado y el del círculo. Mostrar los resultados por consola.
        Declara una variable lado con el valor 10 y otra variable radio con el valor 3,2 que serán las que utilizaremos para hacer los cálculos.
        Una vez declaradas las variables utilízalas para obtener el calculo de las áreas.
              Área cuadrado = lado * lado = lado2
              Área círculo = PI * radio2
        Utilizar la función POW de la clase Math.
 */
package unidad2.tareas;

public class tarea4 {
    public static void main(String[] args) {

        int lado = 10;
        float radio = 3.2f;

        // Area cuadrado
        double areacuadrado = Math.pow(lado, 2);
        System.out.println("Area Cuadrado: " + areacuadrado);

        // Area circulo
        double areacirculo = Math.PI * Math.pow(radio, 2);
        System.out.println("Area Circulo: " + areacirculo);
    }
}
