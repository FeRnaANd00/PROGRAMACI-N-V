package com.uma.webproductos.models;
import java.sql.*;
import java.util.*;

public class MarcaDAO {
PreparedStatement sql;
ResultSet rs;
Conexion con = new Conexion();
Marca marca;

Connection conectar() throws SQLException, ClassNotFoundException{
    Class.forName(con.getDriver());
    return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
}

public int InsertarMarca (Marca marca){
    int n = 0;
  
    try{
        sql = conectar().prepareCall("INSERT INTO Marca(Nombre) " + "VALUE(?)");
        sql.setString(1, marca.getNombre());
        n = sql.executeUpdate();
        sql.close();
    }catch(Exception ex){
        ex.printStackTrace();
    }
    return n;
}
}
