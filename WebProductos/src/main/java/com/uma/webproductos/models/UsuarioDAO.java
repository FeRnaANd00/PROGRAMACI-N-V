package com.uma.webproductos.models;

import java.sql.*;

public class UsuarioDAO {
    PreparedStatement sql;
    ResultSet rs;
    Conexion con = new Conexion();
    
    /**
     * Establece la conexión con la base de datos.
     */
    Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }
    
    /**
     * BLOQUE: Validar Usuario.
     * Busca en la tabla Usuario un registro que coincida exactamente con el correo y la clave.
     * Retorna el objeto Usuario si se encuentra, o null si las credenciales son incorrectas.
     */
    public Usuario ValidarUsuario(String correo, String clave){
        Usuario usuario = null;
        try{
            sql = conectar().prepareStatement("SELECT * FROM Usuario WHERE "
                    + "Correo=? AND Clave=?");
            sql.setString(1, correo);
            sql.setString(2, clave);
            rs = sql.executeQuery();
            while(rs.next()){
                usuario = new Usuario(rs.getInt(1), rs.getString(2), 
                        rs.getString(3), rs.getString(4));
            }
            sql.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return usuario;
    }
}
