
package Programas;
import java.util.Scanner;
public class CalculoNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n1, n2, n3, nf;
        String estado;
        
        System.out.println("Ingrese la primer nota");
        n1 = sc.nextDouble();
        System.out.println("Ingrese la segunda nota");
        n2 = sc.nextDouble();
        System.out.print("Ingrese la tercera nota");
        n3 = sc.nextDouble();
        
        nf = (n1 + n2 + n3)/3;
        
        if (nf > 5)
            estado = "Aprobado";
        else
            estado = "Reprobado";
            
        System.out.println("Su nota final es: " + String.format("%.2f", nf));
        System.out.println("Usted esta " + estado);
    }
}
