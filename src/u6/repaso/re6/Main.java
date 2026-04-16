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

public class Main {
    public static void main(String[] args) {
        Camarero cam1 = new Camarero("Ana", 2, "mañana");
        Camarero cam2 = new Camarero("Luis", 3, "tarde");
        Camarero cam3 = new Camarero("Maria", 6, "noche");
        Camarero cam4 = new Camarero("Pedro", 8, "noche");

        Mesa m1 = new Mesa(1, 4, "interior");
        Mesa m2 = new Mesa(2, 6, "terraza");
        Mesa m3 = new Mesa(3, 2, "barra");

        Comanda c1 = new Comanda(m1);
        Comanda c2 = new Comanda(m2);
        Comanda.listaComandas.add(c1);
        Comanda.listaComandas.add(c2);

        c1.agregarCamarero(cam1);  // interior → OK
        c1.agregarCamarero(cam3);  // interior → OK

        c2.agregarCamarero(cam1);  // terraza + experiencia 2 < 5 → ERROR
        c2.agregarCamarero(cam4);  // terraza + experiencia 8 ≥ 5 → OK




        // 1. Recorrer listaComandas para mostrar, numero mesa, ubicacion, lista de camareros
        for (Comanda c : Comanda.listaComandas) {
            System.out.println("Numero Mesa: " + c.getMesa().getNumeroMesa());
            System.out.println("Ubicacion: " + c.getMesa().getUbicacion());
            System.out.println("Camareros:");
            c.mostrarCamareros();
            System.out.println("----------------");
        }


        // 2. Mostar la mesa que tenga algun camarero de turno `noche`.
        for (Comanda c : Comanda.listaComandas) {
            for (Camarero ca : c.getCamareros()) {
                if (ca.getTurno().equals("noche")) {
                    System.out.println("Mesa: " + c.getMesa());
                }
            }
        }
        // 3. Mostar la comanda con mayor numero de camareros.
        int numCamareros = -1;
        Comanda maxComanda = null;

        for (Comanda c : Comanda.listaComandas) {
            int tam = c.getCamareros().size();

            if (tam > numCamareros) {
                numCamareros = tam;
                maxComanda = c;
            }

            System.out.println("Comanda: " + maxComanda.getMesa().getNumeroMesa());
        }
        System.out.println("Numero de camareros: " + numCamareros);

        // 4. Indicar cuantos camareros tiene experiencia >3 (ademas mostrar, nombre y turno)
        int cont = 0;
        for (Comanda c : Comanda.listaComandas) {
            for (Camarero ca : c.getCamareros()) {
                if (ca.getExperiencia() > 3) {
                    cont++;
                    System.out.println("Nombre: " + ca.getNombre() + " Turno: " + ca.getTurno());
                }
            }
        }
        System.out.println("Hay un total de: " + cont + " camareros.");
    }
}
