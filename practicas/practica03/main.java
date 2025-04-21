class Main{
	public static void main(String[] args){
		ListaLigada lista = new ListaLigada();
		System.out.println("1. Como se ve la lista vacia: ");
		System.out.println(lista.toString());
		lista.insertar(1);
		lista.insertar(2);
		lista.insertar(3);
		lista.insertar(4);
		lista.insertar(5);
		System.out.println("2. Como se ve la lista con 5 elementos: ");
		System.out.println(lista.toString());
		lista.eliminar(1);
		System.out.println("3. Elimino la cabeza: ");
		System.out.println(lista.toString());
		lista.eliminar(2);
		System.out.println("4. Elimino un el elemento distinto a la cabeza o al ultmo: ");
		System.out.println(lista.toString());
		//lista.eliminar(6);
		System.out.println("EXTRA. Inserto el 100 en el indice 3: ");
		lista.insertarIndice(100, 3);
		System.out.println(lista.toString());
		System.out.println("EXTRA. Intento insertar un elemento en el indice 10: ");
		lista.insertarIndice(100, 10);
		System.out.println(lista.toString());

	}
}

