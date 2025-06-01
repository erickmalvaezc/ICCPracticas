import java.util.Random;
import java.util.Scanner;

public class PickAPerro {
    private Lista<Carta> mazo;
    private Carta[][] zonaJuego; // 5 filas por 6 columnas
    private Jugador usuario;
    private Jugador ia;
    private Random random;
    private Scanner scanner;
    private int rondaActual;
    
    public PickAPerro() {
        this.mazo = new Lista<>();
        this.zonaJuego = new Carta[5][6];
        this.usuario = new Jugador("Usuario");
        this.ia = new Jugador("IA");
        this.random = new Random(12345); // uso semilla fija para que sea mas facil debuggear
        this.scanner = new Scanner(System.in);
        this.rondaActual = 1;
        
        crearMazo();
        barajearMazo();
    }
    
    private void crearMazo() {
        // creo las 32 cartas unicas, 3 copias de cada una para llegar a 96
        for (int tamaño = 0; tamaño < 2; tamaño++) {
            for (int color = 0; color < 3; color++) {
                for (int brazos = 0; brazos < 2; brazos++) {
                    for (int gafas = 0; gafas < 2; gafas++) {
                        for (int palomitas = 0; palomitas < 2; palomitas++) {
                            // 3 copias de cada combinacion
                            for (int copia = 0; copia < 3; copia++) {
                                mazo.agregar(new Carta(tamaño, color, brazos, gafas, palomitas));
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void barajearMazo() {
        // uso Fisher-Yates pero adaptado para mi lista
        for (int i = mazo.tamaño() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            
            // intercambio elementos i y j
            Carta temp1 = mazo.obtener(i);
            Carta temp2 = mazo.obtener(j);
            
            // tengo que eliminar y agregar porque mi lista no tiene set
            mazo.eliminar(i);
            mazo.agregar(temp2);
            if (j != mazo.tamaño() - 1) {
                mazo.eliminar(j);
                mazo.agregar(temp1);
            }
        }
    }
    
    private void inicializarRonda() {
        // le doy una carta de inicio a cada jugador
        if (!mazo.estaVacia()) {
            usuario.agregarCarta(mazo.eliminar(0));
        }
        if (!mazo.estaVacia()) {
            ia.agregarCarta(mazo.eliminar(0));
        }
        
        // lleno la zona de juego con 30 cartas (5x6)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (!mazo.estaVacia()) {
                    zonaJuego[i][j] = mazo.eliminar(0);
                }
            }
        }
    }
    
    private void mostrarEstado(Jugador jugadorActual) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RONDA " + rondaActual + " - Turno de: " + jugadorActual.getNombre());
        System.out.println("=".repeat(50));
        
        // muestro los puntos actuales
        System.out.println("Puntos - " + usuario.getNombre() + ": " + usuario.getPuntos() + 
                          " | " + ia.getNombre() + ": " + ia.getPuntos());
        
        // carta guia del jugador actual
        Carta ultimaCarta = jugadorActual.getUltimaCarta();
        System.out.println("\nCarta guia de " + jugadorActual.getNombre() + ": " + 
                          (ultimaCarta != null ? ultimaCarta : "Sin carta"));
        
        // zona de juego completa
        System.out.println("\nZona de juego:");
        System.out.println("Formato: [Pos]Tamaño-Brazos-Gafas-Palomitas");
        for (int i = 0; i < 5; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            for (int j = 0; j < 6; j++) {
                if (zonaJuego[i][j] != null) {
                    System.out.print("[" + (i * 6 + j + 1) + "]" + zonaJuego[i][j] + " ");
                } else {
                    System.out.print("[" + (i * 6 + j + 1) + "]---- ");
                }
            }
            System.out.println();
        }
        System.out.println("Leyenda: P=Pequeño G=Grande, 1=UnBrazo 2=DosBrazos, G=ConGafas -=SinGafas, P=ConPalomitas -=SinPalomitas");
    }
    
    private boolean turnoUsuario() {
        mostrarEstado(usuario);
        System.out.println("\nQue quieres hacer?");
        System.out.println("1. Tomar una carta (escribe el numero de 1 a 30)");
        System.out.println("2. Terminar ronda (ya no puedo continuar)");
        System.out.print("Tu opcion: ");
        
        try {
            int opcion = Integer.parseInt(scanner.nextLine().trim());
            
            if (opcion == 1) {
                System.out.print("Numero de carta (1-30): ");
                int numCarta = Integer.parseInt(scanner.nextLine().trim());
                
                if (numCarta < 1 || numCarta > 30) {
                    System.out.println("ERROR: Numero invalido. Debe ser entre 1 y 30.");
                    return turnoUsuario(); // que lo intente de nuevo
                }
                
                int fila = (numCarta - 1) / 6;
                int columna = (numCarta - 1) % 6;
                
                if (zonaJuego[fila][columna] == null) {
                    System.out.println("ERROR: Esa posicion ya esta vacia.");
                    return turnoUsuario();
                }
                
                Carta cartaElegida = zonaJuego[fila][columna];
                usuario.agregarCarta(cartaElegida);
                zonaJuego[fila][columna] = null; // quito la carta de la zona
                
                System.out.println("OK - Tomaste la carta: " + cartaElegida);
                return true; // seguir jugando
                
            } else if (opcion == 2) {
                return false; // terminar la ronda
            } else {
                System.out.println("ERROR: Opcion invalida. Usa 1 o 2.");
                return turnoUsuario();
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Por favor ingresa un numero valido.");
            return turnoUsuario();
        }
    }
    
    private boolean turnoIA() {
        mostrarEstado(ia);
        System.out.println("La IA esta pensando sus opciones...");
        
        try {
            Thread.sleep(1500); // pausa dramatica
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        Carta cartaGuia = ia.getUltimaCarta();
        if (cartaGuia == null) {
            System.out.println("ERROR: IA sin carta guia, algo salio mal");
            return false;
        }
        
        // busco una carta compatible en la zona
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (zonaJuego[i][j] != null && cartaGuia.esCompatible(zonaJuego[i][j])) {
                    Carta cartaElegida = zonaJuego[i][j];
                    ia.agregarCarta(cartaElegida);
                    zonaJuego[i][j] = null;
                    
                    System.out.println("IA tomo la carta: " + cartaElegida + 
                                     " (era la posicion " + (i * 6 + j + 1) + ")");
                    return true;
                }
            }
        }
        
        System.out.println("IA dice: Ya no hay cartas validas, termino la ronda.");
        return false;
    }
    
    private boolean verificarFinRonda(Jugador jugador) {
        Carta cartaGuia = jugador.getUltimaCarta();
        if (cartaGuia == null) return true;
        
        // checo si realmente no hay cartas compatibles disponibles
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (zonaJuego[i][j] != null && cartaGuia.esCompatible(zonaJuego[i][j])) {
                    return false; // todavia hay cartas disponibles
                }
            }
        }
        return true; // no hay cartas compatibles, termino bien
    }
    
    private void procesarFinRonda(boolean usuarioTermino) {
        System.out.println("\n" + "=".repeat(25) + " FIN DE RONDA " + "=".repeat(25));
        
        // muestro las secuencias que armaron
        usuario.mostrarSecuencia();
        ia.mostrarSecuencia();
        
        boolean usuarioValido = usuario.validarSecuencia();
        boolean iaValida = ia.validarSecuencia();
        
        System.out.println("\n--- REVISION DE JUGADAS ---");
        
        if (usuarioTermino) {
            boolean puedeTerminar = verificarFinRonda(usuario);
            if (puedeTerminar) {
                System.out.println("BIEN: Terminaste la ronda correctamente");
                // bonus por terminar bien
                if (usuarioValido) {
                    darCartaBonus(usuario);
                }
            } else {
                System.out.println("MAL: Terminaste la ronda pero todavia habia cartas validas");
                usuarioValido = false; // lo castigo por terminar mal
            }
        }
        
        System.out.println("Secuencia de " + usuario.getNombre() + ": " + 
                          (usuarioValido ? "VALIDA" : "INVALIDA"));
        System.out.println("Secuencia de " + ia.getNombre() + ": " + 
                          (iaValida ? "VALIDA" : "INVALIDA"));
        
        // actualizo puntos segun si las secuencias fueron validas
        usuario.finalizarRonda(usuarioValido);
        ia.finalizarRonda(iaValida);
        
        System.out.println("\n--- PUNTOS ACTUALES ---");
        System.out.println(usuario.getNombre() + ": " + usuario.getPuntos() + " puntos");
        System.out.println(ia.getNombre() + ": " + ia.getPuntos() + " puntos");
    }
    
    private void darCartaBonus(Jugador jugador) {
        // busco una carta cualquiera para dar como bonus
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (zonaJuego[i][j] != null) {
                    System.out.println("BONUS: " + jugador.getNombre() + 
                                     " recibe carta extra: " + zonaJuego[i][j]);
                    zonaJuego[i][j] = null;
                    return;
                }
            }
        }
    }
    
    private boolean hayCartasSuficientes() {
        // checo si tengo cartas para otra ronda
        int cartasNecesarias = 2; // para las cartas de inicio
        
        // cuento espacios vacios en la zona de juego
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (zonaJuego[i][j] == null) {
                    cartasNecesarias++;
                }
            }
        }
        
        return mazo.tamaño() >= cartasNecesarias;
    }
    
    private void rellenarZonaJuego() {
        // relleno los espacios vacios con cartas nuevas
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (zonaJuego[i][j] == null && !mazo.estaVacia()) {
                    zonaJuego[i][j] = mazo.eliminar(0);
                }
            }
        }
    }
    
    public void jugar() {
        System.out.println("Bienvenido a Pick-a-Perro!");
        System.out.println("Vas a jugar contra la IA para ver quien forma la secuencia mas larga.");
        System.out.println("Recuerda: las cartas deben ser identicas o tener exactamente UNA diferencia.\n");
        
        while (hayCartasSuficientes()) {
            System.out.println("\nEMPEZANDO RONDA " + rondaActual);
            
            inicializarRonda();
            
            boolean rondaActiva = true;
            boolean usuarioTermino = false;
            
            // van por turnos
            while (rondaActiva) {
                // turno del usuario
                if (!turnoUsuario()) {
                    usuarioTermino = true;
                    rondaActiva = false;
                } else {
                    // turno de la IA
                    if (!turnoIA()) {
                        rondaActiva = false;
                    }
                }
            }
            
            procesarFinRonda(usuarioTermino);
            
            if (hayCartasSuficientes()) {
                rellenarZonaJuego();
                rondaActual++;
                
                System.out.println("\nPresiona Enter para continuar...");
                scanner.nextLine();
            } else {
                break;
            }
        }
        
        mostrarResultadoFinal();
        scanner.close();
    }
    
    private void mostrarResultadoFinal() {
        System.out.println("\n" + "=".repeat(20) + " JUEGO TERMINADO " + "=".repeat(20));
        System.out.println("PUNTUACION FINAL:");
        System.out.println(usuario.getNombre() + ": " + usuario.getPuntos() + " puntos");
        System.out.println(ia.getNombre() + ": " + ia.getPuntos() + " puntos");
        
        if (usuario.getPuntos() > ia.getPuntos()) {
            System.out.println("\nFELICIDADES! Ganaste el juego!");
        } else if (ia.getPuntos() > usuario.getPuntos()) {
            System.out.println("\nLa IA gano esta vez. Mejor suerte la proxima!");
        } else {
            System.out.println("\nEmpate! Ambos jugaron muy bien.");
        }
    }
}
