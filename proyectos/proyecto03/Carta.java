public final class Carta{
    //creamos atributos especificos para asignar a nuestras instancias 
    public enum Tamano{Pequeno, Grande}; 
    public enum Brazo{Uno, Dos}; 
    public enum Color{Naranja, Azul}; 

    private final Tamano tamano; 
    private final Brazo brazo;
    private final Color color; 
    private final boolean lentes; //boolean porque puede o no puede tener lentes 
    private final boolean palomitas; // igual bool porque si/no tiene palomitas 

    //constructor que inicializa nuestras instancias
    public Carta(Tamano tamano, Brazo brazo, Color color, boolean lentes, boolean palomitas){
        this.tamano = tamano;
        this.brazo = brazo; 
        this.color = color; 
        this.lentes = lentes; 
        this.palomitas = palomitas; 
    }

    //getters
    public Tamano getTamano(){
        return tamano; 
    }

    public Brazo getBrazo(){
        return brazo; 
    }

    public Color getColor(){
        return color; 
    }

    public boolean getLentes(){
        return lentes; 
    }

    public boolean getPalomitas(){
        return palomitas; 
    }

    //metodo que evalua las diferencias de las cartas
    public int diferencias(Carta otra){
        int error = 0; //contador que nos contará el numero de diferencias de nuestra ronda 

        //si el tamaño de nuestra carta anterior 
        if(tamano != otra.tamano){
            error ++; 
        }
        if(brazo != otra.brazo){
            error ++; 
        }
        if(lentes != otra.lentes){
            error++; 
        }
        if(color != otra.color){
            error++; 
        }
        if(palomitas != otra.palomitas){
            error ++; 
        }
        return error; 
    }
}