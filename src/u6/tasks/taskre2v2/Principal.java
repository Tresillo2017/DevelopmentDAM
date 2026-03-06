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

package u6.tasks.taskre2v2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Principal que gestiona la aplicación de películas con actores
 * Contiene el menú principal y la lógica de interacción con el usuario
 */
public class Principal {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializar la lista con 3 películas predefinidas con actores
        Pelicula.inicializarPeliculas();

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
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║    BIENVENIDO A LA GESTIÓN DE PELÍCULAS Y ACTORES       ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
    }

    /**
     * Muestra el menú de opciones
     */
    private static void mostrarMenu() {
        System.out.println("\n┌──────────────────────────────────────────────────────────┐");
        System.out.println("│                    MENÚ PRINCIPAL                        │");
        System.out.println("├──────────────────────────────────────────────────────────┤");
        System.out.println("│ 1. Insertar película                                     │");
        System.out.println("│ 2. Total de películas                                    │");
        System.out.println("│ 3. Buscar por palabra clave                              │");
        System.out.println("│ 4. Buscar título exacto                                  │");
        System.out.println("│ 5. Buscar por posición                                   │");
        System.out.println("│ 6. Mostrar todas las películas                           │");
        System.out.println("│ 7. Fin del programa                                      │");
        System.out.println("│ 8. Mostrar títulos y actores principales                 │");
        System.out.println("│ 9. Buscar películas por actor                            │");
        System.out.println("│ 10. Mostrar actores mayores de 60 años                   │");
        System.out.println("└──────────────────────────────────────────────────────────┘");
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
                insertarPelicula();
                break;
            case 2:
                mostrarTotalPeliculas();
                break;
            case 3:
                buscarPorPalabraClave();
                break;
            case 4:
                buscarPorTituloExacto();
                break;
            case 5:
                buscarPorPosicion();
                break;
            case 6:
                mostrarTodasLasPeliculas();
                break;
            case 7:
                mostrarDespedida();
                return false;
            case 8:
                mostrarTitulosYActores();
                break;
            case 9:
                buscarPeliculasPorActor();
                break;
            case 10:
                mostrarActoresMayoresDe60();
                break;
            default:
                System.out.println("❌ Opción inválida. Por favor, seleccione una opción del 1 al 10.");
                break;
        }

        return true;
    }

    /**
     * Opción 1: Insertar una nueva película con actores
     */
    private static void insertarPelicula() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            INSERTAR NUEVA PELÍCULA");
        System.out.println("═══════════════════════════════════════════════════════════");

        try {
            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Género: ");
            String genero = scanner.nextLine();

            System.out.print("Año de estreno: ");
            int anyoEstreno = Integer.parseInt(scanner.nextLine());

            System.out.print("Duración (en minutos): ");
            double duracion = Double.parseDouble(scanner.nextLine());

            // Crear la película
            Pelicula nuevaPelicula = new Pelicula(titulo, genero, anyoEstreno, duracion);

            // Preguntar si quiere añadir actores
            System.out.print("\n¿Desea añadir actores principales? (s/n): ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                boolean continuarActores = true;
                while (continuarActores) {
                    System.out.println("\n--- Añadir actor ---");
                    System.out.print("Nombre del actor: ");
                    String nombreActor = scanner.nextLine();

                    System.out.print("Año de nacimiento: ");
                    int anyoNacimiento = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nacionalidad: ");
                    String nacionalidad = scanner.nextLine();

                    Actor nuevoActor = new Actor(nombreActor, anyoNacimiento, nacionalidad);
                    nuevaPelicula.agregarActor(nuevoActor);

                    System.out.print("\n¿Añadir otro actor? (s/n): ");
                    String otraRespuesta = scanner.nextLine();
                    continuarActores = otraRespuesta.equalsIgnoreCase("s");
                }
            }

            // Agregar la película a la lista
            Pelicula.agregarPelicula(nuevaPelicula);

            System.out.println("\n✅ Película agregada con éxito!");
            System.out.println(nuevaPelicula);

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Los datos numéricos no son válidos. Película no agregada.");
        }
    }

    /**
     * Opción 2: Mostrar el total de películas
     */
    private static void mostrarTotalPeliculas() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            TOTAL DE PELÍCULAS");
        System.out.println("═══════════════════════════════════════════════════════════");

        int total = Pelicula.totalPeliculas();
        System.out.println("📊 Hay un total de " + total + " película(s) en la lista.");
    }

    /**
     * Opción 3: Buscar películas por palabra clave
     */
    private static void buscarPorPalabraClave() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            BUSCAR POR PALABRA CLAVE");
        System.out.println("═══════════════════════════════════════════════════════════");

        System.out.print("Ingrese la palabra clave: ");
        String palabraClave = scanner.nextLine();

        ArrayList<Pelicula> resultados = Pelicula.buscarPorPalabraClave(palabraClave);

        if (resultados.isEmpty()) {
            System.out.println("❌ No se encontraron películas que contengan \"" + palabraClave + "\".");
        } else {
            System.out.println("✅ Se encontraron " + resultados.size() + " película(s):");
            for (Pelicula pelicula : resultados) {
                System.out.println(pelicula);
            }
        }
    }

    /**
     * Opción 4: Buscar película por título exacto
     */
    private static void buscarPorTituloExacto() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            BUSCAR POR TÍTULO EXACTO");
        System.out.println("═══════════════════════════════════════════════════════════");

        System.out.print("Ingrese el título completo: ");
        String titulo = scanner.nextLine();

        Pelicula pelicula = Pelicula.buscarPorTituloExacto(titulo);

        if (pelicula == null) {
            System.out.println("❌ No se encontró ninguna película con el título \"" + titulo + "\".");
        } else {
            System.out.println("✅ Película encontrada:");
            System.out.println(pelicula);
        }
    }

    /**
     * Opción 5: Buscar película por posición
     */
    private static void buscarPorPosicion() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            BUSCAR POR POSICIÓN");
        System.out.println("═══════════════════════════════════════════════════════════");

        try {
            System.out.print("Ingrese la posición (0 a " + (Pelicula.totalPeliculas() - 1) + "): ");
            int posicion = Integer.parseInt(scanner.nextLine());

            Pelicula pelicula = Pelicula.buscarPorPosicion(posicion);

            if (pelicula == null) {
                System.out.println("❌ Error: La posición " + posicion + " no es válida.");
                System.out.println("   Las posiciones válidas son de 0 a " + (Pelicula.totalPeliculas() - 1));
            } else {
                System.out.println("✅ Película en la posición " + posicion + ":");
                System.out.println(pelicula);
            }

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Debe ingresar un número entero válido.");
        }
    }

    /**
     * Opción 6: Mostrar todas las películas
     */
    private static void mostrarTodasLasPeliculas() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            LISTADO COMPLETO DE PELÍCULAS");
        System.out.println("═══════════════════════════════════════════════════════════");

        Pelicula.mostrarTodasLasPeliculas();
    }

    /**
     * Opción 7: Mostrar mensaje de despedida
     */
    private static void mostrarDespedida() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║   ¡Gracias por usar la Gestión de Películas!            ║");
        System.out.println("║   ¡Hasta pronto!                                         ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }

    /**
     * Opción 8: Mostrar todos los títulos y nombres de actores principales
     */
    private static void mostrarTitulosYActores() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("        TÍTULOS Y ACTORES PRINCIPALES");
        System.out.println("═══════════════════════════════════════════════════════════");

        Pelicula.mostrarTitulosYActores();
    }

    /**
     * Opción 9: Buscar películas por actor
     */
    private static void buscarPeliculasPorActor() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("            BUSCAR PELÍCULAS POR ACTOR");
        System.out.println("═══════════════════════════════════════════════════════════");

        System.out.print("Ingrese el nombre del actor: ");
        String nombreActor = scanner.nextLine();

        ArrayList<Pelicula> resultados = Pelicula.buscarPeliculasPorActor(nombreActor);

        if (resultados.isEmpty()) {
            System.out.println("❌ No se encontraron películas con el actor \"" + nombreActor + "\".");
        } else {
            System.out.println("✅ Se encontraron " + resultados.size() + " película(s) con el actor \"" + nombreActor + "\":");
            for (Pelicula pelicula : resultados) {
                System.out.println(pelicula);
            }
        }
    }

    /**
     * Opción 10: Mostrar actores mayores de 60 años
     */
    private static void mostrarActoresMayoresDe60() {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("        ACTORES MAYORES DE 60 AÑOS");
        System.out.println("═══════════════════════════════════════════════════════════");

        Pelicula.mostrarActoresMayoresDe60();
    }
}

