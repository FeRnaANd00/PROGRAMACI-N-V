package com.uma.webproductos.models;

import java.sql.*;
import java.util.*;

public class ProductoDAO {
    PreparedStatement sql;
    ResultSet rs;
    Conexion con = new Conexion();
    Marca marca;
    Producto producto;
    
    /**
     * Establece la conexión con la base de datos.
     * Carga el driver y retorna la conexión utilizando los datos de la clase Conexion.
     */
    Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }
    
    /**
     * BLOQUE: Insertar Producto.
     * Recibe un objeto Producto y lo guarda en la base de datos.
     */
    public int InsertarProducto(Producto producto){
        int n = 0;
        try{
            sql = conectar().prepareStatement("INSERT INTO "
                    + "Producto(Nombre, Precio, Imagen, IdMarca) "
                    + "VALUES(?,?,?,?)");
            sql.setString(1, producto.getNombre());
            sql.setFloat(2, producto.getPrecio());
            sql.setBlob(3, producto.getImagen());
            sql.setInt(4, producto.getMarca().getId());
            n = sql.executeUpdate();
            sql.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return n;
    }
    
    /**
     * BLOQUE: Modificar Producto.
     * Actualiza la información de un producto existente mediante su Id.
     */
    public int ModificarProducto(Producto producto){
        int n = 0;
        try{
            sql = conectar().prepareStatement("UPDATE Producto "
                    + "SET Nombre=?, Precio=?, Imagen=?, IdMarca=? "
                    + "WHERE Id=?");
            sql.setString(1, producto.getNombre());
            sql.setFloat(2, producto.getPrecio());
            sql.setBlob(3, producto.getImagen());
            sql.setInt(4, producto.getMarca().getId());
            sql.setInt(5, producto.getId());
            n = sql.executeUpdate();
            sql.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return n;
    }
    
    /**
     * BLOQUE: Eliminar Producto.
     * Borra un registro de la tabla Producto usando el Id.
     */
    public int EliminarProducto(Producto producto){
        int n = 0;
        try{
            sql = conectar().prepareStatement("DELETE FROM Producto WHERE Id=?");
            sql.setInt(1, producto.getId());
            n = sql.executeUpdate();
            sql.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return n;
    }
    
    /**
     * BLOQUE: Mostrar Todos los Productos.
     * Realiza un INNER JOIN con la tabla Marca para traer la información completa del producto y su marca.
     */
    public ArrayList<Producto> MostrarProductos(){
        ArrayList<Producto> productos = new ArrayList<>();
        try{
            sql = conectar().prepareStatement("SELECT * FROM Producto p "
                    + "INNER JOIN Marca m ON p.IdMarca=m.Id ORDER BY p.Id");
            rs = sql.executeQuery();
            while(rs.next()){
                marca = new Marca(rs.getInt("m.Id"), rs.getString("m.Nombre"));
                producto = new Producto(rs.getInt("p.Id"), rs.getString("p.Nombre"), 
                            rs.getFloat("p.Precio"), rs.getBinaryStream("p.Imagen"), 
                            marca);
                productos.add(producto);
            }
            sql.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return productos;
    }
    
    /**
     * BLOQUE: Buscar Productos por Nombre.
     * Retorna una lista de productos que coincidan parcialmente con el texto ingresado (LIKE).
     */
    public ArrayList<Producto> MostrarProductos(String str){
        ArrayList<Producto> ar = new ArrayList<Producto>();
        try{
            sql = conectar().prepareStatement("SELECT * FROM Producto p INNER JOIN "
                    + "Marca m ON p.IdMarca=m.Id WHERE p.Nombre LIKE '%" + str + "%'");
            rs = sql.executeQuery();
            while(rs.next()){
                marca = new Marca(rs.getInt("m.Id"), rs.getString("m.Nombre"));
                producto = new Producto(rs.getInt("p.Id"), rs.getString("p.Nombre"), 
                        rs.getFloat("p.Precio"), rs.getBinaryStream("p.Imagen"), marca);
                ar.add(producto);
            }
            sql.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
    
    /**
     * BLOQUE: Obtener Producto por ID.
     * Busca un producto específico para ser editado o visualizado.
     */
    public Producto ObtenerProductoPorId(int id){
        try{
            sql = conectar().prepareStatement("SELECT * FROM Producto p "
                    + "INNER JOIN Marca m ON p.IdMarca=m.Id WHERE p.Id=?");
            sql.setInt(1, id);
            rs = sql.executeQuery();
            while(rs.next()){
                marca = new Marca(rs.getInt("m.Id"), rs.getString("m.Nombre"));
                producto = new Producto(rs.getInt("p.Id"), rs.getString("p.Nombre"), 
                            rs.getFloat("p.Precio"), rs.getBinaryStream("p.Imagen"), 
                            marca);
            }
            sql.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return producto;
    }
    
    /**
     * BLOQUE: Mostrar Imagen.
     * Extrae el BLOB de la imagen desde la base de datos y lo convierte a una cadena Base64
     * para que pueda ser renderizada directamente en el HTML del navegador.
     */
    public String MostrarImg(int id){
        byte[] imagenBytes = null;
        try{
            sql = conectar().prepareStatement("SELECT * FROM Producto WHERE Id=?");
            sql.setInt(1, id);
            rs = sql.executeQuery();
            if(rs.next()){
                Blob blob = rs.getBlob("Imagen");
                imagenBytes = blob.getBytes(1, (int)blob.length());
            }
            sql.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(imagenBytes);
    }
}
