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

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cuenta[] misCuentas = new Cuenta[100]; // Array para almacenar cuentas
        int numCuentas = 0; // Contador de cuentas insertadas
        int opcion;

        do {
            // Mostrar menú
            System.out.println("\n=== MENÚ DE CUENTAS ===");
            System.out.println("1) Insertar cuenta");
            System.out.println("2) Mostrar cuentas");
            System.out.println("3) Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea en blanco

            switch (opcion) {
                case 1:
                    // Insertar cuenta
                    if (numCuentas < misCuentas.length) {
                        System.out.print("Introduce el nombre del titular: ");
                        String titular = scanner.nextLine();
                        System.out.print("Introduce el saldo: ");
                        double saldo = scanner.nextDouble();
                        scanner.nextLine(); // Consumir la línea en blanco

                        misCuentas[numCuentas] = new Cuenta(titular, saldo);
                        numCuentas++;
                        System.out.println("Cuenta insertada correctamente.");
                    } else {
                        System.out.println("No hay espacio para más cuentas.");
                    }
                    break;

                case 2:
                    // Mostrar cuentas
                    if (numCuentas == 0) {
                        System.out.println("No hay cuentas para mostrar.");
                    } else {
                        System.out.println("\n=== CUENTAS REGISTRADAS ===");
                        for (int i = 0; i < numCuentas; i++) {
                            System.out.println((i + 1) + ". " + misCuentas[i]);
                        }
                    }
                    break;

                case 3:
                    // Salir
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}

