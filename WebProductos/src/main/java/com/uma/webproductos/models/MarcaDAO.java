package com.uma.webproductos.models;

import java.sql.*;
import java.util.*;

public class MarcaDAO {
    Conexion con = new Conexion();

    /**
     * Método privado para obtener la conexión.
     * Se mantiene separado para facilitar el mantenimiento.
     */
    private Connection conectar() throws SQLException, ClassNotFoundException {
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }

    /**
     * BLOQUE CORREGIDO: Implementación de Try-with-resources.
     * Esto asegura que la conexión y el statement se cierren automáticamente,
     * evitando que la base de datos se bloquee por demasiadas conexiones abiertas.
     */
    public int InsertarMarca(Marca marca) {
        int n = 0;
        String query = "INSERT INTO Marca(Nombre) VALUES(?)";
        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, marca.getNombre());
            n = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }

    /**
     * BLOQUE CORREGIDO: Se eliminaron las variables globales sql y rs.
     * Ahora cada método tiene su propio scope de conexión.
     */
    public int ModificarMarca(Marca marca) {
        int n = 0;
        String query = "UPDATE Marca SET Nombre=? WHERE Id=?";
        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, marca.getNombre());
            ps.setInt(2, marca.getId());
            n = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }

    /**
     * BLOQUE CORREGIDO: Gestión segura de eliminación.
     */
    public int EliminarMarca(Marca marca) {
        int n = 0;
        String query = "DELETE FROM Marca WHERE Id=?";
        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, marca.getId());
            n = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }

    /**
     * BLOQUE CORREGIDO: Recorrido seguro del ResultSet.
     * El uso de try-with-resources aquí cierra el ResultSet y el Statement inmediatamente.
     */
    public ArrayList<Marca> MostrarMarcas() {
        ArrayList<Marca> marcas = new ArrayList<>();
        String query = "SELECT * FROM Marca";
        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(query); 
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                marcas.add(new Marca(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return marcas;
    }

    /**
     * BLOQUE CORREGIDO: Se corrigió el retorno.
     * Antes el método podía retornar null o una marca vacía debido al uso de variables globales.
     */
    public Marca ObtenerMarcaPorId(int id) {
        Marca marca = null;
        String query = "SELECT * FROM Marca WHERE Id=?";
        try (Connection conn = conectar(); 
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    marca = new Marca(rs.getInt(1), rs.getString(2));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return marca;
    }
}
