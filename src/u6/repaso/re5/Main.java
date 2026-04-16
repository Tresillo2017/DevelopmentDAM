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

public class Main {
    public static void main(String[] args) {
        Producto pr1 = new Producto("Portatil", 899.99, "electronica");
        Producto pr2 = new Producto("Camiseta", 19.95, "ropa");
        Producto pr3 = new Producto("Lampara", 35.50, "hogar");
        Producto pr4 = new Producto("Auriculares", 129.99, "electronica");

        Cliente c1 = new Cliente("Ana", 500, "normal");
        Cliente c2 = new Cliente("Luis", 1200, "premium");
        Cliente c3 = new Cliente("Marta", 2000, "elite");

        Pedido p1 = new Pedido(pr1);
        Pedido p2 = new Pedido(pr2);

        p1.agregarCliente(c1); // debe fallar
        p1.agregarCliente(c3); // debe funcionar
        p2.agregarCliente(c1); // debe funcionar
        p2.agregarCliente(c2); // debe funcionar

        Pedido.listaPedidos.add(p1);
        Pedido.listaPedidos.add(p2);

        // 1. Mostrar informacion de cada pedido
        for (Pedido p : Pedido.listaPedidos) {
            System.out.println("Producto: " + p.getProducto().getNombre());
            System.out.println("Precio: " + p.getProducto().getPrecio());
            System.out.println("Clientes:");
            p.mostrarClientes();
            System.out.println("--------------");
        }

        // 2. Mostar el producto que tenga algun cliente con mas de 1000 puntos de fidelidad
        for (Pedido p : Pedido.listaPedidos) {
            for (Cliente c : p.getClientes()) {
                if (c.getPuntosFidelidad() > 1000) {
                    System.out.println("Producto: " + p.getProducto().getNombre());
                    break;
                }
            }
        }

        // 3. Mostrar el pedido con más clientes.
        int maxClientes = -1;
        Pedido pedidomax = null;

        for (Pedido p : Pedido.listaPedidos) {
            int tam = p.getClientes().size();

            if (tam > maxClientes) {
                maxClientes = tam;
                pedidomax = p;
            }
        }
        if (pedidomax != null) {
            System.out.println("Producto: " + pedidomax.getProducto().getNombre());
            System.out.println("Clientes: " + maxClientes);
        }

        // 4. Indicar cuántos clientes son de tipo elite, mostrando además (nombre, puntos de fidelidad)
        int count = 0;
        for (Pedido p : Pedido.listaPedidos ) {
            for (Cliente c : p.getClientes()) {
                if (c.getTipoCliente().equals("elite")) {
                    System.out.println("Nombre: " + c.getNombre() + ", (Puntos: " + c.getPuntosFidelidad() + ")");
                    count++;
                }
            }
        }
        System.out.println("Hay un total de " + count + " miembros tipo elite");
    }
}