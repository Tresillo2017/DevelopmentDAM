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
Crear una aplicación que muestre el perímetro de un circulo.

              Perímetro Círculo = 2 * PI * radio

Para esto:

- 1º Lo primero que tendrás que hacer es solicitar al usuario un número para saber radio.
- 2º El número recogido debe ser mayor que 0. Si el número introducido por el usuario es menor o igual que cero volver a solicitarlo hasta que el usuario introduzca un número válido.
- 3º Hacer el cálculo.
- 4º Mostrar el resultado.
*/
package u3.tasks;

import java.util.Scanner;

public class task10 {
    public static void  main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radio = 0;

        // 1º y 2º Solicitar el radio y validar que sea mayor que 0
        do {
            System.out.print("Introduce el radio del círculo (mayor que 0): ");
            radio = scanner.nextDouble();
            if (radio <= 0) {
                System.out.println("El radio debe ser mayor que 0. Por favor, inténtalo de nuevo.");
            }
        } while (radio <= 0);

        // 3º Calcular el perímetro
        double perimetro = 2 * Math.PI * radio;

        // 4º Mostrar el resultado
        System.out.printf("El perímetro del círculo con radio %.2f es: %.2f%n", radio, perimetro);

        scanner.close();
    }
}
