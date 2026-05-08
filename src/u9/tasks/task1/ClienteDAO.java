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

package u9.tasks.task1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/ebanca";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection conexion;

    public ClienteDAO() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver JDBC no encontrado");
            throw new SQLException(e);
        }
        this.conexion = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void cerrar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexion: " + e.getMessage());
        }
    }

    public List<Cliente> obtenerTodos() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getLong("telefono")
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public void agregarCliente(Cliente cliente) throws SQLException {
        if (!validarCliente(cliente)) {
            throw new SQLException("Datos de cliente invalidos");
        }

        String sql = "INSERT INTO clientes(nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellido());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setLong(4, cliente.getTelefono());
            pstmt.executeUpdate();
            System.out.println("Cliente anadido exitosamente.");
        }
    }

    public void eliminarCliente(int id) throws SQLException {
        if (!clienteExiste(id)) {
            System.out.println("Cliente con ID " + id + " no encontrado.");
            return;
        }

        String sql = "DELETE FROM clientes WHERE id = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Cliente eliminado exitosamente.");
            }
        }
    }

    public void modificarTelefono(int id, long nuevoTelefono) throws SQLException {
        if (!clienteExiste(id)) {
            System.out.println("Cliente con ID " + id + " no encontrado.");
            return;
        }

        if (nuevoTelefono <= 0) {
            System.out.println("Numero de telefono invalido.");
            return;
        }

        String sql = "UPDATE clientes SET telefono = ? WHERE id = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setLong(1, nuevoTelefono);
            pstmt.setInt(2, id);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Telefono actualizado exitosamente.");
            }
        }
    }

    public List<Cliente> buscarPorApellido(String apellido) throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes WHERE apellido LIKE ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, "%" + apellido + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("email"),
                            rs.getLong("telefono")
                    );
                    clientes.add(cliente);
                }
            }
        }
        return clientes;
    }

    private boolean clienteExiste(int id) throws SQLException {
        String sql = "SELECT 1 FROM clientes WHERE id = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    private boolean validarCliente(Cliente cliente) {
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            return false;
        }
        if (cliente.getApellido() == null || cliente.getApellido().trim().isEmpty()) {
            return false;
        }
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            return false;
        }
        if (cliente.getTelefono() <= 0) {
            return false;
        }
        return true;
    }
}
