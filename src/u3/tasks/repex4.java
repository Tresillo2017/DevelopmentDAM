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
Crear una calculadora con las operaciones de suma, resta, multiplicación, división y resto.

Para esto tendréis que crear un menú que solicite la operación a realizar y dependiendo de la que sea solicitar los números necesarios para llevarla a cabo.

Se debe pintar por consola la operación completa con el resultado.

Importante: control de errores.
Crear los métodos que consideréis necesarios para que el código quede refactorizado.
*/

package u3.tasks;

import java.util.Scanner;

public class repex4 {

    public static int suma(int a, int b) {
        return a + b;
    }

    public static int resta(int a, int b) {
        return a - b;
    }

    public static int multiplicacion(int a, int b) {
        return a * b;
    }

    public static double division(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        return (double) a / b;
    }

    public static int resto(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede calcular el resto con divisor cero.");
        }
        return a % b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu de Operaciones:");
            System.out.println("1) Suma");
            System.out.println("2) Resta");
            System.out.println("3) Multiplicación");
            System.out.println("4) División");
            System.out.println("5) Resto");
            System.out.println("6) Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 5) {
                System.out.print("Introduce el primer número: ");
                int num1 = sc.nextInt();
                System.out.print("Introduce el segundo número: ");
                int num2 = sc.nextInt();

                try {
                    switch (opcion) {
                        case 1:
                            System.out.println("Resultado: " + num1 + " + " + num2 + " = " + suma(num1, num2));
                            break;
                        case 2:
                            System.out.println("Resultado: " + num1 + " - " + num2 + " = " + resta(num1, num2));
                            break;
                        case 3:
                            System.out.println("Resultado: " + num1 + " * " + num2 + " = " + multiplicacion(num1, num2));
                            break;
                        case 4:
                            System.out.println("Resultado: " + num1 + " / " + num2 + " = " + division(num1, num2));
                            break;
                        case 5:
                            System.out.println("Resultado: " + num1 + " % " + num2 + " = " + resto(num1, num2));
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcion != 6) {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (opcion != 6);
    }
}
