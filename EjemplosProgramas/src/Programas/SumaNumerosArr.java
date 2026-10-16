package Programas;
import java.util.Scanner;

public class SumaNumerosArr {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        int[] num = new int[5];
        int suma = 0;
        
        for(int i = 0; i <=4 ; i++){
            System.out.println("Ingrese número: ("+ i +")");
            num[i] = teclado.nextInt();
            suma = suma + num[i];
        }
        
        System.out.println("------------------------------");
        
        for(int n:num){
        System.out.println(n);
        }
        
        System.out.println("La suma es: " + suma);
    }
    
}
