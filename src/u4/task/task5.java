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


/*
Crear un array multidimensional de 3x2 de char, darle valores ficticios y mostrar los datos bien formateados por fila y columna. Utilizar bucles para recorrerlo.

Crea un método que solicite un caracter y lo busque dentro de la matriz. Si lo encuentra o no mostrar mensaje indicándolo.

Utilizar el método en la clase principal.
*/
package u4.task;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        char[][] matriz = {
            {'A', 'B'},
            {'C', 'D'},
            {'E', 'F'}
        };

        // Mostrar la matriz formateada
        System.out.println("Matriz 3x2:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Introduce un carácter a buscar en la matriz: ");
        Scanner sc = new Scanner(System.in);
        // Buscar un carácter en la matriz
        char caracterABuscar = sc.next().charAt(0);
        boolean encontrado = buscarCaracterEnMatriz(matriz, caracterABuscar);

        if (encontrado) {
            System.out.println("El carácter '" + caracterABuscar + "' se ha encontrado en la matriz.");
        } else {
            System.out.println("El carácter '" + caracterABuscar + "' no se ha encontrado en la matriz.");
        }
    }

    public static boolean buscarCaracterEnMatriz(char[][] matriz, char caracter) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == caracter) {
                    return true;
                }
            }
        }
        return false;
    }
}
