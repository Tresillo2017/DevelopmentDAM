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

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

        String opcion;

        do {
            System.out.print("\nIntroduce el nombre de un grupo musical (o 'salir' para terminar): ");
            String nombreBuscado = scanner.nextLine();

            if (nombreBuscado.equalsIgnoreCase("salir")) {
                break;
            }

            // Buscar el grupo en la lista
            GrupoMusical grupoEncontrado = null;
            for (int i = 0; i < listaGrupos.length; i++) {
                if (listaGrupos[i].getNombreGrupo().equalsIgnoreCase(nombreBuscado)) {
                    grupoEncontrado = listaGrupos[i];
                    break;
                }
            }

            if (grupoEncontrado != null) {
                System.out.println("\n========== " + grupoEncontrado.getNombreGrupo() + " ==========");
                System.out.println("Componentes del grupo:");
                grupoEncontrado.mostrarNombresMusicos();
                System.out.println("Edad media de los componentes: " + grupoEncontrado.calcularEdadMedia());
                System.out.println("==========================================");
            } else {
                System.out.println("El grupo '" + nombreBuscado + "' no existe en la lista.");
            }

            System.out.print("\n¿Deseas buscar otro grupo? (s/n): ");
            opcion = scanner.nextLine();

        } while (opcion.equalsIgnoreCase("s"));

        System.out.println("¡Hasta luego!");
        scanner.close();
    }
}
