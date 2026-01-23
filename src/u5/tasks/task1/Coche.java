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

package u5.tasks.task1;

public class Coche {
    private String matricula;
    private String color;
    private boolean alerones;
    private String marca;
    private String modelo;
    private boolean alquilado;

    // Constructor por defecto
    public Coche() {
        this.matricula = "";
        this.color = "";
        this.alerones = false;
        this.marca = "";
        this.modelo = "";
        this.alquilado = false;
    }

    // Constructor con matrícula y estado de alquiler
    public Coche(String matricula, boolean alquilado) {
        this.matricula = matricula;
        this.alquilado = alquilado;
        this.color = "";
        this.alerones = false;
        this.marca = "";
        this.modelo = "";
    }

    // Constructor con todos los parámetros
    public Coche(String matricula, String color, boolean alerones, String marca, String modelo, boolean alquilado) {
        this.matricula = matricula;
        this.color = color;
        this.alerones = alerones;
        this.marca = marca;
        this.modelo = modelo;
        this.alquilado = alquilado;
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAlerones() {
        return alerones;
    }

    public void setAlerones(boolean alerones) {
        this.alerones = alerones;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", color='" + color + '\'' +
                ", alerones=" + alerones +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", alquilado=" + alquilado +
                '}';
    }
}

