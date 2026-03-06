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

package u6.tasks.taskre2;

import java.util.ArrayList;

/**
 * Clase Pelicula que representa una película con sus atributos básicos
 * y gestiona una lista estática de todas las películas
 */
public class Pelicula {
    // Atributos de instancia
    private String titulo;
    private String genero;
    private int anyoEstreno;
    private double duracion;

    // Lista estática de películas
    private static ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

    /**
     * Constructor con todos los atributos
     */
    public Pelicula(String titulo, String genero, int anyoEstreno, double duracion) {
        this.titulo = titulo;
        this.genero = genero;
        this.anyoEstreno = anyoEstreno;
        this.duracion = duracion;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnyoEstreno() {
        return anyoEstreno;
    }

    public void setAnyoEstreno(int anyoEstreno) {
        this.anyoEstreno = anyoEstreno;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public static ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    /**
     * Método toString() que devuelve todos los datos de la película
     */
    @Override
    public String toString() {
        return "╔══════════════════════════════════════════════════════════╗\n" +
               "  Título: " + titulo + "\n" +
               "  Género: " + genero + "\n" +
               "  Año de estreno: " + anyoEstreno + "\n" +
               "  Duración: " + duracion + " minutos\n" +
               "╚══════════════════════════════════════════════════════════╝";
    }

    // Métodos de gestión de la lista

    /**
     * Añade una película a la lista
     */
    public static void agregarPelicula(Pelicula pelicula) {
        listaPeliculas.add(pelicula);
    }

    /**
     * Devuelve el número total de películas
     */
    public static int totalPeliculas() {
        return listaPeliculas.size();
    }

    /**
     * Busca películas cuyo título contenga la palabra clave (ignora mayúsculas)
     */
    public static ArrayList<Pelicula> buscarPorPalabraClave(String palabraClave) {
        ArrayList<Pelicula> resultados = new ArrayList<>();
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getTitulo().toLowerCase().contains(palabraClave.toLowerCase())) {
                resultados.add(pelicula);
            }
        }
        return resultados;
    }

    /**
     * Busca una película por título exacto (ignora mayúsculas)
     */
    public static Pelicula buscarPorTituloExacto(String titulo) {
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                return pelicula;
            }
        }
        return null;
    }

    /**
     * Busca una película por su posición en la lista
     */
    public static Pelicula buscarPorPosicion(int posicion) {
        if (posicion >= 0 && posicion < listaPeliculas.size()) {
            return listaPeliculas.get(posicion);
        }
        return null;
    }

    /**
     * Muestra todas las películas de la lista
     */
    public static void mostrarTodasLasPeliculas() {
        if (listaPeliculas.isEmpty()) {
            System.out.println("No hay películas en la lista.");
        } else {
            for (int i = 0; i < listaPeliculas.size(); i++) {
                System.out.println("\n[Posición " + i + "]");
                System.out.println(listaPeliculas.get(i));
            }
        }
    }

    /**
     * Inicializa la lista con 3 películas predefinidas
     */
    public static void inicializarPeliculas() {
        agregarPelicula(new Pelicula("El Señor de los Anillos: La Comunidad del Anillo", "Fantasía", 2001, 178));
        agregarPelicula(new Pelicula("Inception", "Ciencia Ficción", 2010, 148));
        agregarPelicula(new Pelicula("Pulp Fiction", "Drama", 1994, 154));
    }
}

