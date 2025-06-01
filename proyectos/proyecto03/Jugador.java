public class Jugador {
    private String nombre;
    private Lista<Carta> secuencia;
    private int puntos;
    
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.secuencia = new Lista<>();
        this.puntos = 0;
    }
    
    public void agregarCarta(Carta carta) {
        secuencia.agregar(carta);
    }
    
    public Carta getUltimaCarta() {
        if (secuencia.estaVacia()) return null;
        return secuencia.obtener(secuencia.tamaño() - 1);
    }
    
    public boolean validarSecuencia() {
        if (secuencia.tamaño() <= 1) return true;
        
        // checo que cada carta sea compatible con la anterior
        for (int i = 1; i < secuencia.tamaño(); i++) {
            Carta anterior = secuencia.obtener(i - 1);
            Carta actual = secuencia.obtener(i);
            if (!anterior.esCompatible(actual)) {
                return false;
            }
        }
        return true;
    }
    
    public void finalizarRonda(boolean valida) {
        if (valida) {
            puntos += secuencia.tamaño();
        }
        secuencia = new Lista<>(); // empiezo de nuevo para la siguiente ronda
    }
    
    public void mostrarSecuencia() {
        System.out.print(nombre + " - Secuencia: ");
        for (int i = 0; i < secuencia.tamaño(); i++) {
            System.out.print(secuencia.obtener(i) + " ");
        }
        System.out.println("(" + secuencia.tamaño() + " cartas)");
    }
    
    // getters que necesito
    public String getNombre() { return nombre; }
    public int getPuntos() { return puntos; }
    public Lista<Carta> getSecuencia() { return secuencia; }
}