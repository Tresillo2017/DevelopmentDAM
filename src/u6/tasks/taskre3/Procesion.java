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

package u6.tasks.taskre3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Procesion que representa una procesión de Semana Santa
 */
public class Procesion {
    // Atributos de instancia
    private String nombre;
    private String dia;
    private String hora;
    private int cupos;
    private ArrayList<Participante> listaParticipantes;

    // Variable global (a nivel de clase) - Array de procesiones
    private static Procesion[] procesiones2025 = null;

    /**
     * Constructor que recibe nombre, día, hora y cupos como parámetros
     * La lista de participantes se inicializa como un ArrayList vacío
     */
    public Procesion(String nombre, String dia, String hora, int cupos) {
        this.nombre = nombre;
        this.dia = dia;
        this.hora = hora;
        this.cupos = cupos;
        this.listaParticipantes = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public ArrayList<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(ArrayList<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public static Procesion[] getProcesiones2025() {
        return procesiones2025;
    }

    public static void setProcesiones2025(Procesion[] procesiones) {
        procesiones2025 = procesiones;
    }

    /**
     * Método toString() que devuelve la información de la procesión
     */
    @Override
    public String toString() {
        int participantesActuales = listaParticipantes.size();
        int cuposDisponibles = cupos - participantesActuales;

        return "╔════════════════════════════════════════════════════════════╗\n" +
               "  Procesión: " + nombre + "\n" +
               "  Día: " + dia + "\n" +
               "  Hora: " + hora + "\n" +
               "  Participantes: " + participantesActuales + "/" + cupos + "\n" +
               "  Cupos disponibles: " + cuposDisponibles + "\n" +
               "╚════════════════════════════════════════════════════════════╝";
    }

    /**
     * Método agregarParticipante que comprueba si hay cupos disponibles
     * Si los hay, solicita los datos del participante y lo añade a la lista
     */
    public void agregarParticipante(Scanner scanner) {
        // Comprobar si se ha alcanzado el límite de cupos
        if (listaParticipantes.size() >= cupos) {
            System.out.println("❌ No hay más espacio disponible en la procesión \"" + nombre + "\".");
            System.out.println("   Cupos alcanzados: " + cupos + "/" + cupos);
            return;
        }

        // Si hay espacio, solicitar datos del participante
        System.out.println("\n--- Añadir Participante ---");

        try {
            System.out.print("Nombre del participante: ");
            String nombreParticipante = scanner.nextLine();

            System.out.print("Rol (Nazareno, Costalero, Penitente, etc.): ");
            String rolParticipante = scanner.nextLine();

            // Crear y añadir el participante
            Participante nuevoParticipante = new Participante(nombreParticipante, rolParticipante);
            listaParticipantes.add(nuevoParticipante);

            System.out.println("✅ Participante \"" + nombreParticipante + "\" añadido exitosamente a \"" + nombre + "\".");

        } catch (Exception e) {
            System.out.println("❌ Error al añadir el participante: " + e.getMessage());
        }
    }

    /**
     * Método mostrarProcesion que muestra la información de la procesión
     */
    public void mostrarProcesion() {
        System.out.println(this.toString());
    }

    /**
     * Método mostrarParticipantes que recibe un rol como parámetro
     * Muestra todos los participantes con ese rol específico
     */
    public void mostrarParticipantes(String rol) {
        ArrayList<Participante> participantesConRol = new ArrayList<>();

        // Recorrer la lista y filtrar por rol
        for (Participante participante : listaParticipantes) {
            if (participante.getRol().equalsIgnoreCase(rol)) {
                participantesConRol.add(participante);
            }
        }

        // Mostrar resultados
        if (participantesConRol.isEmpty()) {
            System.out.println("❌ No hay participantes con el rol \"" + rol + "\" en la procesión \"" + nombre + "\".");
        } else {
            System.out.println("✅ Participantes con el rol \"" + rol + "\" en \"" + nombre + "\":");
            for (Participante participante : participantesConRol) {
                System.out.println("   • " + participante.getNombre());
            }
        }
    }

    /**
     * Método estático para inicializar las procesiones predefinidas
     */
    public static void inicializarProcesiones() {
        // Crear el array de procesiones
        procesiones2025 = new Procesion[2];

        // Primera Procesión: Procesión del Silencio
        Procesion procesion1 = new Procesion(
                "Procesión del Silencio",
                "Jueves Santo",
                "21:00",
                3
        );
        procesion1.agregarParticipanteDirecto(new Participante("Juan Pérez", "Costalero"));
        procesion1.agregarParticipanteDirecto(new Participante("María López", "Nazareno"));
        procesion1.agregarParticipanteDirecto(new Participante("Carlos Gómez", "Penitente"));
        procesiones2025[0] = procesion1;

        // Segunda Procesión: Procesión de la Esperanza
        Procesion procesion2 = new Procesion(
                "Procesión de la Esperanza",
                "Domingo de Ramos",
                "18:00",
                15
        );
        procesion2.agregarParticipanteDirecto(new Participante("Pepe Cano", "Costalero"));
        procesion2.agregarParticipanteDirecto(new Participante("Manolo García", "Penitente"));
        procesiones2025[1] = procesion2;
    }

    /**
     * Método auxiliar para añadir participantes directamente sin solicitar entrada
     * (usado en la inicialización)
     */
    private void agregarParticipanteDirecto(Participante participante) {
        if (listaParticipantes.size() < cupos) {
            listaParticipantes.add(participante);
        }
    }

    /**
     * Método estático para buscar una procesión por nombre
     */
    public static Procesion buscarProcesionPorNombre(String nombre) {
        if (procesiones2025 == null) {
            return null;
        }

        for (Procesion procesion : procesiones2025) {
            if (procesion.getNombre().equalsIgnoreCase(nombre)) {
                return procesion;
            }
        }
        return null;
    }

    /**
     * Método estático para buscar una procesión por día
     */
    public static Procesion buscarProcesionPorDia(String dia) {
        if (procesiones2025 == null) {
            return null;
        }

        for (Procesion procesion : procesiones2025) {
            if (procesion.getDia().equalsIgnoreCase(dia)) {
                return procesion;
            }
        }
        return null;
    }
}


