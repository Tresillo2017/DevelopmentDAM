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

package u6.repaso.re2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. 4 estudiantes
        Estudiante e1 = new Estudiante("Ana", 20, "principiante");
        Estudiante e2 = new Estudiante("Luis", 25, "principiante");
        Estudiante e3 = new Estudiante("Maria", 30, "intermedio");
        Estudiante e4 = new Estudiante("Pedro", 35, "avanzado");

        // 2. 2 cursos
        Curso c1 = new Curso("Java Básico", 40.0, "principiante");
        Curso c2 = new Curso("Spring Avanzado", 80.0, "avanzado");

        // 3. 2 grupos + añadir a listaGrupos
        Grupo g1 = new Grupo(c1);
        Grupo g2 = new Grupo(c2);
        Grupo.listaGrupos.add(g1);
        Grupo.listaGrupos.add(g2);

        // 4. Añadir estudiantes (probar lógica)
        g1.agregarEstudiante(e1);  // OK
        g1.agregarEstudiante(e3);  // OK
        g2.agregarEstudiante(e2);  // NO: avanzado + principiante
        g2.agregarEstudiante(e4);  // OK

        // 5. Mostrar todos los grupos
        System.out.println("=== INFO GRUPOS ===");
        for (Grupo g : Grupo.listaGrupos) {
            System.out.println("Curso: " + g.getCurso().getNombreCurso());
            System.out.println("Duracion " + g.getCurso().getDuracionHoras());
            System.out.println("Nivel " + g.getCurso().getNivelRequerido());
            System.out.println("Estudiantes");
            g.mostrarEstudiantes();
            System.out.println("-------------------");
        }

        // 6. Curso con estudiante <18 y nivel intermedio/avanzado
        System.out.println("\n=== CURSO CON ESTUDIANTE <18 ===");
        for (Grupo g : Grupo.listaGrupos) {
            for (Estudiante e : g.getEstudiantes()) {
                if (e.getEdad() < 18 && (g.getCurso().getNivelRequerido().equals("intermedio")) || g.getCurso().getNivelRequerido().equals("avanzado") ){
                    System.out.println("Curso: " + g.getCurso().getNombreCurso());
                    break;
                }
            }
        }

        // 7. Grupo con MAS estudiantes
        System.out.println("\n=== GROUPO CON MAS ESTUDIANTES ===");
        Grupo maxG = null;
        int maxEst = -1;
        for (Grupo g : Grupo.listaGrupos) {
            int tam = g.getEstudiantes().size();
            if (tam > maxEst) {
                maxEst = tam;
                maxG = g;
            }
            if (maxG != null) {
                System.out.println("Curso: " + maxG.getCurso().getNombreCurso());
                System.out.println("Estudiantes: " + maxEst);
                maxG.mostrarEstudiantes();
            }
        }

        // 8. Conteo nivel avanzado
        System.out.println("\n=== ESTUDIANTES AVANZADOS ===");
        int countAv = 0;
        for (Grupo g : Grupo.listaGrupos) {
            for (Estudiante e : g.getEstudiantes()) {
                if (e.getNivel().equals("avanzado")) {
                    countAv++;
                    System.out.println(e.getNombre() + " (" + e.getEdad() + ") ");
                }
            }
            System.out.println("Total: " + countAv);
        }
    }
}
