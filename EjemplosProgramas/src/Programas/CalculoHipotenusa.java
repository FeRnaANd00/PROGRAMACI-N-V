package Programas;
import java.util.Scanner;

public class CalculoHipotenusa {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        double a, b, c;
        
        System.out.print("Digite el valor del primer cateto: ");
        a = sc.nextDouble();
        System.out.print("Digite el valor del segundo cateto: ");
        b = sc.nextDouble();
        
        c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        
        System.out.println("El valor de la hipotenusa es: " + String.format("%.3f", c));
    }
    
}
