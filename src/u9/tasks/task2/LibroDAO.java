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

package u9.tasks.task2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public void insertarLibro(Libro libro) {
        String sql = "INSERT INTO libros (titulo, autor, genero, precio, disponible) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.mySQLConnect();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, libro.getTitulo());
            pstmt.setString(2, libro.getAutor());
            pstmt.setString(3, libro.getGenero());
            pstmt.setDouble(4, libro.getPrecio());
            pstmt.setBoolean(5, libro.isDisponible());

            int filasInsertadas = pstmt.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Libro insertado exitosamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar el libro: " + e.getMessage());
        }
    }

    public void mostrarLibros() {
        String sql = "SELECT * FROM libros";

        try (Connection conexion = ConexionBD.mySQLConnect();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (!rs.isBeforeFirst()) {
                System.out.println("No hay libros en la base de datos.");
                return;
            }

            System.out.println("\n===== LISTA DE LIBROS =====");
            while (rs.next()) {
                mostrarLibroFormato(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar los libros: " + e.getMessage());
        }
    }

    public void buscarPorAutor(String autor) {
        String sql = "SELECT * FROM libros WHERE autor LIKE ?";

        try (Connection conexion = ConexionBD.mySQLConnect();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, "%" + autor + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("No se encontraron libros del autor: " + autor);
                    return;
                }

                System.out.println("\n===== LIBROS DEL AUTOR: " + autor + " =====");
                while (rs.next()) {
                    mostrarLibroFormato(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar libros por autor: " + e.getMessage());
        }
    }

    public void actualizarPrecio(int id, double nuevoPrecio) {
        if (!libroExiste(id)) {
            System.out.println("El libro con ID " + id + " no existe.");
            return;
        }

        if (nuevoPrecio < 0) {
            System.out.println("El precio no puede ser negativo.");
            return;
        }

        String sql = "UPDATE libros SET precio = ? WHERE id = ?";

        try (Connection conexion = ConexionBD.mySQLConnect();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setDouble(1, nuevoPrecio);
            pstmt.setInt(2, id);

            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Precio actualizado exitosamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar el precio: " + e.getMessage());
        }
    }

    public void eliminarLibro(int id) {
        if (!libroExiste(id)) {
            System.out.println("El libro con ID " + id + " no existe.");
            return;
        }

        String sql = "DELETE FROM libros WHERE id = ?";

        try (Connection conexion = ConexionBD.mySQLConnect();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int filasEliminadas = pstmt.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Libro eliminado exitosamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el libro: " + e.getMessage());
        }
    }

    private boolean libroExiste(int id) {
        String sql = "SELECT 1 FROM libros WHERE id = ?";

        try (Connection conexion = ConexionBD.mySQLConnect();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar si el libro existe: " + e.getMessage());
            return false;
        }
    }

    private void mostrarLibroFormato(ResultSet rs) throws SQLException {
        System.out.println("ID: " + rs.getInt("id"));
        System.out.println("Titulo: " + rs.getString("titulo"));
        System.out.println("Autor: " + rs.getString("autor"));
        System.out.println("Genero: " + rs.getString("genero"));
        System.out.println("Precio: $" + rs.getDouble("precio"));
        System.out.println("Disponible: " + (rs.getBoolean("disponible") ? "Si" : "No"));
        System.out.println("-----------------------------------------");
    }
}

