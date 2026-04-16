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

package u6.repaso.re6;

import java.util.ArrayList;

public class Comanda {
    private Mesa mesa;
    private ArrayList<Camarero> camareros;

    public static ArrayList<Comanda> listaComandas = new ArrayList<>();

    public Comanda(Mesa mesa) {
        this.mesa = mesa;
        this.camareros = new ArrayList<>();
    }

    public boolean agregarCamarero(Camarero c) {
        if (mesa.getUbicacion().equals("terraza") && c.getExperiencia() < 5) {
            System.out.println("Error, el camarero no tiene la suficiente experiencia");
            return false;
        }
        camareros.add(c);
        return true;
    }

    public void mostrarCamareros() {
        for (Camarero c : camareros) {
            System.out.println("Nombre: " + c.getNombre() + ", Turno: " + c.getTurno() + ", Experiencia: " + c.getExperiencia());
        }
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public ArrayList<Camarero> getCamareros() {
        return camareros;
    }

    public void setCamareros(ArrayList<Camarero> camareros) {
        this.camareros = camareros;
    }

    public static ArrayList<Comanda> getListaComandas() {
        return listaComandas;
    }

    public static void setListaComandas(ArrayList<Comanda> listaComandas) {
        Comanda.listaComandas = listaComandas;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "mesa=" + mesa +
                ", camareros=" + camareros +
                '}';
    }
}
