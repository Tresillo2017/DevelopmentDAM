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

package u7.tasks.task8;

public class Main {
    public static void main(String[] args) {
        Coche coche1 = new Coche("Toyota", "Corolla", 120, 4);
        Coche coche2 = new Coche("Seat", "Leon", 140, 5);
        Coche coche3 = new Coche("BMW", "Serie 3", 160, 4);

        Moto moto1 = new Moto("Yamaha", "MT-07", 90, true);
        Moto moto2 = new Moto("Honda", "CBR500R", 110, true);
        Moto moto3 = new Moto("Kawasaki", "Z900", 130, false);

        Vehiculo.agregarVehiculo(coche1);
        Vehiculo.agregarVehiculo(coche2);
        Vehiculo.agregarVehiculo(coche3);
        Vehiculo.agregarVehiculo(moto1);
        Vehiculo.agregarVehiculo(moto2);
        Vehiculo.agregarVehiculo(moto3);

        Vehiculo.mostrarVehiculos();

        System.out.println("=== ACCIONES DE CONDUCCION ===");
        for (Vehiculo vehiculo : Vehiculo.misVehiculos) {
            if (vehiculo instanceof Conducible) {
                Conducible conducible = (Conducible) vehiculo;
                conducible.arrancar();
                conducible.frenar();
            }
        }
    }
}


