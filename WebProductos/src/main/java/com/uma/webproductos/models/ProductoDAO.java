package com.uma.webproductos.models;

import java.sql.*;
import java.util.*;
public class ProductoDAO {
    PreparedStatement sql;
    ResultSet rs;
    Conexion con = new Conexion();
    Marca marca;
    Producto producto;
    
    Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }
    
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
