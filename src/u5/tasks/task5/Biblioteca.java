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

public class Biblioteca {
    private static Libro[] libros = new Libro[1000]; // Array para almacenar libros
    private static int numLibros = 0; // Contador de libros

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear 5 objetos Libro con datos inventados usando ambos constructores
        inicializarBiblioteca();

        // Mostrar información inicial de todos los libros
        System.out.println("\n=== LIBROS INICIALES DE LA BIBLIOTECA ===");
        mostrarTodosLibrosInfo();

        int opcion;
        do {
            // Mostrar menú
            System.out.println("\n=== MENÚ DE BIBLIOTECA ===");
            System.out.println("1) Prestar un libro");
            System.out.println("2) Devolver un libro");
            System.out.println("3) Dar de alta un libro nuevo");
            System.out.println("4) Dar de baja un libro");
            System.out.println("5) Filtrar libros por autor");
            System.out.println("6) Mostrar títulos y autores de todos los libros");
            System.out.println("7) Mostrar todos los libros con información completa");
            System.out.println("8) Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea en blanco

            switch (opcion) {
                case 1:
                    prestarLibro(scanner);
                    break;
                case 2:
                    devolverLibro(scanner);
                    break;
                case 3:
                    darDeAltaLibro(scanner);
                    break;
                case 4:
                    darDeBajaLibro(scanner);
                    break;
                case 5:
                    filtrarPorAutor(scanner);
                    break;
                case 6:
                    mostrarTitulosYAutores();
                    break;
                case 7:
                    mostrarTodosLibrosInfo();
                    break;
                case 8:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    // Método para inicializar la biblioteca con 5 libros
    private static void inicializarBiblioteca() {
        // Usando constructor con todos los parámetros
        Persona autor1 = new Persona("Miguel de Cervantes", "Española");
        libros[0] = new Libro("978-1234567890", "El Quijote", autor1, 1605, false);

        Persona autor2 = new Persona("Gabriel García Márquez", "Colombiana");
        libros[1] = new Libro("978-0987654321", "Cien años de soledad", autor2, 1967, false);

        Persona autor3 = new Persona("George Orwell", "Británica");
        libros[2] = new Libro("978-1111111111", "1984", autor3, 1949, false);

        // Usando constructor con isbn y titulo (otros valores por defecto)
        libros[3] = new Libro("978-2222222222", "Orgullo y Prejuicio");
        libros[3].setAutor(new Persona("Jane Austen", "Británica"));
        libros[3].setAnioPublicacion(1813);

        libros[4] = new Libro("978-3333333333", "El Principito");
        libros[4].setAutor(new Persona("Antoine de Saint-Exupéry", "Francesa"));
        libros[4].setAnioPublicacion(1943);

        numLibros = 5;
    }

    // Método para prestar un libro
    private static void prestarLibro(Scanner scanner) {
        if (numLibros == 0) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }

        // Mostrar libros disponibles
        System.out.println("\n=== LIBROS DISPONIBLES PARA PRESTAR ===");
        int contadorDisponibles = 0;
        for (int i = 0; i < numLibros; i++) {
            if (!libros[i].isPrestado()) {
                System.out.println((contadorDisponibles + 1) + ") ISBN: " + libros[i].getIsbn() + " - Título: " + libros[i].getTitulo());
                contadorDisponibles++;
            }
        }

        if (contadorDisponibles == 0) {
            System.out.println("No hay libros disponibles para prestar.");
            return;
        }

        // Seleccionar libro a prestar
        System.out.print("Introduce el ISBN del libro a prestar: ");
        String isbnBuscado = scanner.nextLine();

        for (int i = 0; i < numLibros; i++) {
            if (libros[i].getIsbn().equals(isbnBuscado)) {
                if (!libros[i].isPrestado()) {
                    libros[i].prestar();
                    System.out.println("El libro '" + libros[i].getTitulo() + "' ha sido prestado correctamente.");
                    return;
                } else {
                    System.out.println("El libro '" + libros[i].getTitulo() + "' ya está prestado.");
                    return;
                }
            }
        }

        System.out.println("El ISBN '" + isbnBuscado + "' no fue encontrado.");
    }

    // Método para devolver un libro
    private static void devolverLibro(Scanner scanner) {
        if (numLibros == 0) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }

        // Mostrar libros prestados
        System.out.println("\n=== LIBROS PRESTADOS ===");
        int contadorPrestados = 0;
        for (int i = 0; i < numLibros; i++) {
            if (libros[i].isPrestado()) {
                System.out.println((contadorPrestados + 1) + ") ISBN: " + libros[i].getIsbn() + " - Título: " + libros[i].getTitulo());
                contadorPrestados++;
            }
        }

        if (contadorPrestados == 0) {
            System.out.println("No hay libros prestados.");
            return;
        }

        // Seleccionar libro a devolver
        System.out.print("Introduce el ISBN del libro a devolver: ");
        String isbnBuscado = scanner.nextLine();

        for (int i = 0; i < numLibros; i++) {
            if (libros[i].getIsbn().equals(isbnBuscado)) {
                if (libros[i].isPrestado()) {
                    libros[i].devolver();
                    System.out.println("El libro '" + libros[i].getTitulo() + "' ha sido devuelto correctamente.");
                    return;
                } else {
                    System.out.println("El libro '" + libros[i].getTitulo() + "' no está prestado.");
                    return;
                }
            }
        }

        System.out.println("El ISBN '" + isbnBuscado + "' no fue encontrado.");
    }

    // Método para dar de alta un libro nuevo
    private static void darDeAltaLibro(Scanner scanner) {
        if (numLibros >= libros.length) {
            System.out.println("No hay espacio para más libros.");
            return;
        }

        System.out.print("Introduce el ISBN del nuevo libro: ");
        String isbn = scanner.nextLine();

        // Verificar que no esté duplicado
        for (int i = 0; i < numLibros; i++) {
            if (libros[i].getIsbn().equals(isbn)) {
                System.out.println("El ISBN '" + isbn + "' ya existe en la biblioteca.");
                return;
            }
        }

        System.out.print("Introduce el título: ");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el nombre del autor: ");
        String nombreAutor = scanner.nextLine();
        System.out.print("Introduce la nacionalidad del autor: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Introduce el año de publicación: ");
        int anioPublicacion = scanner.nextInt();
        scanner.nextLine();

        Persona autor = new Persona(nombreAutor, nacionalidad);
        libros[numLibros] = new Libro(isbn, titulo, autor, anioPublicacion, false);
        numLibros++;
        System.out.println("El libro '" + titulo + "' ha sido dado de alta correctamente.");
    }

    // Método para dar de baja un libro
    private static void darDeBajaLibro(Scanner scanner) {
        if (numLibros == 0) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }

        System.out.print("Introduce el ISBN del libro a dar de baja: ");
        String isbnBuscado = scanner.nextLine();

        for (int i = 0; i < numLibros; i++) {
            if (libros[i].getIsbn().equals(isbnBuscado)) {
                String titulo = libros[i].getTitulo();
                // Desplazar los libros
                for (int j = i; j < numLibros - 1; j++) {
                    libros[j] = libros[j + 1];
                }
                numLibros--;
                System.out.println("El libro '" + titulo + "' ha sido dado de baja correctamente.");
                return;
            }
        }

        System.out.println("El ISBN '" + isbnBuscado + "' no fue encontrado.");
    }

