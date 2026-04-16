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

public class Main {
    public static void main(String[] args) {
        // 1. Crear 4 senderistas
        Senderista s1 = new Senderista("Ana", 25, "baja");
        Senderista s2 = new Senderista("Luis", 30, "baja");
        Senderista s3 = new Senderista("Maria", 45, "media");
        Senderista s4 = new Senderista("Pedro", 55, "alta");

        // 2. Crear 2 rutas
        Ruta ruta1 = new Ruta("Ruta del Bosque", 8.0, "facil");
        Ruta ruta2 = new Ruta("Ruta de la Cueva", 15.0, "dificil");

        // 3. Crear 2 excursiones
        Excursion exc1 = new Excursion(ruta1);
        Excursion exc2 = new Excursion(ruta2);

        // 4. Añadir a listaExcursiones (IMPORTANTE)
        Excursion.listaExcursiones.add(exc1);
        Excursion.listaExcursiones.add(exc2);

        // 5. Añadir senderistas
        exc1.agregarSenderista(s1);  // OK: facil
        exc1.agregarSenderista(s3);  // OK: facil
        exc2.agregarSenderista(s2);  // NO: dificil + baja
        exc2.agregarSenderista(s4);  // OK: dificil + alta

        // 6. MOSTRAR INFO DE CADA EXCURSIÓN
        System.out.println("=== INFO EXCURSIONES ===");
        for (Excursion e : Excursion.listaExcursiones) {
            System.out.println("Ruta: " + e.getRuta().getNombreRuta());
            System.out.println("Distancia: " + e.getRuta().getDistanciaKm() + " km");
            System.out.println("Dificultad: " + e.getRuta().getDificultad());
            System.out.println("Participantes:");
            e.mostrarParticipantes();
            System.out.println("-------------------");
        }

        // 7. Ruta con participante >60 años Y dificultad media/dificil
        System.out.println("\n=== RUTA CON PARTICIPANTE >60 ===");
        for (Excursion e : Excursion.listaExcursiones) {
            for (Senderista s : e.getParticipantes()) {
                if (s.getEdad() > 60 &&
                        (e.getRuta().getDificultad().equals("media") ||
                                e.getRuta().getDificultad().equals("dificil"))) {
                    System.out.println("Ruta: " + e.getRuta().getNombreRuta());
                    break;
                }
            }
        }

        // 8. Excursión con MÁS participantes
        System.out.println("\n=== EXCURSIÓN CON MÁS PARTICIPANTES ===");
        Excursion maxExc = null;
        int maxParticipantes = -1;
        for (Excursion e : Excursion.listaExcursiones) {
            int tam = e.getParticipantes().size();
            if (tam > maxParticipantes) {
                maxParticipantes = tam;
                maxExc = e;
            }
        }
        if (maxExc != null) {
            System.out.println("Ruta: " + maxExc.getRuta().getNombreRuta());
            System.out.println("Participantes: " + maxParticipantes);
            maxExc.mostrarParticipantes();
        }

        // 9. Conteo senderistas experiencia ALTA
        System.out.println("\n=== SENDERISTAS EXPERIENCIA ALTA ===");
        int countAlta = 0;
        for (Excursion e : Excursion.listaExcursiones) {
            for (Senderista s : e.getParticipantes()) {
                if (s.getExperiencia().equals("alta")) {
                    countAlta++;
                    System.out.println(s.getNombre() + " (" + s.getEdad() + " años)");
                }
            }
        }
        System.out.println("Total: " + countAlta);
    }
}