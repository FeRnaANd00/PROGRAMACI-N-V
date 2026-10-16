package Ejemplos;
import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellidos;
    private LocalDate fecha;
    private String direccion;
    private String telefono;
    private String genero;

    public Persona() {
        
    }

    public Persona(String nombre, String apellidos, LocalDate fecha, String direccion, String telefono, String genero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha = fecha;
        this.direccion = direccion;
        this.telefono = telefono;
        this.genero = genero;
    }
    
    public String nombreCompleto(){
        return nombre + " " + apellidos;
    }
    
    public int calcularEdad(){
        LocalDate fechaActual = LocalDate.now();
        int edad = fechaActual.getYear() - fecha.getYear();
        if (fechaActual.getMonthValue() < fecha.getMonthValue() ||
            (fechaActual.getMonthValue() == fecha.getMonthValue() &&
             fechaActual.getDayOfMonth() < fecha.getDayOfMonth())) {
            edad--;
        }
        return edad;
    }
    
    //Metodos getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
    
    
    
}
