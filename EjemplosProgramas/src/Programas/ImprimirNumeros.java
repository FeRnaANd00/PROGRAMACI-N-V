package Programas;
import java.util.Scanner;

public class ImprimirNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n ;
        
        for(int i = 1; i <= 5; i++ ){
            System.out.print("Ingrese valor: ("+ i +"):");
            n = sc.nextInt();
            System.out.println(n);
        
        }
    }
}
