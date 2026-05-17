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

package u7.repaso.ex3;
import java.util.ArrayList;
import java.util.Scanner;
public class Biblioteca {
    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("------Menu-------");
            System.out.println("1. Añadir novela");
            System.out.println("2. Añadir libro de texto");
            System.out.println("3. Añadir cómic");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. Prestar un libro");
            System.out.println("6. Mostrar préstamos de un libro");
            System.out.println("7. Calcular precio total de todos los libros");
            System.out.println("8. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Anio de publicacion");
                    int anioPublicacion = sc.nextInt();

                    System.out.println("Precio base:");
                    double precioBase = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Nombre del autor: ");
                    String nombreAutor = sc.nextLine();

                    System.out.print("Nacionalidad del autor: ");
                    String nacionalidad = sc.nextLine();

                    System.out.print("Año de nacimiento del autor: ");
                    int anioNacimiento = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Genero: ");
                    String genero = sc.nextLine();

                    Autor autor = new Autor(nombreAutor, nacionalidad, anioNacimiento);
                    Novela novela = new Novela(titulo, anioPublicacion, precioBase, autor, genero);

                    libros.add(novela);

                    System.out.println("Novela añadida correctamente");
                    break;

                case 2:
                    System.out.print("Titulo: ");
                    String tituloTexto = sc.nextLine();

                    System.out.print("Anio de publicacion");
                    int anioTexto = sc.nextInt();

                    System.out.print("Precio base: ");
                    double precioTexto = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Nombre del autor: ");
                    String nombreAutorTexto = sc.nextLine();

                    System.out.print("Nacionalidad del autor: ");
                    String nacionalidadTexto = sc.nextLine();

                    System.out.print("Anio de nacimiento del autor: ");
                    int anioNacimientoTexto = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Asignatura: ");
                    String asignatura = sc.nextLine();

                    Autor autorTexto = new Autor(nombreAutorTexto, nacionalidadTexto, anioNacimientoTexto);
                    Libro libroTexto = new LibroTexto(tituloTexto, anioTexto, precioTexto, autorTexto, asignatura);

                    libros.add(libroTexto);

                    System.out.println("Libro de texto agregador correctamente.");
                    break;
                case 3:
                    System.out.print("Titulo: ");
                    String tituloComic = sc.nextLine();

                    System.out.print("Anio de publicacion");
                    int anioComic = sc.nextInt();

                    System.out.print("Precio base: ");
                    double precioComic = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Nombre del autor: ");
                    String nombreAutorComic = sc.nextLine();

                    System.out.print("Nacionalidad del autor: ");
                    String nacionalidadComic = sc.nextLine();

                    System.out.print("Anio de nacimiento del autor: ");
                    int anioNacimientoComic = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Es de coleccionista: (si/no)");
                    String respuesta = sc.nextLine();
                    boolean coleccionista = respuesta.equalsIgnoreCase("si");

                    Autor autorComic = new Autor(nombreAutorComic, nacionalidadComic, anioNacimientoComic);
                    Comic comic = new Comic(tituloComic, anioComic, precioComic, autorComic, coleccionista);

                    libros.add(comic);

                    System.out.println("Comic agregado correctamente");
                    break;
                case 4:
                    if (libros.isEmpty()) {
                        System.out.println("Error, no hay libros disponibles");
                    } else {
                        for (Libro l : libros) {
                            System.out.println("Titulo: " + l.getTitulo() + "( Autor: " + l.getAutor() + ", AnioPub: " + l.getAnioPublicacion() + ")");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Titulo libro: ");
                    String tituloLibro = sc.nextLine();
                    Libro libroEncontrado = null;
                    for (Libro l : libros) {
                        if (l.getTitulo().equalsIgnoreCase(tituloLibro)) {
                            libroEncontrado = l;
                            break;
                        }
                    }

                    if (libroEncontrado != null) {
                        System.out.print("Nombre del usuario: ");
                        String nombreUsuario = sc.nextLine();

                        System.out.println("Fecha del Prestamo");
                        String fechaPrestamo = sc.nextLine();

                        System.out.println("Dias prestamo: ");
                        int diasPrestamo = sc.nextInt();
                        sc.nextLine();

                        if (libroEncontrado instanceof Prestable){
                            ((Prestable) libroEncontrado).prestar(nombreUsuario, fechaPrestamo, diasPrestamo);
                        }
                        System.out.println("Prestamo realizado correctamente");
                    } else {
                        System.out.println("No se ha encontrado el libro.");
                    }
                    break;
                case 6:
                    System.out.print("Titulo: ");
                    String tituloLibro2 = sc.nextLine();

                    Libro libroEncontrado2 = null;

                    for (Libro l : libros) {
                        if (l.getTitulo().equalsIgnoreCase(tituloLibro2)) {
                            libroEncontrado2 = l;
                            break;
                        }
                    }

                    if (libroEncontrado2 != null) {
                        if (libroEncontrado2.getPrestamos().isEmpty()) {
                            System.out.println("Error, el libro seleccionado no tiene prestamos disponibles");
                        } else
                            libroEncontrado2.mostrarPrestamos();
                    } else
                        System.out.println("El libro introducido no existe");
                    break;

                case 7:
                    double precioTotal = 0;
                    for (Libro l : libros) {
                        precioTotal += l.calcularPrecioFinal();
                    }

                    System.out.println("El precio total de todos los libros es: " + precioTotal + "€");
                    break;
                case 8:
                    System.out.println("Saliendo.....");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        while (opcion != 8);

        sc.close();
    }
}
