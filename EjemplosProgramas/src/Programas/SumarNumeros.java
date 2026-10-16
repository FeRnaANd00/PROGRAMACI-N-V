package Programas;

import java.util.Scanner;
public class SumarNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2, suma;
        
        System.out.print("Ingrese primer valor: ");
        n1 = Integer.parseInt(sc.next()); //convierte primero a entero con el  Integer.parseInt y luego solo lee el primer caracter tipo texto en numero siempre toma el numero 
        System.out.print("Ingrese el segundo valr: ");
        n2 = sc.nextInt(); //manera mas eficiente de hacer la conversión
        
        suma = n1 + n2;
        
        System.out.println("La suma es: " + suma);
    }
    
}
