package Ejemplos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ArrayList;

public class ObjetoEmpleado {

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado();
        empleado1.setNombre("Carlos");
        empleado1.setApellidos("Mendez");
        empleado1.setFecha(LocalDate.parse("05/03/1995", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        empleado1.setDireccion("San Salvador");
        empleado1.setTelefono("2222-3333");
        empleado1.setGenero("Masculino");
        empleado1.setCargo("Desarrollador");
        empleado1.setSueldo(1500.00);

        Empleado empleado2 = new Empleado(
                "Contador",
                1200.00,
                "Maria",
                "Lopez",
                LocalDate.parse("20/07/1990", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "Santa Ana",
                "2444-5566",
                "Femenino"
        );

        ArrayList<Empleado> empleados2 = new ArrayList<Empleado>();
        empleados2.add(empleado1);
        empleados2.add(empleado2);
        
        for(Empleado emp:empleados2){
        mostrarDatos(emp, 1);
        }
        
        /*
        
        Utilizando  for each
        Empleado [] empleados = {empleado1, empleado2};
        
        for(Empleado emp: empleados){
        mostrarDatos(emp, 2);
        }
        */      
                
        /*mostrarDatos(empleado1, 1);
        mostrarDatos(empleado2, 2);*/
    }

    public static void mostrarDatos(Empleado empleado, int tipoContrato) {
        System.out.println("DATOS DEL EMPLEADO");
        System.out.println("------------------");
        System.out.println("Nombre: " + empleado.nombreCompleto());
        System.out.println("Edad: " + empleado.calcularEdad() + " años");
        System.out.println("Direccion: " + empleado.getDireccion());
        System.out.println("Telefono: " + empleado.getTelefono());
        System.out.println("Genero: " + empleado.getGenero());
        System.out.println("Cargo: " + empleado.getCargo());
        System.out.println("Sueldo bruto: $" + String.format("%.2f", empleado.getSueldo()));
        System.out.println("Tipo de contrato: " + (tipoContrato == 1 ? "Planilla (con descuentos de ley)" : "Servicios profesionales"));
        System.out.println("Sueldo neto: $" + String.format("%.2f", empleado.sueldoNeto(tipoContrato)));
        System.out.println();
    }
}
