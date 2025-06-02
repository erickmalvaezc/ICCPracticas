public class Carta {
    private int tamaño; // 0 = pequeño, 1 = grande
    private int color; // 0 = cafe, 1 = negro, 2 = blanco
    private int brazos; // 0 = uno, 1 = dos
    private int gafas; // 0 = sin gafas, 1 = con gafas
    private int palomitas; // 0 = sin palomitas, 1 = con palomitas
    
    public Carta(int tamaño, int color, int brazos, int gafas, int palomitas) {
        this.tamaño = tamaño;
        this.color = color;
        this.brazos = brazos;
        this.gafas = gafas;
        this.palomitas = palomitas;
    }
    
    // Checa si dos cartas son iguales o solo tienen una diferencia
    public boolean esCompatible(Carta otra) {
        if (this.equals(otra)) return true; // son identicas
        
        int diferencias = 0;
        if (this.tamaño != otra.tamaño) diferencias++;
        if (this.color != otra.color) diferencias++;
        if (this.brazos != otra.brazos) diferencias++;
        if (this.gafas != otra.gafas) diferencias++;
        if (this.palomitas != otra.palomitas) diferencias++;
        
        return diferencias == 1; // solo una diferencia permitida
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Carta carta = (Carta) obj;
        return tamaño == carta.tamaño && color == carta.color && 
               brazos == carta.brazos && gafas == carta.gafas && 
               palomitas == carta.palomitas;
    }
    
    @Override
    public String toString() {
    String tam = (tamaño == 0) ? "Pequeño" : "Grande";
    String[] col = {"Café", "Negro", "Blanco"};
    String br  = (brazos == 0) ? "1B" : "2B";
    String ga  = (gafas == 0) ? "sin gafas" : "con gafas";
    String pal = (palomitas == 0) ? "sin palomitas" : "con palomitas";
    return String.format("%s  %s  %s  %s  %s", tam, col[color], br, ga, pal);
    }

    
    // getters por si los necesito despues
    public int getTamaño() { return tamaño; }
    public int getColor() { return color; }
    public int getBrazos() { return brazos; }
    public int getGafas() { return gafas; }
    public int getPalomitas() { return palomitas; }
}
