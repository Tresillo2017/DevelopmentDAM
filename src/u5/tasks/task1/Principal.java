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

package u5.tasks.task1;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static ArrayList<Coche> misCoches = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Crear 4 objetos Coche (2 alquilados y 2 no alquilados)
        Coche coche1 = new Coche("1234ABC", "Rojo", true, "Ferrari", "F8", false);
        Coche coche2 = new Coche("5678DEF", "Azul", false, "BMW", "M3", true);
        Coche coche3 = new Coche("9012GHI", "Negro", true, "Audi", "RS6", true);
        Coche coche4 = new Coche("3456JKL", "Blanco", false, "Mercedes", "AMG", false);

        // Insertar los coches en el arrayList
        misCoches.add(coche1);
        misCoches.add(coche2);
        misCoches.add(coche3);
        misCoches.add(coche4);

        // Menú principal
        int opcion = -1;
        while (opcion != 0) {
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    alquilar(misCoches);
                    break;
                case 2:
                    devolver(misCoches);
                    break;
                case 3:
                    mostrarCoches();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        }

        scanner.close();
    }

    /**
     * Muestra el menú principal
     */
    private static void mostrarMenu() {
        System.out.println("\n========== GESTOR DE ALQUILER DE COCHES ==========");
        System.out.println("1. Alquilar coche");
        System.out.println("2. Devolver coche");
        System.out.println("3. Ver coches disponibles");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    /**
     * Obtiene una opción del usuario
     */
    private static int obtenerOpcion() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar el buffer
            return -1;
        }
    }

    /**
     * Método para alquilar un coche
     */
    private static void alquilar(ArrayList<Coche> coches) {
        scanner.nextLine(); // Limpiar el buffer después de nextInt()
        boolean alquilado = false;

        while (!alquilado) {
            System.out.print("Introduce la matrícula del coche a alquilar: ");
            String matricula = scanner.nextLine().trim().toUpperCase();

            Coche cocheEncontrado = buscarCochePorMatricula(coches, matricula);

            if (cocheEncontrado == null) {
                System.out.println("❌ No existe un coche con esa matrícula. Intenta de nuevo.");
            } else if (cocheEncontrado.isAlquilado()) {
                System.out.println("❌ El coche con matrícula " + matricula + " ya está alquilado. No se puede alquilar.");
            } else {
                cocheEncontrado.setAlquilado(true);
                System.out.println("✓ ¡Coche alquilado exitosamente!");
                System.out.println("  Detalles: " + cocheEncontrado.getMarca() + " " + cocheEncontrado.getModelo() + " - Matrícula: " + matricula);
                alquilado = true;
            }
        }
    }

    /**
     * Método para devolver un coche alquilado
     */
    private static void devolver(ArrayList<Coche> coches) {
        scanner.nextLine(); // Limpiar el buffer después de nextInt()
        boolean devuelto = false;

        while (!devuelto) {
            System.out.print("Introduce la matrícula del coche a devolver: ");
            String matricula = scanner.nextLine().trim().toUpperCase();

            Coche cocheEncontrado = buscarCochePorMatricula(coches, matricula);

            if (cocheEncontrado == null) {
                System.out.println("❌ No existe un coche con esa matrícula. Intenta de nuevo.");
            } else if (!cocheEncontrado.isAlquilado()) {
                System.out.println("❌ El coche con matrícula " + matricula + " no está alquilado.");
            } else {
                cocheEncontrado.setAlquilado(false);
                System.out.println("✓ ¡Coche devuelto exitosamente!");
                System.out.println("  Detalles: " + cocheEncontrado.getMarca() + " " + cocheEncontrado.getModelo() + " - Matrícula: " + matricula);
                devuelto = true;
            }
        }
    }

    /**
     * Busca un coche por matrícula
     */
    private static Coche buscarCochePorMatricula(ArrayList<Coche> coches, String matricula) {
        for (Coche coche : coches) {
            if (coche.getMatricula().equalsIgnoreCase(matricula)) {
                return coche;
            }
        }
        return null;
    }

    /**
     * Muestra todos los coches disponibles (no alquilados)
     */
    private static void mostrarCoches() {
        System.out.println("\n========== COCHES DISPONIBLES ==========");
        boolean hayDisponibles = false;

        for (Coche coche : misCoches) {
            if (!coche.isAlquilado()) {
                System.out.println(coche);
                hayDisponibles = true;
            }
        }

        if (!hayDisponibles) {
            System.out.println("No hay coches disponibles en este momento.");
        }

        System.out.println("\n========== COCHES ALQUILADOS ==========");
        boolean hayAlquilados = false;

        for (Coche coche : misCoches) {
            if (coche.isAlquilado()) {
                System.out.println(coche);
                hayAlquilados = true;
            }
        }

        if (!hayAlquilados) {
            System.out.println("No hay coches alquilados en este momento.");
        }
    }
}

