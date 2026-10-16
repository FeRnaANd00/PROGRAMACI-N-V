package Programas;
import java.util.Scanner;

public class MayorArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];
        int mayor;
        
        for(int i  = 1; 1 < 4; i++){
            System.out.println("Ingrese números: ("+ i +")" );
            num[i] = sc.nextInt();
        }
    }
    
}
