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

package u6.tasks.task1;

public class Puesto {
    private String codigo;
    private boolean reservado;
    private Persona persona;

    // Static array to store all computers
    public static Puesto[] listaOrdenadores = new Puesto[20];
    public static int contadorPuestos = 0;

    // Constructor
    public Puesto(String codigo) {
        this.codigo = codigo;
        this.reservado = false;
        this.persona = null;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public boolean isReservado() {
        return reservado;
    }

    public Persona getPersona() {
        return persona;
    }

    // Setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    // toString
    @Override
    public String toString() {
        return "Puesto{" +
                "codigo='" + codigo + '\'' +
                ", reservado=" + reservado +
                ", persona=" + (persona != null ? persona.toString() : "null") +
                '}';
    }
}

