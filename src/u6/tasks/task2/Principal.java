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

package u6.tasks.task2;

public class Principal {
    public static void main(String[] args) {
        // Crear músicos para el primer grupo
        Musico musico1 = new Musico("Freddie Mercury", 45, "Vocalista");
        Musico musico2 = new Musico("Brian May", 48, "Guitarrista");
        Musico musico3 = new Musico("Roger Taylor", 46, "Baterista");
        Musico musico4 = new Musico("John Deacon", 44, "Bajista");

        // Crear músicos para el segundo grupo
        Musico musico5 = new Musico("Kurt Cobain", 27, "Vocalista");
        Musico musico6 = new Musico("Krist Novoselic", 28, "Bajista");
        Musico musico7 = new Musico("Dave Grohl", 23, "Baterista");

        // Crear arrays de componentes
        Musico[] componentesQueen = {musico1, musico2, musico3, musico4};
        Musico[] componentesNirvana = {musico5, musico6, musico7};

        // Crear dos grupos musicales
        GrupoMusical grupo1 = new GrupoMusical("Queen", componentesQueen, "https://www.queenonline.com", 1970);
        GrupoMusical grupo2 = new GrupoMusical("Nirvana", componentesNirvana, "https://www.nirvana.com", 1987);

        // Almacenar los dos grupos en un array
        GrupoMusical[] listaGrupos = {grupo1, grupo2};

        // Mostrar la información completa de los grupos
        System.out.println("========== LISTA DE GRUPOS MUSICALES ==========");
        for (int i = 0; i < listaGrupos.length; i++) {
            System.out.println(listaGrupos[i]);
            System.out.println("-----------------------------------------------");
        }
        System.out.println("================================================");
    }
}
