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

public class Novela extends Libro implements Prestable {
    private String genero;

    public Novela(String titulo, int anioPublicacion, double precioBase, Autor autor, String genero) {
        super(titulo, anioPublicacion, precioBase, autor);
        this.genero = genero;
    }

    @Override
    public double calcularPrecioFinal() {
        double precioFinal = 0;
        if (genero.equalsIgnoreCase("fantasia") || genero.equalsIgnoreCase("ciencia ficcion")) {
            precioFinal = getPrecioBase() + 3;
        }
        else {
            precioFinal = getPrecioBase();
        }
        return precioFinal;
    }

    @Override
    public void prestar(String nombreUsuario, String fechaPrestamo, int diasPrestamo) {
        Prestamo p = new Prestamo(nombreUsuario, fechaPrestamo, diasPrestamo);
        anadirPrestamo(p);
    }
}
