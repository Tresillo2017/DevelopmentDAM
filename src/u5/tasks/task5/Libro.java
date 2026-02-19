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

public class Libro {
    private String isbn;
    private String titulo;
    private Persona autor;
    private int anioPublicacion;
    private boolean prestado;

    // Constructor con todos los datos pasados por parámetro
    public Libro(String isbn, String titulo, Persona autor, int anioPublicacion, boolean prestado) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.prestado = prestado;
    }

    // Constructor con año publicación por defecto 2000, autor por defecto y prestado false
    public Libro(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = new Persona("sin especificar", "Española");
        this.anioPublicacion = 2000;
        this.prestado = false;
    }

    // Getters y Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    // Método prestar
    public void prestar() {
        this.prestado = true;
    }

    // Método devolver
    public void devolver() {
        this.prestado = false;
    }

    // Método mostrarInfo
    public void mostrarInfo() {
        System.out.println("================================");
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de Publicación: " + anioPublicacion);
        System.out.println("Estado: " + (prestado ? "Prestado" : "Disponible"));
        System.out.println("================================");
    }
}

