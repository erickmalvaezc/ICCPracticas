public class Main {
    public static void main(String[] args) {
        //Triangulo Forma 1
        FiguraGeometrica triangulo =  new Triangulo(3, 4, 5, 3, 4);
        System.out.println("Area: " + triangulo.obtenerArea() + "\nPerimetro" + triangulo.obtenerPerimetro());
        triangulo.toString();

        //Triangulo Forma 2
        Triangulo triangulo2 =  new Triangulo(3, 4, 5, 3, 4);
        System.out.println("Area: " + triangulo2.obtenerArea() + "\nPerimetro" + triangulo2.obtenerPerimetro());
        triangulo2.toString();

        //Cuadrado  
        Cuadrado cuadrado =  new Cuadrado(4);
        System.out.println("Area: " + cuadrado.obtenerArea() + "\nPerimetro" + cuadrado.obtenerPerimetro());
        cuadrado.toString();
    
        //Rectangulo
        Rectangulo rectagulo =  new Rectangulo(5, 4);
        System.out.println("Area: " + rectagulo.obtenerArea() + "\nPerimetro" + rectagulo.obtenerPerimetro());
        rectagulo.toString();
    
    }
}