    // Método para filtrar libros por autor
    private static void filtrarPorAutor(Scanner scanner) {
        if (numLibros == 0) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }

        System.out.print("Introduce el nombre del autor a buscar: ");
        String autorBuscado = scanner.nextLine();

        System.out.println("\n=== LIBROS DEL AUTOR '" + autorBuscado + "' ===");
        boolean encontrado = false;
        for (int i = 0; i < numLibros; i++) {
            if (libros[i].getAutor().getNombre().equalsIgnoreCase(autorBuscado)) {
                libros[i].mostrarInfo();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron libros del autor '" + autorBuscado + "'.");
        }
    }

    // Método para mostrar título y nombre de autor de todos los libros
    private static void mostrarTitulosYAutores() {
        if (numLibros == 0) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }

        System.out.println("\n=== TÍTULOS Y AUTORES DE TODOS LOS LIBROS ===");
        for (int i = 0; i < numLibros; i++) {
            System.out.println((i + 1) + ") Título: " + libros[i].getTitulo() + " | Autor: " + libros[i].getAutor().getNombre());
        }
    }

    // Método para mostrar todos los libros con información completa
    private static void mostrarTodosLibrosInfo() {
        if (numLibros == 0) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }

        System.out.println("\n=== TODOS LOS LIBROS DE LA BIBLIOTECA ===");
        for (int i = 0; i < numLibros; i++) {
            libros[i].mostrarInfo();
        }
    }
}

