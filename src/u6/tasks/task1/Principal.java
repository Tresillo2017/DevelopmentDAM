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
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearPuesto();
                    break;
                case 2:
                    eliminarPuesto();
                    break;
                case 3:
                    reservarPuesto();
                    break;
                case 4:
                    listarOrdenadoresReservados();
                    break;
                case 5:
                    listarOrdenadoresDisponibles();
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n========== GESTIÓN DE SALA DE ORDENADORES ==========");
        System.out.println("1. Crear un puesto");
        System.out.println("2. Eliminar un puesto");
        System.out.println("3. Reservar un puesto");
        System.out.println("4. Listar los ordenadores reservados");
        System.out.println("5. Listar los ordenadores disponibles");
        System.out.println("6. Salir");
        System.out.println("====================================================");
    }

    private static void crearPuesto() {
        if (Puesto.contadorPuestos >= Puesto.listaOrdenadores.length) {
            System.out.println("No hay espacio para más puestos.");
            return;
        }

        System.out.print("Introduce el código del puesto: ");
        String codigo = scanner.nextLine();

        // Verificar si el código ya existe
        for (int i = 0; i < Puesto.contadorPuestos; i++) {
            if (Puesto.listaOrdenadores[i].getCodigo().equals(codigo)) {
                System.out.println("El código del puesto ya existe.");
                return;
            }
        }

        Puesto nuevoPuesto = new Puesto(codigo);
        Puesto.listaOrdenadores[Puesto.contadorPuestos] = nuevoPuesto;
        Puesto.contadorPuestos++;
        System.out.println("Puesto creado exitosamente.");
    }

    private static void eliminarPuesto() {
        System.out.print("Introduce el código del puesto a eliminar: ");
        String codigo = scanner.nextLine();

        int indice = buscarPuestoPorCodigo(codigo);
        if (indice == -1) {
            System.out.println("Puesto no encontrado.");
            return;
        }

        // Desplazar todos los elementos posteriores
        for (int i = indice; i < Puesto.contadorPuestos - 1; i++) {
            Puesto.listaOrdenadores[i] = Puesto.listaOrdenadores[i + 1];
        }
        Puesto.listaOrdenadores[Puesto.contadorPuestos - 1] = null;
        Puesto.contadorPuestos--;
        System.out.println("Puesto eliminado exitosamente.");
    }

    private static void reservarPuesto() {
        System.out.print("Introduce el código del puesto a reservar: ");
        String codigoPuesto = scanner.nextLine();

        int indice = buscarPuestoPorCodigo(codigoPuesto);
        if (indice == -1) {
            System.out.println("Puesto no encontrado.");
            return;
        }

        Puesto puesto = Puesto.listaOrdenadores[indice];

        if (puesto.isReservado()) {
            System.out.println("El puesto ya está reservado por: " + puesto.getPersona().getNombre());
            return;
        }

        System.out.print("Introduce el DNI de la persona: ");
        String DNI = scanner.nextLine();
        System.out.print("Introduce el nombre de la persona: ");
        String nombre = scanner.nextLine();

        Persona persona = new Persona(DNI, nombre);
        puesto.setReservado(true);
        puesto.setPersona(persona);
        System.out.println("Puesto reservado exitosamente.");
    }

    private static void listarOrdenadoresReservados() {
        boolean hayReservados = false;
        System.out.println("\n========== ORDENADORES RESERVADOS ==========");

        for (int i = 0; i < Puesto.contadorPuestos; i++) {
            Puesto puesto = Puesto.listaOrdenadores[i];
            if (puesto.isReservado()) {
                System.out.println(puesto);
                hayReservados = true;
            }
        }

        if (!hayReservados) {
            System.out.println("No hay ordenadores reservados.");
        }
        System.out.println("=============================================");
    }

    private static void listarOrdenadoresDisponibles() {
        boolean hayDisponibles = false;
        System.out.println("\n========== ORDENADORES DISPONIBLES ==========");

        for (int i = 0; i < Puesto.contadorPuestos; i++) {
            Puesto puesto = Puesto.listaOrdenadores[i];
            if (!puesto.isReservado()) {
                System.out.println(puesto);
                hayDisponibles = true;
            }
        }

        if (!hayDisponibles) {
            System.out.println("No hay ordenadores disponibles.");
        }
        System.out.println("=============================================");
    }

    private static int buscarPuestoPorCodigo(String codigo) {
        for (int i = 0; i < Puesto.contadorPuestos; i++) {
            if (Puesto.listaOrdenadores[i].getCodigo().equals(codigo)) {
                return i;
            }
        }
        return -1;
    }
}

