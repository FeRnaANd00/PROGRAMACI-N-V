package Programas;
import java.util.Scanner;

public class EcuacionCuadratica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite el primer valor de la ecuacion cuadratica 'A' ");
        int a = sc.nextInt();
        
        System.out.println("Digite el segundo valor de la ecuacion cuadratica 'B' ");
        int b = sc.nextInt();
        
        System.out.println("Digite el tercer valor de la ecuacion cuadratica 'C' ");
        int c = sc.nextInt();
        
        double resultpositivo = (- b + Math.sqrt(Math.pow(b,2) -4*a*c))/(2*a);
        
        double resultnegativo = (- b - Math.sqrt(Math.pow(b,2) -4*a*c))/(2*a);
        
        System.out.println("Su respuesta positiva es: " + resultpositivo);
        System.out.println();
        System.out.println("Su respuesta negativa es: " + resultnegativo);
    }
    
}
