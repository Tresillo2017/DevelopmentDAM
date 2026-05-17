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

package u7.repaso.ex2;

public class Gato extends Animal implements Cuidable {
    private String color;

    public Gato(String nombre, int edad, double peso, String color) {
        super(nombre,edad,peso);
        this.color = color;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Nombre: " + getNombre() + " (Edad: " + getEdad() + ", Peso: " + getPeso() + ", Color: " + color + ")");
    }

    @Override
    public double calcularCosteAdopcion() {
        double costeBase = 60;
        if (getEdad() < 1) {
            costeBase = costeBase + 15;
        }
        return costeBase;
    }

    @Override
    public void mostrarCuidados() {
        System.out.println("Necesita arenero limpio y control de alimentacion");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
