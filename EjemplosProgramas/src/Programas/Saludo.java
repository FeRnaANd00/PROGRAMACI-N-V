package Programas;

import java.util.Scanner; //importar clase Scanner
public class Saludo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Crear objeto de Scanner
        String nombre, carrera; //Declaranod variable de cadena
        
        System.out.print("Digite su nombre completo: "); //Mostrar mensaje
        nombre = sc.nextLine();//Asigna cadena digitada
        System.out.print("Digite la carrera que estudia");
        carrera = sc.nextLine();
        
        System.out.println("Hola " + nombre); //Mostrando cadena con println salto de linea
        System.out.println("Estudas" + carrera);
    }
}
