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

package u6.repaso.re3;

public class Main {
    public static void main(String[] args) {
        // 1. Crear 4 libros (mezcla generos, 1 infantil)
        Libro l1 = new Libro("Cuentos", 100, "infantil");
        Libro l2 = new Libro("Fisica", 400, "ciencia");
        Libro l3 = new Libro("Guerra", 500, "historia");

        // 2. Crear 3 lectores
        Lector lec1 = new Lector("Pepe nino", 10, "nino");
        Lector lec2 = new Lector("Ana", 30, "adulto");
        Lector lec3 = new Lector("Luis", 25, "joven");

        // 4. Agregar solo prestamos validos a listaPrestamos
        Prestamo p1 = new Prestamo(l1, lec1, 7);
        Prestamo p2 = new Prestamo(l2, lec2, 14);
        Prestamo p3 = new Prestamo(l3, lec3, 5);

        if (p1.validarPrestamo()) {
            Prestamo.listaPrestamos.add(p1);
        }
        if (p2.validarPrestamo()) {
            Prestamo.listaPrestamos.add(p2);
        }
        if (p3.validarPrestamo()) {
            Prestamo.listaPrestamos.add(p3);
        }

        // 5. MOSTRAR TODOS préstamos válidos
        for (Prestamo p : Prestamo.listaPrestamos ) {
            p.mostrarInfo();
        }

        // 6. Libro con MÁS páginas prestado
        // int maxPag = -1; Libro libroMax = null;
        Libro libroMax = null;
        int maxPag = -1;
        for (Prestamo p : Prestamo.listaPrestamos) {
            int pag = p.getLibro().getPaginas();

            if (pag > maxPag) {
                maxPag = pag;
                libroMax = p.getLibro();
            }
        }
        System.out.println("Libro mas largo: " + libroMax.getTitulo() + " (" + maxPag + " paginas)");

        // 7. Cuántos préstamos a lectores "adulto"
        // int countAdulto = 0;
        int countAdulto = 0;
        for (Prestamo p : Prestamo.listaPrestamos) {
            if (p.getLector().getTipo().equals("adulto")) {
                countAdulto++;
            }
        }
        System.out.println("Hay prestados " + countAdulto + " a lectores adultos");

        // 8. Lector con préstamo >300 páginas
        // for(Prestamo p : listaPrestamos) {
        //     if(p.getLibro().getPaginas() > 300) { ... }
        for (Prestamo p : Prestamo.listaPrestamos) {
            if (p.getLibro().getPaginas() > 300) {
                System.out.println("Nombre: " + p.getLector().getNombre());
                break;
            }
        }
    }
}
