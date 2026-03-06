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

package u6.tasks.taskre3;

import java.util.Scanner;

/**
 * Clase Principal que gestiona la aplicación de procesiones
 * Contiene el menú principal y la lógica de interacción con el usuario
 */
public class Principal {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializar las procesiones predefinidas
        Procesion.inicializarProcesiones();

        // Mostrar mensaje de bienvenida
        mostrarBienvenida();

        // Bucle principal del menú
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();
            continuar = procesarOpcion(opcion);
        }

        // Cerrar el scanner
        scanner.close();
    }

    /**
     * Muestra el mensaje de bienvenida
     */
    private static void mostrarBienvenida() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║    GESTIÓN DE PROCESIONES DE SEMANA SANTA 2025            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
    }

    /**
     * Muestra el menú de opciones
     */
    private static void mostrarMenu() {
        System.out.println("\n┌────────────────────────────────────────────────────────────┐");
        System.out.println("│                    MENÚ PRINCIPAL                         │");
        System.out.println("├────────────────────────────────────────────────────────────┤");
        System.out.println("│ 1. Mostrar procesiones                                     │");
        System.out.println("│ 2. Agregar participante                                    │");
        System.out.println("│ 3. Mostrar participantes por rol                           │");
        System.out.println("│ 4. Salir                                                   │");
        System.out.println("└────────────────────────────────────────────────────────────┘");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Lee la opción del usuario con control de errores
     */
    private static int leerOpcion() {
        try {
            int opcion = Integer.parseInt(scanner.nextLine());
            return opcion;
        } catch (NumberFormatException e) {
            return -1; // Opción inválida
        }
    }

    /**
     * Procesa la opción seleccionada por el usuario
     * @return true si debe continuar el programa, false si debe terminar
     */
    private static boolean procesarOpcion(int opcion) {
        System.out.println(); // Línea en blanco para mejor legibilidad

        switch (opcion) {
            case 1:
                mostrarProcesiones();
                break;
            case 2:
                agregarParticipante();
                break;
            case 3:
                mostrarParticipantesPorRol();
                break;
            case 4:
                mostrarDespedida();
                return false;
            default:
                System.out.println("❌ Opción inválida. Por favor, seleccione una opción del 1 al 4.");
                break;
        }

        return true;
    }

    /**
     * Opción 1: Mostrar todas las procesiones
     * Recorre el array procesiones2025 y muestra información de cada procesión
     */
    private static void mostrarProcesiones() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            LISTADO DE PROCESIONES");
        System.out.println("═══════════════════════════════════════════════════════════");

        Procesion[] procesiones = Procesion.getProcesiones2025();

        if (procesiones == null || procesiones.length == 0) {
            System.out.println("❌ No hay procesiones disponibles.");
        } else {
            for (int i = 0; i < procesiones.length; i++) {
                System.out.println("\n[Procesión " + (i + 1) + "]");
                procesiones[i].mostrarProcesion();
            }
        }
    }

    /**
     * Opción 2: Agregar participante a una procesión
     * Solicita el nombre de la procesión y busca en el array procesiones2025
     */
    private static void agregarParticipante() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            AGREGAR PARTICIPANTE");
        System.out.println("═══════════════════════════════════════════════════════════");

        try {
            System.out.print("Ingrese el nombre de la procesión: ");
            String nombreProcesion = scanner.nextLine();

            // Buscar la procesión por nombre
            Procesion procesionEncontrada = Procesion.buscarProcesionPorNombre(nombreProcesion);

            if (procesionEncontrada == null) {
                System.out.println("❌ No se encontró una procesión con el nombre \"" + nombreProcesion + "\".");
                System.out.println("   Procesiones disponibles:");
                Procesion[] procesiones = Procesion.getProcesiones2025();
                for (Procesion p : procesiones) {
                    System.out.println("   • " + p.getNombre());
                }
            } else {
                // Invocar el método agregarParticipante de la procesión
                procesionEncontrada.agregarParticipante(scanner);
            }

        } catch (Exception e) {
            System.out.println("❌ Error al procesar la solicitud: " + e.getMessage());
        }
    }

    /**
     * Opción 3: Mostrar participantes por rol
     * Solicita el día de la procesión y el rol para mostrar los participantes
     */
    private static void mostrarParticipantesPorRol() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            MOSTRAR PARTICIPANTES POR ROL");
        System.out.println("═══════════════════════════════════════════════════════════");

        try {
            System.out.print("Ingrese el día de la procesión: ");
            String dia = scanner.nextLine();

            // Buscar la procesión por día
            Procesion procesionEncontrada = Procesion.buscarProcesionPorDia(dia);

            if (procesionEncontrada == null) {
                System.out.println("❌ No se encontró una procesión para el día \"" + dia + "\".");
                System.out.println("   Días disponibles:");
                Procesion[] procesiones = Procesion.getProcesiones2025();
                for (Procesion p : procesiones) {
                    System.out.println("   • " + p.getDia());
                }
            } else {
                // Solicitar el rol
                System.out.print("Ingrese el rol a buscar: ");
                String rol = scanner.nextLine();

                // Mostrar los participantes con ese rol
                System.out.println();
                procesionEncontrada.mostrarParticipantes(rol);
            }

        } catch (Exception e) {
            System.out.println("❌ Error al procesar la solicitud: " + e.getMessage());
        }
    }

    /**
     * Opción 4: Mostrar mensaje de despedida
     */
    private static void mostrarDespedida() {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║  ¡Gracias por usar la Gestión de Procesiones!            ║");
        System.out.println("║  ¡Que disfrutes de Semana Santa!                          ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }
}


