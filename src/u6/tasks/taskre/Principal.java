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

package u6.tasks.taskre;

import java.util.Scanner;

public class Principal {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Crear una única peluquería con datos ficticios
        Peluqueria peluqueria = new Peluqueria(
            "Peluquería Estilo",
            "Calle Mayor 12, Madrid"
        );

        // Crear algunos clientes por defecto y añadirlos a la peluquería
        peluqueria.getClientes().add(
            new Cliente("Laura García", "612345678", "liso")
        );
        peluqueria.getClientes().add(
            new Cliente("Carlos Ruiz", "698765432", "rizado")
        );
        peluqueria.getClientes().add(
            new Cliente("María López", "654321987", "ondulado")
        );

        int opcion;

        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir salto de línea
            } catch (Exception e) {
                scanner.nextLine(); // Limpiar buffer
                System.out.println("Error: Debes introducir un número.");
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    crearCliente(peluqueria);
                    break;
                case 2:
                    cortarPelo(peluqueria);
                    break;
                case 3:
                    listarClientes(peluqueria, true);
                    break;
                case 4:
                    listarClientes(peluqueria, false);
                    break;
                case 5:
                    eliminarCliente(peluqueria);
                    break;
                case 6:
                    System.out.println(
                        "¡Gracias por visitar " +
                        peluqueria.getNombre() +
                        "! ¡Hasta pronto!"
                    );
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n========== GESTIÓN DE PELUQUERÍA ==========");
        System.out.println("1) Crear cliente.");
        System.out.println("2) Cortar pelo.");
        System.out.println("3) Listar con pelo cortado.");
        System.out.println("4) Listar con pelo sin cortar.");
        System.out.println("5) Eliminar cliente.");
        System.out.println("6) Salir.");
        System.out.println("=============================================");
    }

    // Valida que el tipo de pelo sea uno de los valores permitidos
    private static boolean validarTipoPelo(String tipoPelo) {
        return (
            tipoPelo.equalsIgnoreCase("ondulado") ||
            tipoPelo.equalsIgnoreCase("rizado") ||
            tipoPelo.equalsIgnoreCase("liso")
        );
    }

    // Opción 1: Crear un nuevo cliente y añadirlo a la peluquería
    private static void crearCliente(Peluqueria peluqueria) {
        System.out.print("Introduce el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduce el teléfono del cliente: ");
        String telefono = scanner.nextLine();

        String tipoPelo;
        do {
            System.out.print(
                "Introduce el tipo de pelo (ondulado, rizado, liso): "
            );
            tipoPelo = scanner.nextLine();
            if (!validarTipoPelo(tipoPelo)) {
                System.out.println(
                    "Tipo de pelo no válido. Los valores posibles son: ondulado, rizado, liso."
                );
            }
        } while (!validarTipoPelo(tipoPelo));

        Cliente nuevoCliente = new Cliente(nombre, telefono, tipoPelo);
        peluqueria.getClientes().add(nuevoCliente);
        System.out.println("Cliente creado y añadido exitosamente.");
    }

    // Opción 2: Cortar el pelo de un cliente buscándolo por teléfono
    private static void cortarPelo(Peluqueria peluqueria) {
        System.out.print(
            "Introduce el teléfono del cliente: "
        );
        String telefono = scanner.nextLine();

        for (int i = 0; i < peluqueria.getClientes().size(); i++) {
            if (
                peluqueria
                    .getClientes()
                    .get(i)
                    .getTelefono()
                    .equals(telefono)
            ) {
                peluqueria.getClientes().get(i).setPeloCortado(true);
                System.out.println(
                    "Se ha cortado el pelo a " +
                    peluqueria.getClientes().get(i).getNombre() +
                    "."
                );
                return;
            }
        }

        System.out.println(
            "No se ha encontrado ningún cliente con el teléfono " +
            telefono +
            "."
        );
    }

    // Opciones 3 y 4: Método dedicado para listar clientes según el estado del pelo
    // Si peloCortado es true, lista los clientes con pelo cortado (opción 3)
    // Si peloCortado es false, lista los clientes con pelo sin cortar (opción 4)
    private static void listarClientes(
        Peluqueria peluqueria,
        boolean peloCortado
    ) {
        String estado = peloCortado ? "pelo cortado" : "pelo sin cortar";
        System.out.println(
            "\n========== CLIENTES CON " + estado.toUpperCase() + " =========="
        );

        boolean encontrado = false;

        for (int i = 0; i < peluqueria.getClientes().size(); i++) {
            if (peluqueria.getClientes().get(i).isPeloCortado() == peloCortado) {
                System.out.println(peluqueria.getClientes().get(i).toString());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println(
                "No hay clientes con " + estado + "."
            );
        }

        System.out.println("=============================================");
    }

    // Opción 5: Eliminar un cliente buscándolo por teléfono
    private static void eliminarCliente(Peluqueria peluqueria) {
        System.out.print(
            "Introduce el teléfono del cliente a eliminar: "
        );
        String telefono = scanner.nextLine();

        for (int i = 0; i < peluqueria.getClientes().size(); i++) {
            if (
                peluqueria
                    .getClientes()
                    .get(i)
                    .getTelefono()
                    .equals(telefono)
            ) {
                String nombreEliminado = peluqueria
                    .getClientes()
                    .get(i)
                    .getNombre();
                peluqueria.getClientes().remove(i);
                System.out.println(
                    "Cliente " +
                    nombreEliminado +
                    " eliminado exitosamente."
                );
                return;
            }
        }

        System.out.println(
            "No se ha encontrado ningún cliente con el teléfono " +
            telefono +
            "."
        );
    }
}
