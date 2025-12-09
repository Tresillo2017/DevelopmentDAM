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


Crear una calculadora:

Para hacer esto tenemos que hacer una aplicación que de las opciones de sumar, restar, multiplicar, dividir, calcular raiz cuadrada,... y la última opción que sea apagar (cuando se seleccione esa opción finalizaremos la aplicación).

Para cada operación nos crearemos un método que realice la operación solicitada.

** Utiliza el bloque try catch para tratar las excepciones.

*/

package u3.tasks;

import java.util.Scanner;

public class task25 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            try {
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (option) {
                    case 1:
                        add();
                        break;
                    case 2:
                        subtract();
                        break;
                    case 3:
                        multiply();
                        break;
                    case 4:
                        divide();
                        break;
                    case 5:
                        squareRoot();
                        break;
                    case 6:
                        power();
                        break;
                    case 7:
                        System.out.println("¡Apagando la calculadora!");
                        running = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida. Por favor, introduce un número.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n========== CALCULADORA ==========");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Raíz cuadrada");
        System.out.println("6. Potencia");
        System.out.println("7. Apagar");
        System.out.print("Selecciona una opción: ");
    }

    private static void add() {
        try {
            System.out.print("Introduce el primer número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Introduce el segundo número: ");
            double num2 = scanner.nextDouble();
            double result = num1 + num2;
            System.out.println("Resultado: " + num1 + " + " + num2 + " = " + result);
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida.");
            scanner.nextLine();
        }
    }

    private static void subtract() {
        try {
            System.out.print("Introduce el primer número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Introduce el segundo número: ");
            double num2 = scanner.nextDouble();
            double result = num1 - num2;
            System.out.println("Resultado: " + num1 + " - " + num2 + " = " + result);
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida.");
            scanner.nextLine();
        }
    }

    private static void multiply() {
        try {
            System.out.print("Introduce el primer número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Introduce el segundo número: ");
            double num2 = scanner.nextDouble();
            double result = num1 * num2;
            System.out.println("Resultado: " + num1 + " * " + num2 + " = " + result);
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida.");
            scanner.nextLine();
        }
    }

    private static void divide() {
        try {
            System.out.print("Introduce el dividendo: ");
            double num1 = scanner.nextDouble();
            System.out.print("Introduce el divisor: ");
            double num2 = scanner.nextDouble();

            if (num2 == 0) {
                System.out.println("Error: No se puede dividir entre cero.");
                return;
            }

            double result = num1 / num2;
            System.out.println("Resultado: " + num1 + " / " + num2 + " = " + result);
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida.");
            scanner.nextLine();
        }
    }

    private static void squareRoot() {
        try {
            System.out.print("Introduce el número: ");
            double num = scanner.nextDouble();

            if (num < 0) {
                System.out.println("Error: No se puede calcular la raíz cuadrada de un número negativo.");
                return;
            }

            double result = Math.sqrt(num);
            System.out.println("Resultado: √" + num + " = " + result);
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida.");
            scanner.nextLine();
        }
    }

    private static void power() {
        try {
            System.out.print("Introduce la base: ");
            double base = scanner.nextDouble();
            System.out.print("Introduce el exponente: ");
            double exponent = scanner.nextDouble();
            double result = Math.pow(base, exponent);
            System.out.println("Resultado: " + base + "^" + exponent + " = " + result);
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida.");
            scanner.nextLine();
        }
    }
}
