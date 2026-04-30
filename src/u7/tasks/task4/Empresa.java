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

package u7.tasks.task4;

public class Empresa {
    public static void main(String[] args) {
        if (args == null) {
            return;
        }

        // Crear 4 empleados ficticios (2 programadores y 2 diseñadores)
        Programador prog1 = new Programador("Juan García", 35, 40000, "Java");
        Programador prog2 = new Programador("María López", 52, 55000, "Python");

        Disenador dis1 = new Disenador("Carlos Martínez", 28, 30000, "Figma");
        Disenador dis2 = new Disenador("Ana Rodríguez", 45, 35000, "Adobe XD");

        // Guardar en el array de empleados
        Empleado.addEmpleado(prog1);
        Empleado.addEmpleado(prog2);
        Empleado.addEmpleado(dis1);
        Empleado.addEmpleado(dis2);

        // Mostrar menú
        mostrarMenu();
    }

    private static void mostrarMenu() {
        System.out.println("===========================================");
        System.out.println("         INFORMACIÓN DE EMPLEADOS");
        System.out.println("===========================================\n");

        mostrarTodosLosEmpleados();
        System.out.println();

        contarEmpleadosPorTipo();
        System.out.println();

        mostrarProgramadoresCondicionados();
    }

    private static void mostrarTodosLosEmpleados() {
        System.out.println("--- LISTADO DE TODOS LOS EMPLEADOS ---\n");

        Empleado[] empleados = Empleado.getEmpleados();
        int total = Empleado.getTotalEmpleados();

        if (total == 0) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        for (int i = 0; i < total; i++) {
            Empleado emp = empleados[i];
            if (emp != null) {
                System.out.println((i + 1) + ".- ");
                emp.mostrarDatos();
                System.out.println("Salario Calculado: " + emp.calcularSalario() + " €");
                System.out.println();
            }
        }
    }

    private static void contarEmpleadosPorTipo() {
        System.out.println("--- RECUENTO DE EMPLEADOS POR TIPO ---\n");

        int contProgramadores = 0;
        int contDisenadores = 0;

        Empleado[] empleados = Empleado.getEmpleados();
        int total = Empleado.getTotalEmpleados();

        for (int i = 0; i < total; i++) {
            Empleado emp = empleados[i];
            if (emp instanceof Programador) {
                contProgramadores++;
            } else if (emp instanceof Disenador) {
                contDisenadores++;
            }
        }

        System.out.println("Total Programadores: " + contProgramadores);
        System.out.println("Total Diseñadores: " + contDisenadores);
    }

    private static void mostrarProgramadoresCondicionados() {
        System.out.println("--- PROGRAMADORES MAYORES DE 50 AÑOS CON SALARIO > 50000€ ---\n");

        boolean encontrado = false;
        Empleado[] empleados = Empleado.getEmpleados();
        int total = Empleado.getTotalEmpleados();

        for (int i = 0; i < total; i++) {
            Empleado emp = empleados[i];
            if (emp instanceof Programador prog) {
                if (prog.getEdad() > 50 && prog.calcularSalario() > 50000) {
                    System.out.println("Nombre: " + prog.getNombre());
                    System.out.println("Salario Calculado: " + prog.calcularSalario() + " €");
                    System.out.println();
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No hay programadores que cumplan con estos criterios.");
        }
    }
}

