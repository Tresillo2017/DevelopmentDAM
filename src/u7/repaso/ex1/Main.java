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

package u7.repaso.ex1;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Entrada> listaEntradas = new ArrayList<>();

        listaEntradas.add(new EntradaNormal(1, "Lo que el viento se llevo"));
        listaEntradas.add(new EntradaNormal(2, "Matrix"));
        listaEntradas.add(new EntradaVIP(3, "Avatar", "3D"));
        listaEntradas.add(new EntradaVIP(4, "Insterstellar"));

        int opcion;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Agregar Entrada normal");
            System.out.println("2. Agregar entrada VIP");
            System.out.println("3. Mostrar todas las entradas");
            System.out.println("4. Buscar entrada por codigo");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Codigo: ");
                        int codNormal = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Titulo: ");
                        String tituloNormal = sc.nextLine();
                        listaEntradas.add(new EntradaNormal(codNormal, tituloNormal));
                        break;

                    case 2:
                        System.out.print("Codigo: ");
                        int codVip = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Titulo: ");
                        String tituloVip = sc.nextLine();
                        System.out.print("Tipo sala: ");
                        String tipoSala = sc.nextLine();
                        listaEntradas.add(new EntradaVIP(codVip, tituloVip, tipoSala));
                        break;

                    case 3:
                        for (Entrada e: listaEntradas) {
                            e.mostrarEntrada();
                        }
                        break;

                    case 4:
                        System.out.print("Introduce codigo a buscar: ");
                        int buscado = sc.nextInt();
                        sc.nextLine();
                        boolean encontrado = false;

                        for (Entrada e: listaEntradas) {
                            if (e.getCodigo() == buscado) {
                                e.mostrarEntrada();
                                System.out.println("Precio: " + e.calcularPrecio());
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("No existe ninguna entrada con ese codigo.");
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo...");

                    default:
                        System.out.println("Opcion no valida.");
                }
        }
        while (opcion != 5);

        sc.close();
    }
}
