package Programas;
import java.util.Scanner;

public class operaciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int b, a, r = 0, opc;
        
        System.out.println("Digite valor de la base: ");
        b = sc.nextInt();
        
        System.out.println("Digite valor de la altura: ");
        a = sc.nextInt();
        
        System.out.println("            MENU DE OPCIONES                ");
        System.out.println("============================================");
        System.out.println("");
        System.out.println("1. Area de rectangulo");
        System.out.println("2. Permietro de rectangulo");
        System.out.println("============================================");
        System.out.println("¿Que desea calcular?");
        opc = sc.nextInt();
        
        switch(opc){
            case 1:
                r = b * a;
                break;
            case 2:
                r = 2 * b + 2 * a;
                break;
            default:
                System.out.print("Opcion no valida: " );
                break;
        }
        
        System.out.println("El resultado es: " + r);
    }
    
}
