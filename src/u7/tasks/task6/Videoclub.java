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

package u7.tasks.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Videoclub {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<Recurso> recursos = new ArrayList<>();
    private static boolean recursosAutomaticosAgregados = false;

    public static void main(String[] args) {
        if (args == null) {
            return;
        }

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1 -> anadirRecursosAutomaticamente();
                case 2 -> anadirNuevoRecurso();
                case 3 -> mostrarRecursos();
                case 4 -> darDeBajaRecurso();
                case 5 -> alquilarRecurso();
                case 6 -> devolverRecurso();
                case 7 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }

            if (opcion != 7) {
                System.out.println();
            }
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("==============================");
        System.out.println("     VIDEOCLUB MANAGER");
        System.out.println("==============================");
        System.out.println("1) Añadir recursos automáticamente");
        System.out.println("2) Añadir un nuevo recurso");
        System.out.println("3) Mostrar recursos");
        System.out.println("4) Dar de baja un recurso");
        System.out.println("5) Alquilar un recurso");
        System.out.println("6) Devolver un recurso");
        System.out.println("7) Salir");
    }

    private static void anadirRecursosAutomaticamente() {
        if (recursosAutomaticosAgregados) {
            System.out.println("Los recursos automáticos ya han sido agregados previamente.");
            return;
        }

        recursos.add(new Pelicula("P-001", "Avatar", 5, "James Cameron", "Sam Worthington, Zoe Saldaña", "Ciencia Ficción"));
        recursos.add(new Pelicula("P-002", "Inception", 3, "Christopher Nolan", "Leonardo DiCaprio, Ellen Page", "Thriller"));
        recursos.add(new Juego("J-001", "Elden Ring", 2, true, "FromSoftware"));
        recursos.add(new Juego("J-002", "The Legend of Zelda", 4, false, "Nintendo"));
        recursos.add(new Musica("M-001", "Abbey Road", 6, "The Beatles", 1969));
        recursos.add(new Musica("M-002", "Thriller", 3, "Michael Jackson", 1982));

        recursosAutomaticosAgregados = true;
        System.out.println("Se han agregado 6 recursos automáticamente.");
    }

    private static void anadirNuevoRecurso() {
        System.out.println("Selecciona el tipo de recurso:");
        System.out.println("1) Película");
        System.out.println("2) Juego");
        System.out.println("3) Música");
        int tipo = leerEntero("Elige el tipo: ");

        String codigo = leerTextoNoVacio("Introduce el código: ");
        if (codigoExiste(codigo)) {
            System.out.println("Ya existe un recurso con ese código.");
            return;
        }

        String titulo = leerTextoNoVacio("Introduce el título: ");
        int numeroEjemplares = leerEnteroPositivo("Introduce el número de ejemplares: ");

        Recurso nuevoRecurso = switch (tipo) {
            case 1 -> {
                String director = leerTextoNoVacio("Introduce el director: ");
                String interpretes = leerTextoNoVacio("Introduce los intérpretes: ");
                String genero = leerTextoNoVacio("Introduce el género: ");
                yield new Pelicula(codigo, titulo, numeroEjemplares, director, interpretes, genero);
            }
            case 2 -> {
                boolean multijugador = leerBooleano("¿Es multijugador? (s/n): ");
                String autor = leerTextoNoVacio("Introduce el autor: ");
                yield new Juego(codigo, titulo, numeroEjemplares, multijugador, autor);
            }
            case 3 -> {
                String nombreGrupo = leerTextoNoVacio("Introduce el nombre del grupo: ");
                int año = leerEnteroPositivo("Introduce el año: ");
                yield new Musica(codigo, titulo, numeroEjemplares, nombreGrupo, año);
            }
            default -> null;
        };

        if (nuevoRecurso == null) {
            System.out.println("Tipo de recurso no válido.");
            return;
        }

        recursos.add(nuevoRecurso);
        System.out.println("Recurso agregado correctamente.");
    }

    private static void mostrarRecursos() {
        System.out.println("Selecciona el tipo de recurso a mostrar:");
        System.out.println("1) Películas");
        System.out.println("2) Juegos");
        System.out.println("3) Música");
        int tipo = leerEntero("Elige el tipo: ");

        boolean encontrado = false;

        for (Recurso recurso : recursos) {
            if (tipo == 1 && recurso instanceof Pelicula) {
                System.out.println(recurso);
                encontrado = true;
            } else if (tipo == 2 && recurso instanceof Juego) {
                System.out.println(recurso);
                encontrado = true;
            } else if (tipo == 3 && recurso instanceof Musica) {
                System.out.println(recurso);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay recursos de ese tipo.");
        }
    }

    private static void darDeBajaRecurso() {
        String codigo = leerTextoNoVacio("Introduce el código del recurso a dar de baja: ");

        for (Recurso recurso : recursos) {
            if (recurso.getCodigo().equalsIgnoreCase(codigo)) {
                recursos.remove(recurso);
                System.out.println("Recurso eliminado correctamente.");
                return;
            }
        }

        System.out.println("No se encontró un recurso con ese código.");
    }

    private static void alquilarRecurso() {
        String codigo = leerTextoNoVacio("Introduce el código del recurso a alquilar: ");

        for (Recurso recurso : recursos) {
            if (recurso.getCodigo().equalsIgnoreCase(codigo)) {
                if (recurso.getNumeroEjemplares() > 0) {
                    recurso.alquilar();
                    System.out.println("Recurso alquilado correctamente. Ejemplares restantes: " + recurso.getNumeroEjemplares());
                } else {
                    System.out.println("No hay ejemplares disponibles de este recurso.");
                }
                return;
            }
        }

        System.out.println("No se encontró un recurso con ese código.");
    }

    private static void devolverRecurso() {
        String codigo = leerTextoNoVacio("Introduce el código del recurso a devolver: ");

        for (Recurso recurso : recursos) {
            if (recurso.getCodigo().equalsIgnoreCase(codigo)) {
                recurso.devolver();
                System.out.println("Recurso devuelto correctamente. Ejemplares disponibles: " + recurso.getNumeroEjemplares());
                return;
            }
        }

        System.out.println("No se encontró un recurso con ese código.");
    }

    private static boolean codigoExiste(String codigo) {
        for (Recurso recurso : recursos) {
            if (recurso.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            String entrada = leerTextoNoVacio(mensaje);
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número entero válido.");
            }
        }
    }

    private static int leerEnteroPositivo(String mensaje) {
        while (true) {
            int valor = leerEntero(mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("El valor debe ser mayor a 0.");
        }
    }

    private static boolean leerBooleano(String mensaje) {
        while (true) {
            String entrada = leerTextoNoVacio(mensaje).toLowerCase();
            if ("s".equals(entrada) || "sí".equals(entrada) || "si".equals(entrada)) {
                return true;
            } else if ("n".equals(entrada) || "no".equals(entrada)) {
                return false;
            }
            System.out.println("Introduce 's' para sí o 'n' para no.");
        }
    }

    private static String leerTextoNoVacio(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = SCANNER.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println("El valor no puede estar vacío.");
        }
    }
}

