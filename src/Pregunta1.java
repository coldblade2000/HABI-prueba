import java.util.*;

public class Pregunta1 {
    static final char[] ORDEN = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s',
            't','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J',
            'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1',
            '3','5','7','9','0','2','4','6','8'};
    /**
     * Retorna la cadena input reordenada según el orden especificado en el enunciado
     * @param input una cadena alfanumerica, cuya longitud es entre 0 y 1000 no inclusivo
     * @return la cadena input reordenada
     */
    public static String ordenarCadena(String input){

        // Complejidad: O(N), debido a que el primer for loop y el forEach al final son de tiempo constantes,
        //  y el lookup de LinkedHashMap es de O(1)
        LinkedHashMap<Character, Integer> counts = new LinkedHashMap<>(ORDEN.length);
        StringBuilder sb = new StringBuilder();
        for (char value : ORDEN) {
            counts.put(value, 0);
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            Integer existingValue = counts.get(c);
            counts.put(c, existingValue == null ? 1 : existingValue + 1);
        }
        counts.forEach((c, i)-> {
            sb.append(String.valueOf(c).repeat(Math.max(0, i)));
        });
        return sb.toString();
    }

    public static String ordenarCadenaMala(String input){
        ArrayList<Character> inputList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            inputList.add(c);
        }
        return "";
    }
    public static void main(String[] args) {
        //test();
        Scanner sc = new Scanner(System.in);
        System.out.println("Pregunta 1) Por favor ingrese la cadena que se quiere probar:");
        //String input = "Sorting1234";
        String input = sc.nextLine().trim();

        String output = Pregunta1.ordenarCadena(input);
        System.out.printf("Se ingresó la cadena: %s \nLa cadena ordenada es: %s\n", input, output);


    }

    public static void test(){
        String input = "Sorting1234";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            ordenarCadena(input);
        }
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion: " + (end-start));

    }
}