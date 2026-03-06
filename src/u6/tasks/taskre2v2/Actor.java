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

package u6.tasks.taskre2v2;

import java.time.Year;

/**
 * Clase Actor que representa un actor con sus atributos básicos
 */
public class Actor {
    // Atributos de instancia
    private String nombre;
    private int anyoNacimiento;
    private String nacionalidad;

    /**
     * Constructor con todos los atributos
     */
    public Actor(String nombre, int anyoNacimiento, String nacionalidad) {
        this.nombre = nombre;
        this.anyoNacimiento = anyoNacimiento;
        this.nacionalidad = nacionalidad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyoNacimiento() {
        return anyoNacimiento;
    }

    public void setAnyoNacimiento(int anyoNacimiento) {
        this.anyoNacimiento = anyoNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Calcula la edad del actor
     */
    public int getEdad() {
        int anyoActual = Year.now().getValue();
        return anyoActual - anyoNacimiento;
    }

    /**
     * Método toString() que devuelve la información del actor
     */
    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ", " + getEdad() + " años)";
    }

    /**
     * Método toString() detallado con más información
     */
    public String toStringDetallado() {
        return "    ├─ Actor: " + nombre + "\n" +
               "    │  Nacionalidad: " + nacionalidad + "\n" +
               "    │  Año de nacimiento: " + anyoNacimiento + "\n" +
               "    │  Edad: " + getEdad() + " años";
    }
}

