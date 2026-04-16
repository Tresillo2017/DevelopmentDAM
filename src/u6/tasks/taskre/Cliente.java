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

package u6.tasks.taskre;

public class Cliente {

    private String nombre;
    private String telefono;
    private String tipoPelo;
    private boolean peloCortado;

    // Constructor que recibe nombre, telefono y tipoPelo. peloCortado se inicia a false.
    public Cliente(String nombre, String telefono, String tipoPelo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoPelo = tipoPelo;
        this.peloCortado = false;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipoPelo() {
        return tipoPelo;
    }

    public boolean isPeloCortado() {
        return peloCortado;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipoPelo(String tipoPelo) {
        this.tipoPelo = tipoPelo;
    }

    public void setPeloCortado(boolean peloCortado) {
        this.peloCortado = peloCortado;
    }

    // Valida que el tipo de pelo sea uno de los valores permitidos: ondulado, rizado, liso
    public static boolean validarTipoPelo(String tipoPelo) {
        return (
            tipoPelo.equalsIgnoreCase("ondulado") ||
            tipoPelo.equalsIgnoreCase("rizado") ||
            tipoPelo.equalsIgnoreCase("liso")
        );
    }

    // toString
    @Override
    public String toString() {
        return (
            "Cliente{" +
            "nombre='" +
            nombre +
            '\'' +
            ", telefono='" +
            telefono +
            '\'' +
            ", tipoPelo='" +
            tipoPelo +
            '\'' +
            ", peloCortado=" +
            peloCortado +
            '}'
        );
    }
}
