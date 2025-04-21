import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Reloj reloj = new Reloj(11, 59); // Valor inicial

        int opcion;

        do {
            System.out.println("\n----- MENÚ DEL RELOJ -----");
            System.out.println("1. Iniciar reloj");
            System.out.println("2. Configurar hora");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    reloj.iniciar();
                    break;
                case 2:
                    System.out.print("Ingrese la hora (1-12): ");
                    int nuevaHora = scanner.nextInt();
                    System.out.print("Ingrese los minutos (0-59): ");
                    int nuevosMinutos = scanner.nextInt();
                    reloj = new Reloj(nuevaHora, nuevosMinutos); // Actualiza el reloj
                    System.out.println("Hora configurada correctamente.");
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}

