import java.util.Scanner;

public class Implementacion{

    public static String descifraNulo(String original, int n) {
        if (original == null || n < 0) {
            return "";
        }
    
        String resultado = "";
        int i = 0;
        int len = original.length();
        while (i < len) {
            while (i < len && original.charAt(i) == ' ') {
                i++;
            }
            int inicio = i;
            while (i < len && original.charAt(i) != ' ') {
                i++;
            }
    
            int fin = i;
    
            if (fin - inicio > n) {
                resultado += original.charAt(inicio + n);
            }
        }
        return resultado;
    }
    
    public static String descifraNulo(String original) {
        if (original == null) {
            return "";
        }
    
        int len = original.length();
        int espaciosFinales = 0;
    
        for (int i = len - 1; i >= 0 && original.charAt(i) == ' '; i--) {
            espaciosFinales++;
        }
    
        String sinEspaciosFinales = "";
        for (int i = 0; i < len - espaciosFinales; i++) {
            sinEspaciosFinales += original.charAt(i);
        }
    
        return descifraNulo(sinEspaciosFinales, espaciosFinales);
    }
    

    public static boolean contieneNombre(String mensaje, String nombre) {
        if (mensaje == null || nombre == null) {
            return false;
        }
    
        String textoLimpio = "";
        for (int i = 0; i < mensaje.length(); i++) {
            char c = mensaje.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                textoLimpio += Character.toLowerCase(c);
            }
        }
    
        String nombreLimpio = "";
        for (int i = 0; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                nombreLimpio += Character.toLowerCase(c);
            }
        }
    
        return textoLimpio.contains(nombreLimpio);
    }
    

    public static String descifraPalabrasMarcadas(String m, String e) {
        if (m == null || e == null) {
            return "";
        }
    
        String resultado = "";
        int i = 0, j = 0, lenM = m.length(), lenE = e.length();
    
        while (i < lenM && j < lenE) {
            while (i < lenM && m.charAt(i) == ' ') i++;
            while (j < lenE && e.charAt(j) == ' ') j++;
    
            int iniM = i;
            while (i < lenM && m.charAt(i) != ' ') i++;
            int finM = i;
    
            int iniE = j;
            while (j < lenE && e.charAt(j) != ' ') j++;
            int finE = j;
    
            String palabraM = "", palabraE = "";
            for (int k = iniM; k < finM; k++) palabraM += m.charAt(k);
            for (int k = iniE; k < finE; k++) palabraE += e.charAt(k);
    
            if (!palabraM.equals(palabraE)) {
                resultado += palabraM + " ";
            }
        }
    
        if (resultado.length() > 0 && resultado.charAt(resultado.length() - 1) == ' ') {
            resultado = resultado.substring(0, resultado.length() - 1);
        }
    
        return resultado;
    }
    

    public static String descifraLetrasMarcadas(String m, String e) {
        if (m == null || e == null) {
            return "";
        }
    
        String resultado = "";
    
        for (int i = 0; i < m.length() && i < e.length(); i++) {
            if (m.charAt(i) != e.charAt(i)) {
                resultado += e.charAt(i);
            }
        }
    
        return resultado;
    }
    


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una cadena original:");
        String original = sc.nextLine();

        System.out.println("Introduce un número n:");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("descifraNulo(original, n): " + descifraNulo(original, n));
        System.out.println("descifraNulo(original): " + descifraNulo(original));

        System.out.println("\nIntroduce un mensaje para buscar nombre:");
        String mensaje = sc.nextLine();
        System.out.println("Introduce el nombre a buscar:");
        String nombre = sc.nextLine();
        System.out.println("¿Contiene el nombre?: " + contieneNombre(mensaje, nombre));

        System.out.println("\nIntroduce mensaje M:");
        String m = sc.nextLine();
        System.out.println("Introduce mensaje E:");
        String e = sc.nextLine();
        System.out.println("descifraPalabrasMarcadas: " + descifraPalabrasMarcadas(m, e));
        System.out.println("descifraLetrasMarcadas: " + descifraLetrasMarcadas(m, e));

        sc.close();        
    }
        
}