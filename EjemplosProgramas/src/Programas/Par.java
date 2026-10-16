package Programas;

import java.util.Scanner;

public class Par {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numero;
        
        System.out.println("Digite el numero: ");
        numero = sc.nextInt();
        
        if(numero % 2 == 0)
            System.out.println("El numero ingresado es par: ");
        else 
            System.out.println("El numero es impar");
        
    }
    
}
