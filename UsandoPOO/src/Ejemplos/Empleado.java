package Ejemplos;

import java.time.LocalDate;

public class Empleado extends Persona{
    private String cargo;
    private double sueldo;

    public Empleado() {
    }

    public Empleado(String cargo, double sueldo, String nombres, String apellidos, LocalDate fecha, String direccion, String telefono, String genero) {
        super(nombres, apellidos, fecha, direccion, telefono, genero);
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public double sueldoNeto(int contrato){
        double SN;
        if(contrato == 1)
            SN = sueldo - (sueldo * 0.03 + sueldo *0.0725 + sueldo * 0.10);
        else
            SN = sueldo - sueldo *0.10;
        return SN;
        
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    
}
