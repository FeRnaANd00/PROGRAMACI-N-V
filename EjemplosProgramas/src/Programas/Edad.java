
package Programas;
import java.util.Scanner;

public class Edad {
    static void main() {
        Scanner sc = new Scanner(System.in);
        
        int edad;
        String categoria;
        
        System.out.println("Digite su edad: ");
        edad = sc.nextInt();
        
        if (edad >= 18)
            categoria = "Mayor de edad";
        else 
            categoria = "Menor de edad";
        
        System.out.println("Su edad es: " + edad);
        System.out.println("Usted es: " + categoria);
    }
}
