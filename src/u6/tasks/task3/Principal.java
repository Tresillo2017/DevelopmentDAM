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

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Añadir 3 recetas con datos ficticios
        Receta.misRecetas.add(
            new Receta(
                "Tortilla de patatas",
                "fácil",
                "30 minutos",
                "Clásica tortilla española con patatas y huevo. Se fríen las patatas, se mezclan con huevo batido y se cuaja en la sartén."
            )
        );
        Receta.misRecetas.add(
            new Receta(
                "Paella valenciana",
                "difícil",
                "1 hora 30 minutos",
                "Arroz con pollo, conejo, judías verdes, garrofón, tomate, azafrán y aceite de oliva cocinado en paellera."
            )
        );
        Receta.misRecetas.add(
            new Receta(
                "Gazpacho andaluz",
                "media",
                "20 minutos",
                "Sopa fría a base de tomate, pepino, pimiento, ajo, pan, aceite de oliva y vinagre. Se tritura todo y se sirve bien frío."
            )
        );

        int opcion;

        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    crearReceta();
                    break;
                case 2:
                    Receta.mostrarRecetas();
                    break;
                case 3:
                    Receta.buscarReceta(scanner);
                    break;
                case 4:
                    buscarPorDificultad();
                    break;
                case 5:
                    modificarDescripcion();
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n========== GESTIÓN DE RECETAS ==========");
        System.out.println("1) Crear Receta.");
        System.out.println("2) Mostrar Nombres Recetas.");
        System.out.println("3) Buscar receta por nombre.");
        System.out.println("4) Buscar recetas por dificultad.");
        System.out.println("5) Modificar descripción de una receta.");
        System.out.println("6) Salir.");
        System.out.println("=========================================");
    }

    private static void crearReceta() {
        Receta.crearReceta(scanner);
    }

    private static void buscarPorDificultad() {
        System.out.print("Introduce la dificultad (fácil, media, difícil): ");
        String dificultad = scanner.nextLine();

        if (!Receta.validarDificultad(dificultad)) {
            System.out.println(
                "Dificultad no válida. Los valores posibles son: fácil, media, difícil."
            );
            return;
        }

        String resultado = Receta.buscarPorDificultad(dificultad);
        System.out.println(
            "Recetas con dificultad '" + dificultad + "': " + resultado
        );
    }

    private static void modificarDescripcion() {
        System.out.print("Introduce el nombre de la receta a modificar: ");
        String nombre = scanner.nextLine();

        // Buscar la receta en la lista
        Receta recetaEncontrada = null;
        for (int i = 0; i < Receta.misRecetas.size(); i++) {
            if (Receta.misRecetas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                recetaEncontrada = Receta.misRecetas.get(i);
                break;
            }
        }

        if (recetaEncontrada == null) {
            System.out.println("La receta '" + nombre + "' no existe.");
            return;
        }

        System.out.println(
            "Descripción actual: " + recetaEncontrada.getDescripcion()
        );
        System.out.print("Introduce la nueva descripción: ");
        String nuevaDescripcion = scanner.nextLine();
        recetaEncontrada.setDescripcion(nuevaDescripcion);
        System.out.println("Descripción modificada exitosamente.");
    }
}
