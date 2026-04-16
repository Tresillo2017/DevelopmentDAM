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

public class Grupo {
    private Curso curso;
    private ArrayList<Estudiante> estudiantes;
    public static ArrayList<Grupo> listaGrupos = new ArrayList<>();

    public Grupo(Curso curso) {
        this.curso = curso;
        this.estudiantes = new ArrayList<>();
    }

    public boolean agregarEstudiante(Estudiante estudiante) {
        if (curso.getNivelRequerido().equals("avanzado") && !estudiante.getNivel().equals("avanzado")) {
            System.out.println("Nivel Insuficiente");
            return false;
        }
        estudiantes.add(estudiante);
        return true;
    }

    public void mostrarEstudiantes() {
        for (Estudiante e : estudiantes) {
            System.out.println(e.getNombre() + " - " + e.getEdad() + " años - " + e.getNivel());
        }
    }


    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public static ArrayList<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    public static void setListaGrupos(ArrayList<Grupo> listaGrupos) {
        Grupo.listaGrupos = listaGrupos;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "curso=" + curso +
                ", estudiantes=" + estudiantes +
                '}';
    }
}
