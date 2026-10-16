package Ejemplos;

import java.time.LocalDate;

public class Estudiante extends Persona {
    private String carnet;
    private String carrera;
    private double promedio;

    public Estudiante() {
    }

    public Estudiante(String carnet, String carrera, double promedio,
                      String nombre, String apellidos, LocalDate fecha,
                      String direccion, String telefono, String genero) {
        super(nombre, apellidos, fecha, direccion, telefono, genero);
        this.carnet = carnet;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    public String estadoAcademico() {
        if (promedio >= 7.0) {
            return "Aprobado";
        } else if (promedio >= 6.0) {
            return "Recuperacion";
        } else {
            return "Reprobado";
        }
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
}
