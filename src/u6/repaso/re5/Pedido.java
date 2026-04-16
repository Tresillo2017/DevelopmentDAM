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

package u6.repaso.re5;

import java.util.ArrayList;

public class Pedido {
    private Producto producto;
    private ArrayList<Cliente> clientes;

    public static ArrayList<Pedido> listaPedidos = new ArrayList<>();

    public Pedido(Producto producto) {
        this.producto = producto;
        this.clientes = new ArrayList<>();
    }

    public boolean agregarCliente(Cliente c) {
        if (producto.getCategoria().equals("electronica") && !c.getTipoCliente().equals("elite")) {
            System.out.println("Error, la categoria no es correcta para este tipo de cliente");
            return false;
        }
        clientes.add(c);
        return true;
    }

    public void mostrarClientes() {
        for (Cliente c : clientes) {
            System.out.println("Nombre: " + c.getNombre() + ", Puntos Fidelidad: " + c.getPuntosFidelidad() + ", Tipo Cliente: " + c.getTipoCliente());
        }
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "producto=" + producto +
                ", clientes=" + clientes +
                ", listaPedidos=" + listaPedidos +
                '}';
    }
}
