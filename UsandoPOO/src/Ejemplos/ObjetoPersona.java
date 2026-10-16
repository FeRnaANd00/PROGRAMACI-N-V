package Ejemplos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ObjetoPersona {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        persona1.setNombre("Jose");
        persona1.setApellidos("Juarez");
        persona1.setFecha(LocalDate.parse("10/01/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        persona1.setDireccion("Sonsonate");
        persona1.setTelefono("7854-8589");
        persona1.setGenero("Masculino");

        Persona persona2 = new Persona("Ana", "Diaz",
                LocalDate.parse("12/12/2002", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "Sonsonate", "7645-7656", "Femenino");

        mostrarDatos(persona1);
        mostrarDatos(persona2);
    }

    public static void mostrarDatos(Persona persona) {
        System.out.println("DATOS DE PERSONA");
        System.out.println("---------------");
        System.out.println("Nombre: " + persona.nombreCompleto());
        System.out.println("Fecha de nacimiento: " +
                persona.getFecha().format(DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy")));
        System.out.println("Edad: " + persona.calcularEdad() + " años");
        System.out.println("Direccion: " + persona.getDireccion());
        System.out.println("Telefono: " + persona.getTelefono());
        System.out.println("Genero: " + persona.getGenero());
        System.out.println();
    }
}
