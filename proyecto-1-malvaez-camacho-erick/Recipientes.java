import java.util.*;

public class Recipientes implements ServiciosRecipiente{
	public int radio, altura;
	public final double PI = 3.1416;
	public double contenido = 0;

	public Recipientes(int radio, int altura){
		this.radio = radio;
		this.altura = altura;
	}

	public double capacidad(){
		return PI*radio*radio*altura;
	}

	public double capacidadRestante (){
		return capacidad()-contenido; 
	}

	public boolean estaVacio(){
		return contenido == 0;
	}


	public boolean estaLleno(){
		return contenido == capacidad();
	}

	public double rellena(double cantidad){
		if(capacidad() > contenido + cantidad){
			contenido = contenido + cantidad;
			System.out.print(" >> El recipiente ahora tiene: " + contenido);
			return contenido;
		}else{
			double temp = contenido + cantidad;
			contenido = capacidad();
			System.out.print(" >> El recipiente se lleno( "+ contenido +" ) y sobraron: " + (temp-capacidad()));
			return temp-capacidad();
		}
	}

	public double vacia(){
		contenido = 0;
		return contenido; 
	}


	public void vierte(Recipientes otro) {
    		double capacidadDisponible = otro.capacidadRestante();
    		if (capacidadDisponible >= this.contenido) {
        		otro.contenido += this.contenido;
        		this.contenido = 0;
    		} else {
        		otro.contenido = otro.capacidad();
        		this.contenido -= capacidadDisponible;
   		 }
	}


	public boolean mismasDimensiones(Recipientes otro) {
    		return this.radio == otro.radio && this.altura == otro.altura;
	}


	public boolean mismaCapacidad(Recipientes otro) {
   		return this.capacidad() == otro.capacidad();
	}


	public boolean contieneMas(Recipientes otro) {
    		return this.contenido > otro.contenido;
	}

	
	public boolean cabeMas(Recipientes otro) {
    		return this.capacidadRestante() > otro.capacidadRestante();
	}

	
	public Recipientes creaContenedorJusto() {
    		int nuevaAltura = (int) (this.contenido / (PI * radio * radio));
    		return new Recipientes(this.radio, nuevaAltura);
	}


	public String muestra() {
		return String.format("Recipiente [Radio: %d, Altura: %d, Capacidad: %.2f, Contenido: %.2f]", radio, altura, capacidad(), contenido);
	}	


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        	System.out.print("Ingrese el radio del recipiente: ");
        	int radio = sc.nextInt();
        	System.out.print("Ingrese la altura del recipiente: ");
        	int altura = sc.nextInt();

	        Recipientes recipiente = new Recipientes(radio, altura);
        	Recipientes otroRecipiente = new Recipientes(3, 5); // Recipiente secundario para operaciones

	        int opcion;
        	do {
            		System.out.println("\n---------------------------------------------------\n--------------------- M E N U ---------------------\n---------------------------------------------------");
            		System.out.println("1. Calcular capacidad");
            		System.out.println("2. Capacidad restante");
            		System.out.println("3. ¿Está vacío?");
            		System.out.println("4. ¿Está lleno?");
            		System.out.println("5. Rellenar recipiente");
            		System.out.println("6. Vaciar recipiente");
            		System.out.println("7. Verter en otro recipiente");
            		System.out.println("8. Comparar dimensiones con otro recipiente");
            		System.out.println("9. Comparar capacidad con otro recipiente");
            		System.out.println("10. Comparar cantidad con otro recipiente");
            		System.out.println("11. Comparar espacio restante con otro recipiente");
            		System.out.println("12. Crear contenedor justo");
            		System.out.println("13. Mostrar información del recipiente");
           		System.out.println("(Cualquier otro numero) Salir");
            		System.out.print("Seleccione una opción: ");
            		opcion = sc.nextInt();

            		switch (opcion) {
                		case 1:
                    			System.out.println(" >> Capacidad del recipiente: " + recipiente.capacidad());
                    			break;
		                case 2:
                	    		System.out.println(" >> Capacidad restante: " + recipiente.capacidadRestante());
                    			break;
     	        		case 3:
        	            		System.out.println(recipiente.estaVacio() ? " >> El recipiente está vacío" : " >> El recipiente tiene líquido");
                    			break;
                		case 4:
                    			System.out.println(recipiente.estaLleno() ? " >> El recipiente está lleno" : " >> El recipiente no está lleno");
                    			break;
                		case 5:
                    			System.out.print(" >> Ingresa cuanto quieres añadir: ");
                   			double cantidad = sc.nextDouble();
		    			recipiente.rellena(cantidad);
                    			break;
                		case 6:
                    			System.out.println(" >> El recipiente ahora esta vacio, se quitaron: " + recipiente.vacia());
                    			break;
                		case 7:
					recipiente.vierte(otroRecipiente);
                    			System.out.println("Nuevo estado del recipiente principal: " + recipiente.muestra());
                    			System.out.println("Nuevo estado del otro recipiente: " + otroRecipiente.muestra());
                    			break;
                		case 8:
                    			System.out.println(recipiente.mismasDimensiones(otroRecipiente) ? " >> Si tienen las mismas dimensiones." : " >> No tienen las mismas dimensiones.");
                    			break;
                		case 9:
                    			System.out.println(recipiente.mismaCapacidad(otroRecipiente) ? " >> Si tienen la misma capacidad" : " >> No tienen la misma capacidad");
                    			break;
                		case 10:
                    			System.out.println(recipiente.contieneMas(otroRecipiente) ? " >> El recipiente tiene más líquido" : " >> El otro recipiente tiene más líquido");
                    			break;
                		case 11:
                    			System.out.println(recipiente.cabeMas(otroRecipiente) ? " >> El recipiente tiene más capacidad" : "El otro recipiente tiene más capacidad");
                    			break;
                		case 12:
                    			Recipientes nuevoRecipiente = recipiente.creaContenedorJusto();
                    			System.out.println("Se creó un nuevo recipiente con estas características: " + nuevoRecipiente.muestra());
                    			break;
                		case 13:
                    			System.out.println("Información del recipiente: " + recipiente.muestra());
                    			break;
                		default:
                    			System.out.println("Adios :)");
					sc.close();
		    			return;
            		}
		} while (true);
	}
}
