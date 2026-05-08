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

package u9.tasks.task1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ClienteDAO dao;
    private static Scanner scanner;

    public static void main(String[] args) {
        try {
            dao = new ClienteDAO();
            scanner = new Scanner(System.in);
            mostrarMenu();
        } catch (SQLException e) {
            System.err.println("Error de conexion a la base de datos: " + e.getMessage());
        } finally {
            if (dao != null) {
                dao.cerrar();
            }
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n========== MENU PRINCIPAL ==========");
            System.out.println("1. Mostrar todos los clientes");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Anadir cliente");
            System.out.println("4. Modificar telefono de un cliente");
            System.out.println("5. Buscar clientes por apellido");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = leerOpcion();
            System.out.println();

            try {
                switch (opcion) {
                    case 1:
                        mostrarTodosClientes();
                        break;
                    case 2:
                        eliminarCliente();
                        break;
                    case 3:
                        anadirCliente();
                        break;
                    case 4:
                        modificarTelefono();
                        break;
                    case 5:
                        buscarPorApellido();
                        break;
                    case 6:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion invalida. Intente de nuevo.");
                }
            } catch (SQLException e) {
                System.err.println("Error en la operacion: " + e.getMessage());
            }
        }
    }

    private static void mostrarTodosClientes() throws SQLException {
        System.out.println("========== LISTA DE CLIENTES ==========");
        List<Cliente> clientes = dao.obtenerTodos();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente cliente : clientes) {
                mostrarClienteFormato(cliente);
            }
        }
    }

    private static void eliminarCliente() throws SQLException {
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        int id = leerEntero();

        if (id <= 0) {
            System.out.println("ID invalido.");
            return;
        }

        dao.eliminarCliente(id);
    }

    private static void anadirCliente() throws SQLException {
        System.out.println("========== ANADIR NUEVO CLIENTE ==========");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();

        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Telefono: ");
        long telefono = leerLargo();

        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || telefono <= 0) {
            System.out.println("Datos invalidos. El cliente no fue anadido.");
            return;
        }

        Cliente cliente = new Cliente(nombre, apellido, email, telefono);
        dao.agregarCliente(cliente);
    }

    private static void modificarTelefono() throws SQLException {
        System.out.print("Ingrese el ID del cliente: ");
        int id = leerEntero();

        System.out.print("Ingrese el nuevo numero de telefono: ");
        long nuevoTelefono = leerLargo();

        if (id <= 0) {
            System.out.println("ID invalido.");
            return;
        }

        dao.modificarTelefono(id, nuevoTelefono);
    }

    private static void buscarPorApellido() throws SQLException {
        System.out.print("Ingrese el apellido a buscar: ");
        String apellido = scanner.nextLine().trim();

        if (apellido.isEmpty()) {
            System.out.println("Apellido invalido.");
            return;
        }

        System.out.println("========== RESULTADOS DE BUSQUEDA ==========");
        List<Cliente> clientes = dao.buscarPorApellido(apellido);

        if (clientes.isEmpty()) {
            System.out.println("No se encontraron clientes con el apellido: " + apellido);
        } else {
            for (Cliente cliente : clientes) {
                mostrarClienteFormato(cliente);
            }
        }
    }

    private static void mostrarClienteFormato(Cliente cliente) {
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Telefono: " + cliente.getTelefono());
        System.out.println("-----------------------------------------");
    }

    private static int leerOpcion() {
        try {
            int valor = Integer.parseInt(scanner.nextLine().trim());
            return valor;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida. Ingrese un numero entero.");
            return -1;
        }
    }

    private static long leerLargo() {
        try {
            return Long.parseLong(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida. Ingrese un numero valido.");
            return -1;
        }
    }
}
