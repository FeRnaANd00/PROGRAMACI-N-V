package Programas;
import java.util.Scanner;
public class RaizCuadrada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n, raiz;
        
        System.out.print("Digite un número: ");
        //n = Double.parseDouble(sc.next());
        n = sc.nextDouble();
        raiz = Math.sqrt(n);
        
        System.out.println("Raíz cuadrada: " + String.format("%.2f", raiz));
    }
}
