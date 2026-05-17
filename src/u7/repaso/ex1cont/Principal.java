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

package u7.repaso.ex1cont;

import java.util.ArrayList;
import java.util.Scanner;


import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Entrada> listaEntradas = new ArrayList<>();

        listaEntradas.add(new EntradaNormal(1, "Lo que el viento se llevó"));
        listaEntradas.add(new EntradaNormal(2, "Matrix"));
        listaEntradas.add(new EntradaVIP(3, "Avatar", "3D"));
        listaEntradas.add(new EntradaVIP(4, "Interstellar", "VIP"));

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Añadir entrada normal");
            System.out.println("2. Añadir entrada VIP");
            System.out.println("3. Mostrar todas las entradas");
            System.out.println("4. Buscar entrada por código");
            System.out.println("5. Mostrar sólo las entradas Normales, mostrando título y precio.");
            System.out.println("6. Mostrar las entradas VIP con tipo de sala 3D.");
            System.out.println("7. Mostrar entradas con descuento.");
            System.out.println("8. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Código: ");
                    int codNormal = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Título: ");
                    String tituloNormal = sc.nextLine();
                    listaEntradas.add(new EntradaNormal(codNormal, tituloNormal));
                    break;

                case 2:
                    System.out.print("Código: ");
                    int codVip = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Título: ");
                    String tituloVip = sc.nextLine();
                    System.out.print("Tipo sala: ");
                    String tipoSala = sc.nextLine();
                    listaEntradas.add(new EntradaVIP(codVip, tituloVip, tipoSala));
                    break;

                case 3:
                    for (Entrada e : listaEntradas) {
                        e.mostrarEntrada();
                    }
                    break;

                case 4:
                    System.out.print("Introduce código a buscar: ");
                    int buscado = sc.nextInt();
                    sc.nextLine();
                    boolean encontrado = false;
                    for (Entrada e : listaEntradas) {
                        if (e.getCodigo() == buscado) {
                            e.mostrarEntrada();
                            System.out.println("Precio: " + e.calcularPrecio());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No existe ninguna entrada con ese código.");
                    }
                    break;

                case 5:
                    for (Entrada e : listaEntradas) {
                        if (e instanceof EntradaNormal) {
                            System.out.println("Título: " + e.getTituloPelicula() + " - Precio: " + e.calcularPrecio());
                        }
                    }
                    break;

                case 6:
                    for (Entrada e : listaEntradas) {
                        if (e instanceof EntradaVIP) {
                            EntradaVIP vip = (EntradaVIP) e;
                            if (vip.getTipoSala().equalsIgnoreCase("3D")) {
                                vip.mostrarEntrada();
                            }
                        }
                    }
                    break;

                case 7:
                    for (Entrada e : listaEntradas) {
                        if (e instanceof EntradaVIP) {
                            EntradaVIP vip = (EntradaVIP) e;
                            if (vip.getTipoSala().equalsIgnoreCase("VIP")) {
                                System.out.println("Código: " + vip.getCodigo()
                                        + " - Título: " + vip.getTituloPelicula()
                                        + " - Precio sin descuento: " + vip.calcularPrecio()
                                        + " - Precio con descuento: " + vip.aplicarDescuento());
                            }
                        }
                    }
                    break;

                case 8:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 8);

        sc.close();
    }
}

