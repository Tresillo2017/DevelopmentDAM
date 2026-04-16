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

package u6.repaso.re4;

import java.util.ArrayList;

public class Rutina {
    private Maquina maquina;
    private ArrayList<Socio> socios;
    public static ArrayList<Rutina> listaRutinas = new ArrayList<>();

    public Rutina(Maquina maquina) {
        this.maquina = maquina;
        this.socios = new ArrayList<>();
    }

    public boolean agregarSocio(Socio s) {
        if (maquina.getZona().equals("fuerza") && ! (s.getAbono().equals("premium") || s.getAbono().equals("vip"))) {
            System.out.println("Error, tipo de abono no valido para esta zona");
            return false;
        }
        socios.add(s);
        return true;
    }

    public void mostrarSocios() {
        for (Socio s : socios) {
            System.out.println("Nombre: " + s.getNombre() + ", Edad " + s.getEdad() + ", Abono: " + s.getAbono());
        }
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }

    public static ArrayList<Rutina> getListaRutinas() {
        return listaRutinas;
    }

    public static void setListaRutinas(ArrayList<Rutina> listaRutinas) {
        Rutina.listaRutinas = listaRutinas;
    }

    @Override
    public String toString() {
        return "Rutina{" +
                "maquina=" + maquina +
                ", socios=" + socios +
                '}';
    }
}
