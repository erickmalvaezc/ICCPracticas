import java.util.*;

public class Recipiente implements ServiciosRecipiente{
	public int radio, altura;
	public final double PI = 3.1416;
	public double contenido = 0;

	public Recipiente(int radio, int altura){
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


	public void vierte(Recipiente otro) {
    		double capacidadDisponible = otro.capacidadRestante();
    		if (capacidadDisponible >= this.contenido) {
        		otro.contenido += this.contenido;
        		this.contenido = 0;
    		} else {
        		otro.contenido = otro.capacidad();
        		this.contenido -= capacidadDisponible;
   		 }
	}


	public boolean mismasDimensiones(Recipiente otro) {
    		return this.radio == otro.radio && this.altura == otro.altura;
	}


	public boolean mismaCapacidad(Recipiente otro) {
   		return this.capacidad() == otro.capacidad();
	}


	public boolean contieneMas(Recipiente otro) {
    		return this.contenido > otro.contenido;
	}

	
	public boolean cabeMas(Recipiente otro) {
    		return this.capacidadRestante() > otro.capacidadRestante();
	}

	
	public Recipiente creaContenedorJusto() {
    		int nuevaAltura = (int) (this.contenido / (PI * radio * radio));
    		return new Recipiente(this.radio, nuevaAltura);
	}


	public String muestra() {
		return String.format("Recipiente [Radio: %d, Altura: %d, Capacidad: %.2f, Contenido: %.2f]", radio, altura, capacidad(), contenido);
	}	

}
