import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println
			("---------------------------------------\n-------- C A L C U L A D O R A --------\n---------------------------------------\n---- 1. Suma de dos Numeros -----------\n---- 2. Multiplicacion de dos Numeros--\n---- 3. Dividision de dos Numeros------\n---- 4. Cerra -------------------------\n---------------------------------------\n------- Selecciona una opcion ---------");
		int n = scanner.nextInt();
		int x, y;
		if( n >= 1 && n <= 5){
			if( n == 1){
				System.out.println("Dame dos numeros para sumar\nDame el primer numero");
				x = scanner.nextInt();
				System.out.println("Dame el segundo numero");
				y = scanner.nextInt();
				System.out.println("La suma de " + x + " y " + y + " es: " + (x+y));
			}

			if( n == 2 ){
				System.out.println("Dame dos numeros para multiplicar\nDame el primer numero:");
                                x = scanner.nextInt();
				System.out.println("Dame el segundo numero");
                                y = scanner.nextInt();
                                System.out.println("La multiplicacion de " + x + " por " + y + " es: " + (x*y));
			}

			if( n == 3){
				System.out.println("Dame dos numeros(flotantes) para dividir \nDame el Dividendo:");
                                float a = scanner.nextFloat();
				System.out.println("Dame el Divisor:");
                                float b = scanner.nextFloat();
				if(b!=0){
					float res = a/b;
					System.out.println("La division de " + a + " entre " + b + " es: " + res);
				}
				else
					System.out.println("No se puede divir entre 0");
			}
			if( n == 5 ){
				System.out.println("Adios ;)");
			}	
		}else{
			System.out.println("Opcion no valida");
		}		
	}
}
