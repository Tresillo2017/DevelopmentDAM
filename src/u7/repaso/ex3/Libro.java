package u7.repaso.ex3;

import java.util.ArrayList;

public abstract class Libro{
    private String titulo;
    private int anioPublicacion;
    private double precioBase;
    private Autor autor;
    private ArrayList<Prestamo> prestamos;

    public Libro(String titulo, int anioPublicacion, double precioBase, Autor autor) {
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.precioBase = precioBase;
        this.autor = autor;
        prestamos = new ArrayList<>();
    }

    public void anadirPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void mostrarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("Este libro no tiene prestamos.");
            return;
        }
        System.out.println("Prestamos del libro: " + titulo);
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }

    public abstract double calcularPrecioFinal();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}
