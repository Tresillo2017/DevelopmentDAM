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

import java.util.ArrayList;

public class Peluqueria {

    private String nombre;
    private String direccion;
    private ArrayList<Cliente> clientes;

    // Constructor que recibe nombre y dirección; la lista de clientes se inicializa vacía
    public Peluqueria(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.clientes = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Añadir un cliente a la peluquería
    public void añadirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Buscar un cliente por su número de teléfono. Devuelve null si no se encuentra.
    public Cliente buscarClientePorTelefono(String telefono) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getTelefono().equals(telefono)) {
                return clientes.get(i);
            }
        }
        return null;
    }

    // Cortar el pelo a un cliente buscándolo por teléfono
    public boolean cortarPelo(String telefono) {
        Cliente cliente = buscarClientePorTelefono(telefono);
        if (cliente != null) {
            cliente.setPeloCortado(true);
            return true;
        }
        return false;
    }

    // Eliminar un cliente por su número de teléfono
    public boolean eliminarCliente(String telefono) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getTelefono().equals(telefono)) {
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }

    // Método dedicado para listar clientes según el estado del pelo (cortado o sin cortar)
    // Si peloCortado es true, lista los que tienen el pelo cortado; si es false, los que no.
    public void listarClientesPorEstadoPelo(boolean peloCortado) {
        String estado = peloCortado ? "pelo cortado" : "pelo sin cortar";
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("  Clientes con " + estado);
        System.out.println("╚══════════════════════════════════════════╝");

        boolean encontrado = false;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).isPeloCortado() == peloCortado) {
                System.out.println(clientes.get(i).toString());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay clientes con " + estado + ".");
        }
    }

    @Override
    public String toString() {
        return (
            "Peluqueria{" +
            "nombre='" +
            nombre +
            '\'' +
            ", direccion='" +
            direccion +
            '\'' +
            ", clientes=" +
            clientes.size() +
            '}'
        );
    }
}
