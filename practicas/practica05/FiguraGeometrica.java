public abstract class FiguraGeometrica{
    private double lado1, lado2, lado3, lado4, base, altura;
    
    public FiguraGeometrica(double lado1, double lado2, double lado3, double lado4, double base, double altura){
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.lado4 = lado4;
        this.base = base;
        this.altura = altura;
    }

    public double obtenerArea(){
        return base*altura;
    }

    public double obtenerPerimetro(){
        return lado1 + lado2 + lado3 + lado4;
    }

    public String toString(){
        for(int i=0; i<base; i++){
            System.out.print("  *");
        }
        for(int j=0; j<altura-2; j++){
            System.out.print("\n  *");
            for(int k=0; k<base-2; k++){
                System.out.print("   ");
            }
            if( j == altura%2)
                System.out.print("  *    Altura: "+ altura);
            else    
                System.out.print("  *");
        }
        System.out.print("\n");
        for(int i=0; i<base; i++){
            System.out.print("  *");
        }
        System.out.println("\n  Base: "+ base);
        System.out.print("\n");
        return "";
    }

    public double getAltura(){
        return this.altura;
    }
}