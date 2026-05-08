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

import java.util.ArrayList;

public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int velocidad;
    protected static final ArrayList<Vehiculo> misVehiculos = new ArrayList<>();

    protected Vehiculo(String marca, String modelo, int velocidad) {
        this.marca = normalizarTexto(marca, "Desconocida");
        this.modelo = normalizarTexto(modelo, "Desconocido");
        this.velocidad = Math.max(0, velocidad);
    }

    public abstract void mostrarInfo();

    public static void agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            misVehiculos.add(vehiculo);
        }
    }

    public static void mostrarVehiculos() {
        if (misVehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }

        System.out.println("=== LISTA DE VEHICULOS ===");
        for (Vehiculo vehiculo : misVehiculos) {
            vehiculo.mostrarInfo();
            System.out.println("--------------------------");
        }
    }

    protected static String normalizarTexto(String valor, String defecto) {
        if (valor == null) {
            return defecto;
        }

        String texto = valor.trim();
        return texto.isEmpty() ? defecto : texto;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getVelocidad() {
        return velocidad;
    }
}



