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
import java.util.Scanner;

public class Receta {

    private String nombre;
    private String dificultad;
    private String tiempo;
    private String descripcion;

    // Variable global donde almacenamos todas las recetas
    public static ArrayList<Receta> misRecetas = new ArrayList<>();

    // Constructor con todos los parámetros
    public Receta(
        String nombre,
        String dificultad,
        String tiempo,
        String descripcion
    ) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.tiempo = tiempo;
        this.descripcion = descripcion;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDificultad() {
        return dificultad;
    }

    public String getTiempo() {
        return tiempo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // toString
    @Override
    public String toString() {
        return (
            "Receta{" +
            "nombre='" +
            nombre +
            '\'' +
            ", dificultad='" +
            dificultad +
            '\'' +
            ", tiempo='" +
            tiempo +
            '\'' +
            ", descripcion='" +
            descripcion +
            '\'' +
            '}'
        );
    }

    // Valida que la dificultad sea uno de los valores permitidos: fácil, media, difícil
    public static boolean validarDificultad(String dificultad) {
        return (
            dificultad.equalsIgnoreCase("fácil") ||
            dificultad.equalsIgnoreCase("facil") ||
            dificultad.equalsIgnoreCase("media") ||
            dificultad.equalsIgnoreCase("difícil") ||
            dificultad.equalsIgnoreCase("dificil")
        );
    }

    // Muestra todos los datos de una receta bien formateados
    public void mostrarDetalle() {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("  Nombre:      " + nombre);
        System.out.println("  Dificultad:  " + dificultad);
        System.out.println("  Tiempo:      " + tiempo);
        System.out.println("  Descripción: " + descripcion);
        System.out.println("╚══════════════════════════════════════════╝");
    }

    // Solicita todos los datos para crear una receta, valida la dificultad y devuelve el objeto
    public static Receta crearReceta(Scanner scanner) {
        System.out.print("Introduce el nombre de la receta: ");
        String nombre = scanner.nextLine();

        String dificultad;
        do {
            System.out.print(
                "Introduce la dificultad (fácil, media, difícil): "
            );
            dificultad = scanner.nextLine();
            if (!validarDificultad(dificultad)) {
                System.out.println(
                    "Dificultad no válida. Los valores posibles son: fácil, media, difícil."
                );
            }
        } while (!validarDificultad(dificultad));

        System.out.print("Introduce el tiempo de preparación: ");
        String tiempo = scanner.nextLine();

        System.out.print("Introduce la descripción: ");
        String descripcion = scanner.nextLine();

        Receta nuevaReceta = new Receta(
            nombre,
            dificultad,
            tiempo,
            descripcion
        );
        misRecetas.add(nuevaReceta);
        System.out.println("Receta creada exitosamente.");
        return nuevaReceta;
    }

    // Muestra una lista con los nombres de todas las recetas
    public static void mostrarRecetas() {
        if (misRecetas.isEmpty()) {
            System.out.println("No hay recetas registradas.");
            return;
        }

        System.out.println("\n========== LISTA DE RECETAS ==========");
        for (int i = 0; i < misRecetas.size(); i++) {
            System.out.println(
                "  " + (i + 1) + ". " + misRecetas.get(i).getNombre()
            );
        }
        System.out.println("=======================================");
    }

    // Busca una receta por nombre. Si la encuentra muestra el detalle, si no ofrece crearla.
    public static void buscarReceta(Scanner scanner) {
        System.out.print("Introduce el nombre de la receta a buscar: ");
        String nombreBuscado = scanner.nextLine();

        for (int i = 0; i < misRecetas.size(); i++) {
            if (misRecetas.get(i).getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("\nReceta encontrada:");
                misRecetas.get(i).mostrarDetalle();
                return;
            }
        }

        System.out.println("La receta '" + nombreBuscado + "' no existe.");
        System.out.print("¿Deseas crearla? (s/n): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            crearReceta(scanner);
        }
    }

    // Normaliza la dificultad eliminando tildes para permitir comparaciones flexibles
    private static String normalizarDificultad(String dificultad) {
        return dificultad
            .toLowerCase()
            .replace("á", "a")
            .replace("é", "e")
            .replace("í", "i")
            .replace("ó", "o")
            .replace("ú", "u");
    }

    // Devuelve un String con los nombres de las recetas que tengan la dificultad indicada, separados por comas
    public static String buscarPorDificultad(String dificultad) {
        StringBuilder resultado = new StringBuilder();
        String dificultadNormalizada = normalizarDificultad(dificultad);

        for (int i = 0; i < misRecetas.size(); i++) {
            if (
                normalizarDificultad(misRecetas.get(i).getDificultad()).equals(
                    dificultadNormalizada
                )
            ) {
                if (resultado.length() > 0) {
                    resultado.append(", ");
                }
                resultado.append(misRecetas.get(i).getNombre());
            }
        }

        if (resultado.length() == 0) {
            return "NO se ha encontrado ninguna receta con esta dificultad";
        }

        return resultado.toString();
    }
}
