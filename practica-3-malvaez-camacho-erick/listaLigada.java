class ListaLigada{
	Nodo cabeza;
	
	public void listaLigada(){
		cabeza.siguiente = null;
	}

	public void insertar(int elemento){
		Nodo nuevo = new Nodo();
		nuevo.elemento = elemento;
        	if (cabeza == null) { 
            		cabeza = nuevo;
        	} else { 
            		Nodo aux = cabeza;
            		while (aux.siguiente != null) { 
                		aux = aux.siguiente;
            	}
            	aux.siguiente = nuevo; //Esto sirve por que es un paso por referencia, entonces modifica al nodo como tal
        	}

		/*
		Nodo nuevo = new Nodo();
		nuevo.elemento = elemento;
		nuevo.siguiente = cabeza;
		cabeza = nuevo;
		*/
	}

	public void eliminar(int indice){
		Nodo aux = cabeza;
		
		if(indice == 1){
			cabeza = cabeza.siguiente;
		}

		for(int i = 1; i < indice-1; i++ ){
			if(aux.siguiente != null){
				aux = aux.siguiente;
			}else{
				return;
			}	
		}
		aux.siguiente = aux.siguiente.siguiente;
		
	}
	
	public String toString(){
		Nodo aux = cabeza;
		String cadena = "";
		while(aux != null){
			cadena += aux.elemento + " -> ";
			aux = aux.siguiente;
		}
		return cadena;
	}
	
	public void insertarIndice(int elemento, int indice){
		Nodo aux = cabeza;
		if(indice <= 0){
			return;
		}
		for(int i = 1; i < indice-1; i++ ){
                        if(aux.siguiente != null){
                                 aux = aux.siguiente;
                         }else{
                                 return;
                         }       
                 }
		Nodo nuevo = new Nodo();
		nuevo.elemento = elemento;
		nuevo.siguiente = aux.siguiente;
		aux.siguiente = nuevo;
	}
}


