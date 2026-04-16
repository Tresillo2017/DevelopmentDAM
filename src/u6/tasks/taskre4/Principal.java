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

package u6.tasks.taskre4;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        // Create ArrayList to store all students
        ArrayList<Alumno> misAlumnos = new ArrayList<>();

        // Create first student: María López
        Alumno alumno1 = new Alumno("María López", 20);
        // Update the initial Programación note
        alumno1.getAsignaturas().get(0).setNota(8.5);
        alumno1.agregarAsignatura(new Asignatura("Bases de Datos", 7.0, 4));
        alumno1.agregarAsignatura(new Asignatura("Entornos de Desarrollo", 9.0, 3));
        misAlumnos.add(alumno1);

        // Create second student: Juan Pérez
        Alumno alumno2 = new Alumno("Juan Pérez", 21);
        // Update the initial Programación note
        alumno2.getAsignaturas().get(0).setNota(6.5);
        alumno2.agregarAsignatura(new Asignatura("Sistemas", 7.5, 5));
        alumno2.agregarAsignatura(new Asignatura("Lenguajes de Marcas", 8.0, 4));
        misAlumnos.add(alumno2);

        // Display students information
        System.out.println("=== INFORMACIÓN DE ALUMNOS ===\n");
        for (Alumno alumno : misAlumnos) {
            System.out.println(alumno.toString());
            System.out.println("Asignaturas:");
            for (Asignatura asignatura : alumno.getAsignaturas()) {
                System.out.println("- " + asignatura.toString());
            }
            System.out.println("Media: " + String.format("%.2f", alumno.calcularMedia()));
            System.out.println();
        }

        // Calculate and display general average
        double mediaGeneral = calcularMediaGeneral(misAlumnos);
        System.out.println("Media general del grupo: " + String.format("%.2f", mediaGeneral));

        // EXTRA Features
        System.out.println("\n=== INFORMACIÓN EXTRA ===\n");

        // Show subject with highest grade
        mostrarAsignaturaConMayorNota(misAlumnos);

        // Show student with highest average
        mostrarAlumnoConMayorMedia(misAlumnos);

        // Search for a student by name
        buscarAlumnoPorNombre(misAlumnos, "María López");
        buscarAlumnoPorNombre(misAlumnos, "Juan Pérez");
        buscarAlumnoPorNombre(misAlumnos, "Carlos López");
    }

    // Calculate general average of all students
    public static double calcularMediaGeneral(ArrayList<Alumno> alumnos) {
        if (alumnos.isEmpty()) {
            return 0;
        }
        double sumaTotales = 0;
        int conteoAsignaturas = 0;
        for (Alumno alumno : alumnos) {
            for (Asignatura asignatura : alumno.getAsignaturas()) {
                sumaTotales += asignatura.getNota();
                conteoAsignaturas++;
            }
        }
        return sumaTotales / conteoAsignaturas;
    }

    // Show subject with highest grade across all students
    public static void mostrarAsignaturaConMayorNota(ArrayList<Alumno> alumnos) {
        double maxNota = -1;
        Asignatura asignaturaMax = null;
        String alumnoNombre = "";

        for (Alumno alumno : alumnos) {
            for (Asignatura asignatura : alumno.getAsignaturas()) {
                if (asignatura.getNota() > maxNota) {
                    maxNota = asignatura.getNota();
                    asignaturaMax = asignatura;
                    alumnoNombre = alumno.getNombre();
                }
            }
        }

        if (asignaturaMax != null) {
            System.out.println("Asignatura con mayor nota: " + asignaturaMax.toString()
                    + " (Alumno: " + alumnoNombre + ")");
        }
    }

    // Show student with highest average
    public static void mostrarAlumnoConMayorMedia(ArrayList<Alumno> alumnos) {
        double maxMedia = -1;
        Alumno alumnoMax = null;

        for (Alumno alumno : alumnos) {
            double media = alumno.calcularMedia();
            if (media > maxMedia) {
                maxMedia = media;
                alumnoMax = alumno;
            }
        }

        if (alumnoMax != null) {
            System.out.println("Alumno con mayor media: " + alumnoMax.getNombre()
                    + " (Media: " + String.format("%.2f", maxMedia) + ")");
        }
    }

    // Search for a student by name
    public static void buscarAlumnoPorNombre(ArrayList<Alumno> alumnos, String nombre) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("\nBúsqueda: \"" + nombre + "\"");
                System.out.println(alumno.toString());
                System.out.println("Asignaturas:");
                for (Asignatura asignatura : alumno.getAsignaturas()) {
                    System.out.println("- " + asignatura.toString());
                }
                System.out.println("Media: " + String.format("%.2f", alumno.calcularMedia()));
                return;
            }
        }
        System.out.println("\nBúsqueda: \"" + nombre + "\" - Alumno no encontrado");
    }
}


