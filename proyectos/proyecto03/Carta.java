// Carta.java
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
        return tamaño == carta.tamaño && color == carta.color && brazos == carta.brazos && gafas == carta.gafas && palomitas == carta.palomitas;
    }
    
    @Override
    public String toString() {
        String[] tamaños = {"P", "G"}; // pequeño, grande
        String[] colores = {"\u001B[33mC", "\u001B[37mN", "\u001B[36mB"}; // cafe, negro, blanco
        String brazoStr = (brazos == 0) ? "1" : "2";
        String gafaStr = (gafas == 0) ? "-" : "G";
        String palomitaStr = (palomitas == 0) ? "-" : "P";
        
        return colores[color] + tamaños[tamaño] + brazoStr + gafaStr + palomitaStr + "\u001B[0m";
    }
    
    // getters por si los necesito despues
    public int getTamaño() { 
        return tamaño;
    }
    public int getColor() { 
        return color; 
    }
    public int getBrazos() { 
        return brazos; 
    }
    public int getGafas() { 
        return gafas; 
    }
    public int getPalomitas() { 
        return palomitas; 
    }
}
