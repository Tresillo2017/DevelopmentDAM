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

package u9.tasks.task2;

import java.util.Scanner;

public class Main {
    private static LibroDAO libroDAO;
    private static Scanner scanner;

    public static void main(String[] args) {
        libroDAO = new LibroDAO();
        scanner = new Scanner(System.in);

        mostrarMenu();

        scanner.close();
    }

    private static void mostrarMenu() {
        int opcion;
        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== MENU BIBLIOTECA =====");
            System.out.println("1. Insertar libro");
            System.out.println("2. Mostrar todos los libros");
            System.out.println("3. Buscar libros por autor");
            System.out.println("4. Actualizar precio de un libro");
            System.out.println("5. Eliminar libro");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    insertarLibro();
                    break;
                case 2:
                    libroDAO.mostrarLibros();
                    break;
                case 3:
                    buscarPorAutor();
                    break;
                case 4:
                    actualizarPrecio();
                    break;
                case 5:
                    eliminarLibro();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        }
    }

    private static void insertarLibro() {
        System.out.println("\n===== INSERTAR NUEVO LIBRO =====");

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine().trim();

        System.out.print("Autor: ");
        String autor = scanner.nextLine().trim();

        System.out.print("Genero: ");
        String genero = scanner.nextLine().trim();

        System.out.print("Precio: ");
        double precio = leerDouble();

        System.out.print("Disponible (1=Si, 0=No): ");
        boolean disponible = leerBooleano();

        if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty() || precio < 0) {
            System.out.println("Datos invalidos. El libro no fue insertado.");
            return;
        }

        Libro libro = new Libro(titulo, autor, genero, precio, disponible);
        libroDAO.insertarLibro(libro);
    }

    private static void buscarPorAutor() {
        System.out.print("Ingrese el nombre del autor a buscar: ");
        String autor = scanner.nextLine().trim();

        if (autor.isEmpty()) {
            System.out.println("El nombre del autor no puede estar vacio.");
            return;
        }

        libroDAO.buscarPorAutor(autor);
    }

    private static void actualizarPrecio() {
        System.out.print("Ingrese el ID del libro: ");
        int id = leerEntero();

        if (id <= 0) {
            System.out.println("ID invalido.");
            return;
        }

        System.out.print("Ingrese el nuevo precio: ");
        double nuevoPrecio = leerDouble();

        libroDAO.actualizarPrecio(id, nuevoPrecio);
    }

    private static void eliminarLibro() {
        System.out.print("Ingrese el ID del libro a eliminar: ");
        int id = leerEntero();

        if (id <= 0) {
            System.out.println("ID invalido.");
            return;
        }

        libroDAO.eliminarLibro(id);
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida. Ingrese un numero entero.");
            return -1;
        }
    }

    private static double leerDouble() {
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida. Ingrese un numero valido.");
            return -1;
        }
    }

    private static boolean leerBooleano() {
        try {
            int valor = Integer.parseInt(scanner.nextLine().trim());
            return valor == 1;
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida. Ingrese 1 o 0.");
            return false;
        }
    }
}

