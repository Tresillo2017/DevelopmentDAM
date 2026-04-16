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

package u6.repaso.re7;

public class Main {
    public static void main(String[] args) {
        Medico med1 = new Medico("Dr. García", "general", 10);
        Medico med2 = new Medico("Dra. López", "urgencias", 15);
        Medico med3 = new Medico("Dr. Martínez", "pediatra", 8);
        Medico med4 = new Medico("Dra. Sánchez", "traumatologo", 12);

        Paciente pac1 = new Paciente("Juan", 45, "baja");
        Paciente pac2 = new Paciente("Maria", 72, "alta");
        Paciente pac3 = new Paciente("Pedro", 30, "media");
        Paciente pac4 = new Paciente("Ana", 68, "alta");

        Cita cita1 = new Cita(med1);
        Cita cita2 = new Cita(med2);

        Cita.listaCitas.add(cita1);
        Cita.listaCitas.add(cita2);

        cita1.agregarPaciente(pac1);
        cita1.agregarPaciente(pac2);

        cita2.agregarPaciente(pac3);
        cita2.agregarPaciente(pac4);

        // 1. Cada cita (nombre del medico, especialidad, lista de pacientes)
        for (Cita c : Cita.listaCitas) {
            System.out.println("Nombre medico: " + c.getMedico().getNombre());
            System.out.println("Especialidad: " + c.getMedico().getEspecialidad());
            System.out.println("Lista de pacientes:");
            c.mostrarPacientes();
            System.out.println("-----------------");
        }

        // 2. Medico con paciente de urgencia alta
        for (Cita c : Cita.listaCitas) {
            for (Paciente p : c.getPacientes()) {
                if (p.getUrgencia().equals("alta")) {
                    System.out.println("Medico: " + c.getMedico().getNombre());
                }
            }
        }

        // 3. Cita con mas pacientes
        int numPacientes = -1;
        Cita maxCita = null;

        for (Cita c : Cita.listaCitas) {
            int tam = c.getPacientes().size();

            if (tam > numPacientes) {
                numPacientes = tam;
                maxCita = c;
            }
        }
        System.out.println("Cita: " + maxCita.getMedico().getNombre());

        // 4. Cuantos pacientes >65 (mostrar nombre, urgencia)
        int cont = 0;
        for (Cita c : Cita.listaCitas) {
            for (Paciente p : c.getPacientes()) {
                if (p.getEdad() > 65) {
                    cont++;
                    System.out.println("Nombre: " + p.getNombre() + " (" + p.getUrgencia() + ") ");
                }
            }
        }
        System.out.println("Hay un total de " + cont + " pacientes de >65");
    }
}



