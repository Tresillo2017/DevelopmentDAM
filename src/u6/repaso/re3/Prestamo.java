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

import java.util.ArrayList;

public class Prestamo {
    private Libro libro;
    private Lector lector;
    private int diasPrestamo;
    public static ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

    public Prestamo(Libro l, Lector lec, int dias) {
        this.libro = l;
        this.lector = lec;
        this.diasPrestamo = dias;
    }

    public boolean validarPrestamo() {
        if (lector.getTipo().equals("nino") && !libro.getGenero().equals("infantil")) {
            System.out.println("Niños solo libros infantiles");
            return false;
        }
        return true;
    }

    public void mostrarInfo() {
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Lector: " + lector.getNombre());
        System.out.println("Dias: " + diasPrestamo);
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public static ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public static void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
        Prestamo.listaPrestamos = listaPrestamos;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + libro +
                ", lector=" + lector +
                ", diasPrestamo=" + diasPrestamo +
                '}';
    }
}
