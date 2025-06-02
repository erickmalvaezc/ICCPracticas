public class Rectangulo extends FiguraGeometrica{
    public Rectangulo(double base, double altura){
        super(base, altura, base, altura, base, altura);
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
