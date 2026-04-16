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

package u6.repaso.re1;

import java.util.ArrayList;
public class Excursion {
    private Ruta ruta;
    private ArrayList<Senderista> participantes;

    public static ArrayList<Excursion> listaExcursiones = new ArrayList<>();

    public Excursion(Ruta ruta) {
        this.ruta = ruta;
        this.participantes = new ArrayList<>();
    }

    public boolean agregarSenderista(Senderista senderista) {
        if (ruta.getDificultad().equals("dificil") && senderista.getExperiencia().equals("baja")) {
            System.out.println("No puede realizar esa excursion: experiencia baja");
            return false;
        }
        participantes.add(senderista);
        return true;
    }

    public void mostrarParticipantes() {
        for (Senderista s: participantes) {
            System.out.println("Nombre: " + s.getNombre() +
                ", Edad: " + s.getEdad() +
                    ", Experiencia: " + s.getExperiencia()
            );
        }
    }

    public static ArrayList<Excursion> getListaExcursiones() {
        return listaExcursiones;
    }

    public static void setListaExcursiones(ArrayList<Excursion> listaExcursiones) {
        Excursion.listaExcursiones = listaExcursiones;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public ArrayList<Senderista> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Senderista> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "ruta=" + ruta +
                ", participantes=" + participantes +
                '}';
    }
}
