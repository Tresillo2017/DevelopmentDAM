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

import java.util.ArrayList;

public class Protectora {
    private ArrayList<Animal> animales;

    public Protectora() {
        this.animales = new ArrayList<>();
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    public void mostrarAnimales() {
        for (Animal a : animales) {
            a.mostrarDatos();
            a.mostrarVacunas();
            System.out.println("Coste Adopcion: " + a.calcularCosteAdopcion());
            System.out.println("-----------------------------");
        }
    }

    public void mostrarCuidadosAnimales() {
        for (Animal a : animales) {
            if (a instanceof Cuidable) {
                ((Cuidable) a).mostrarCuidados();
            }
        }
    }

    public void buscarAnimal(String nombre) {
        boolean encontrado = false;

        for (Animal a : animales) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                a.mostrarDatos();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se ha encontrado ningun animal con ese nombre.");
        }
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }
}
