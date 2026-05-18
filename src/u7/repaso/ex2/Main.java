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

public class Main {
    public static void main(String[] args) {
        Protectora protectora = new Protectora();

        Perro perro1 = new Perro("Toby", 1, 12.5, "Labrador");
        Perro perro2 = new Perro("Rex", 4, 18.0, "Pastor Aleman");

        Gato gato1 = new Gato("Misu", 0, 3.2, "Negro");
        Gato gato2 = new Gato("Luna", 2, 4.1, "Blanco");


        perro1.agregarVacuna("Vacuna1");
        perro1.agregarVacuna("Vacuna2");
        perro2.agregarVacuna("Vacuna1");
        perro2.agregarVacuna("Vacuna2");
        gato1.agregarVacuna("Vacuna1");
        gato1.agregarVacuna("Vacuna2");
        gato2.agregarVacuna("Vacuna1");
        gato2.agregarVacuna("Vacuna2");

        protectora.agregarAnimal(perro1);
        protectora.agregarAnimal(perro2);
        protectora.agregarAnimal(gato1);
        protectora.agregarAnimal(gato2);

        //Mostrar todos los animales
        System.out.println("----Todos Los Animales------------\n");
        protectora.mostrarAnimales();

        //Mostrar todos los cuidados
        System.out.println("----Cuidados ------------\n");
        protectora.mostrarCuidadosAnimales();

        //Buscar animal
        System.out.println("----Buscar Animal------------\n");
        protectora.buscarAnimal("Luna");

        // Mostrar cuantos animales tienen mas de dos vacunas
        System.out.println("---Animales con mas de dos vacunas----");
        for (Animal a : protectora.getAnimales()) {
            if (a.getVacunas().size() > 2) {
                System.out.println(a.getNombre());
            }
        }

        System.out.println("---animal con mayor coste de adopcion---");
        double costeMayor = 0;
        Animal animalMayorCoste = null;
        for (Animal a : protectora.getAnimales()) {
            double costeFinal = a.calcularCosteAdopcion();
            if (costeFinal > costeMayor) {
                costeMayor = costeFinal;
                animalMayorCoste = a;
            }
        }
        if (animalMayorCoste != null) {
            System.out.println("Animal: " + animalMayorCoste.getNombre() + " - Coste: " + costeMayor);
        }

        System.out.println("---Detalles Gatos---");
        for (Animal a : protectora.getAnimales()) {
            if (a instanceof Gato) {
                Gato gato = (Gato) a;
                System.out.println(gato.getNombre() + " - Color: " + gato.getColor());
                gato.mostrarDatos();
            }
        }
    }
}
