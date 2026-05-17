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

package u7.repaso.ex1cont;

public class EntradaVIP extends Entrada implements Descontable {
    private String tipoSala;

    public EntradaVIP(int codigo, String tituloPelicula, String tipoSala) {
        super(codigo, tituloPelicula);
        this.tipoSala = tipoSala;
        this.precio = calcularPrecio();
    }

    public EntradaVIP(int codigo, String tituloPelicula) {
        super(codigo, tituloPelicula);
        this.tipoSala = "3D";
        this.precio = calcularPrecio();
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
        this.precio = calcularPrecio();
    }

    @Override
    public void mostrarEntrada() {
        System.out.println("Código: " + codigo + " - Título: \"" + tituloPelicula + "\" - Tipo sala: " + tipoSala + ".");
    }

    @Override
    public double calcularPrecio() {
        double precioNormal = 5.50;
        if (tipoSala.equalsIgnoreCase("3D")) return precioNormal + 3;
        if (tipoSala.equalsIgnoreCase("VIP")) return precioNormal + 2;
        if (tipoSala.equalsIgnoreCase("IMAX")) return precioNormal + 1;
        return precioNormal;
    }

    @Override
    public double aplicarDescuento() {
        if (tipoSala.equalsIgnoreCase("VIP")) {
            return calcularPrecio() * descuento;
        }
        return calcularPrecio();
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Título: " + tituloPelicula + ", TipoSala: " + tipoSala + ", Precio: " + calcularPrecio();
    }
}