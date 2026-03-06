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

package u6.tasks.taskre2v2;

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
    private ArrayList<Actor> actoresPrincipales;

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
        this.actoresPrincipales = new ArrayList<>();
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

    public ArrayList<Actor> getActoresPrincipales() {
        return actoresPrincipales;
    }

    public void setActoresPrincipales(ArrayList<Actor> actoresPrincipales) {
        this.actoresPrincipales = actoresPrincipales;
    }

    public static ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    /**
     * Añade un actor a la lista de actores principales
     */
    public void agregarActor(Actor actor) {
        actoresPrincipales.add(actor);
    }

    /**
     * Método toString() que devuelve todos los datos de la película
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔══════════════════════════════════════════════════════════╗\n");
        sb.append("  Título: ").append(titulo).append("\n");
        sb.append("  Género: ").append(genero).append("\n");
        sb.append("  Año de estreno: ").append(anyoEstreno).append("\n");
        sb.append("  Duración: ").append(duracion).append(" minutos\n");

        if (!actoresPrincipales.isEmpty()) {
            sb.append("  Actores principales:\n");
            for (Actor actor : actoresPrincipales) {
                sb.append("    • ").append(actor.toString()).append("\n");
            }
        }

        sb.append("╚══════════════════════════════════════════════════════════╝");
        return sb.toString();
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
     * Muestra todos los títulos y nombres de actores principales de todas las películas
     */
    public static void mostrarTitulosYActores() {
        if (listaPeliculas.isEmpty()) {
            System.out.println("No hay películas en la lista.");
        } else {
            for (Pelicula pelicula : listaPeliculas) {
                System.out.println("\n📽️  " + pelicula.getTitulo());
                if (pelicula.getActoresPrincipales().isEmpty()) {
                    System.out.println("   Sin actores principales registrados.");
                } else {
                    System.out.println("   Actores principales:");
                    for (Actor actor : pelicula.getActoresPrincipales()) {
                        System.out.println("      • " + actor.getNombre());
                    }
                }
            }
        }
    }

    /**
     * Busca y muestra todas las películas de un actor específico
     */
    public static ArrayList<Pelicula> buscarPeliculasPorActor(String nombreActor) {
        ArrayList<Pelicula> resultados = new ArrayList<>();
        for (Pelicula pelicula : listaPeliculas) {
            for (Actor actor : pelicula.getActoresPrincipales()) {
                if (actor.getNombre().toLowerCase().contains(nombreActor.toLowerCase())) {
                    resultados.add(pelicula);
                    break; // No añadir la misma película varias veces
                }
            }
        }
        return resultados;
    }

    /**
     * Obtiene todos los actores únicos de todas las películas
     */
    public static ArrayList<Actor> obtenerTodosLosActores() {
        ArrayList<Actor> todosLosActores = new ArrayList<>();
        for (Pelicula pelicula : listaPeliculas) {
            for (Actor actor : pelicula.getActoresPrincipales()) {
                // Evitar duplicados
                boolean existe = false;
                for (Actor actorExistente : todosLosActores) {
                    if (actorExistente.getNombre().equalsIgnoreCase(actor.getNombre())) {
                        existe = true;
                        break;
                    }
                }
                if (!existe) {
                    todosLosActores.add(actor);
                }
            }
        }
        return todosLosActores;
    }

    /**
     * Muestra los actores mayores de 60 años
     */
    public static void mostrarActoresMayoresDe60() {
        ArrayList<Actor> actoresMayores = new ArrayList<>();
        ArrayList<Actor> todosLosActores = obtenerTodosLosActores();

        for (Actor actor : todosLosActores) {
            if (actor.getEdad() > 60) {
                actoresMayores.add(actor);
            }
        }

        if (actoresMayores.isEmpty()) {
            System.out.println("No hay actores mayores de 60 años.");
        } else {
            System.out.println("Actores mayores de 60 años:");
            for (Actor actor : actoresMayores) {
                System.out.println("  • " + actor.getNombre() + " - " + actor.getEdad() + " años");
            }
        }
    }

    /**
     * Inicializa la lista con 3 películas predefinidas con actores
     */
    public static void inicializarPeliculas() {
        // Película 1: El Señor de los Anillos
        Pelicula pelicula1 = new Pelicula("El Señor de los Anillos: La Comunidad del Anillo",
                                          "Fantasía", 2001, 178);
        pelicula1.agregarActor(new Actor("Elijah Wood", 1981, "Estadounidense"));
        pelicula1.agregarActor(new Actor("Ian McKellen", 1939, "Británico"));
        pelicula1.agregarActor(new Actor("Viggo Mortensen", 1958, "Estadounidense"));
        agregarPelicula(pelicula1);

        // Película 2: Inception
        Pelicula pelicula2 = new Pelicula("Inception", "Ciencia Ficción", 2010, 148);
        pelicula2.agregarActor(new Actor("Leonardo DiCaprio", 1974, "Estadounidense"));
        pelicula2.agregarActor(new Actor("Marion Cotillard", 1975, "Francesa"));
        pelicula2.agregarActor(new Actor("Tom Hardy", 1977, "Británico"));
        agregarPelicula(pelicula2);

        // Película 3: Pulp Fiction
        Pelicula pelicula3 = new Pelicula("Pulp Fiction", "Drama", 1994, 154);
        pelicula3.agregarActor(new Actor("John Travolta", 1954, "Estadounidense"));
        pelicula3.agregarActor(new Actor("Samuel L. Jackson", 1948, "Estadounidense"));
        pelicula3.agregarActor(new Actor("Uma Thurman", 1970, "Estadounidense"));
        agregarPelicula(pelicula3);
    }
}

