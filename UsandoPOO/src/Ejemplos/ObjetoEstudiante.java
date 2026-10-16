package Ejemplos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ObjetoEstudiante {

    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Luis");
        estudiante1.setApellidos("Perez");
        estudiante1.setFecha(LocalDate.parse("15/08/2003", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        estudiante1.setDireccion("San Salvador");
        estudiante1.setTelefono("7890-1234");
        estudiante1.setGenero("Masculino");
        estudiante1.setCarnet("LP2023001");
        estudiante1.setCarrera("Ingenieria en Sistemas");
        estudiante1.setPromedio(8.5);

        Estudiante estudiante2 = new Estudiante(
                "MR2023015",
                "Ingenieria Industrial",
                5.8,
                "Marta",
                "Ramirez",
                LocalDate.parse("22/02/2004", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "La Libertad",
                "7654-3210",
                "Femenino"
        );

        mostrarDatos(estudiante1);
        mostrarDatos(estudiante2);
    }

    public static void mostrarDatos(Estudiante estudiante) {
        System.out.println("DATOS DEL ESTUDIANTE");
        System.out.println("--------------------");
        System.out.println("Nombre: " + estudiante.nombreCompleto());
        System.out.println("Edad: " + estudiante.calcularEdad() + " años");
        System.out.println("Direccion: " + estudiante.getDireccion());
        System.out.println("Telefono: " + estudiante.getTelefono());
        System.out.println("Genero: " + estudiante.getGenero());
        System.out.println("Carnet: " + estudiante.getCarnet());
        System.out.println("Carrera: " + estudiante.getCarrera());
        System.out.println("Promedio: " + String.format("%.2f", estudiante.getPromedio()));
        System.out.println("Estado academico: " + estudiante.estadoAcademico());
        System.out.println();
    }
}
