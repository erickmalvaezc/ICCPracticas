import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println
			("---------------------------------------\n-------- C A L C U L A D O R A --------\n---------------------------------------\n---- 1. Suma de dos Numeros -----------\n---- 2. Multiplicacion de dos Numeros--\n---- 3. Dividision de dos Numeros------\n---------------------------------------\n------- Selecciona una opcion ---------");
		int n = scanner.nextInt();
		int x, y;
		if( n >= 1 && n <= 3){
			if( n == 1){
				System.out.println("Dame dos numeros para sumar");
				x = scanner.nextInt();
				y = scanner.nextInt();
				System.out.println("La suma de " + x + " y " + y + " es: " + (x+y));
			}

			if( n == 2 ){
				System.out.println("Dame dos numeros para multiplicar");
                                x = scanner.nextInt();
                                y = scanner.nextInt();
                                System.out.println("La multiplicacion de " + x + " por " + y + " es: " + (x*y));
			}

			if( n == 3){
				System.out.println("Dame dos numeros(flotantes) para dividir");
                                float a = scanner.nextFloat();
                                float b = scanner.nextFloat();
				float res = a/b;
                                System.out.println("La division de " + a + " entre " + b + " es: " + res);
			}
		}else{
			System.out.println("Opcion no valida");
		}		
	}
}
