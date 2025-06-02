public class Cuadrado extends FiguraGeometrica{

    public Cuadrado(double lado){
        super(lado, lado, lado, lado, lado, lado);
    }    

     public double obtenerArea(){
        return super.obtenerArea(); 
    }

    public double obtenerPerimetro(){
        return super.obtenerPerimetro();
    }

    
    public String toString(){
        super.toString();
        return "";
    }
}
