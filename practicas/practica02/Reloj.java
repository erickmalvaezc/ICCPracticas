public class Reloj{
	private int segundo, minuto, hora;
		
	public Reloj(int hora, int minuto){
		this.segundo = 55;
		this.minuto  = minuto;
		this.hora = hora;
	}

	public void iniciar() throws InterruptedException {
		while (true) {  
			for(; hora < 12; hora++){
				for(; minuto < 60; minuto++){	
               				for(; segundo < 60; segundo++){
						Thread.sleep(1000);
						System.out.printf("%02d:%02d:%02d%n \n", hora, minuto, segundo);
	            			}
					segundo = 0;
				}
				minuto = 0; 
			}
				hora = 1;
		}
	
    	}
}
