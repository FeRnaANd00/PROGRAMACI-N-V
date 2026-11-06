package com.uma.webproductos.models;

public class Conexion {
    String driver = "org.mariadb.jdbc.Driver";
    String url = "jdbc:mariadb://localhost:3307/ProductosBD";
    String user = "root";
    String password = "lest81";

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
