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

package u7.tasks.task2;

public class Vehiculo {
    private double kilometros;
    private String color;
    private String numeroSerie;

    public static Vehiculo[] misVehiculos = {
            new Coche(12000.5, "Rojo", "C-001", 5, 1600),
            new Coche(8500.0, "Azul", "C-002", 3, 1200),
            new Avion(250000.0, "Blanco", "A-001", 180),
            new Avion(175000.0, "Gris", "A-002", 220),
            new Barco(42000.0, "Blanco", "B-001", "Mercante"),
            new Barco(68000.0, "Azul", "B-002", "Pesquera")
    };

    public Vehiculo() {
    }

    public Vehiculo(double kilometros, String color, String numeroSerie) {
        this.kilometros = kilometros;
        this.color = color;
        this.numeroSerie = numeroSerie;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "kilometros=" + kilometros +
                ", color='" + color + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                '}';
    }
}

