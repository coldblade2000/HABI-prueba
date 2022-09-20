import java.util.*;

public class Pregunta1 {
    //Arreglo de caracteres que será utilizado en el algoritmo. Está ordenado según el orden del enunciado
    static final char[] ORDEN = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s',
            't','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J',
            'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1',
            '3','5','7','9','0','2','4','6','8'};

    /**
     * Retorna la cadena input reordenada según el orden especificado en el enunciado
     * -
     *  Complejidad: O(N), debido a que el primer for loop y el forEach al final son de tiempo constantes,
     * y el lookup de LinkedHashMap es de O(1)
     * @param input una cadena alfanumerica, cuya longitud es entre 0 y 1000 no inclusivo
     * @return la cadena input reordenada
     */
    public static String ordenarCadena(String input){

        // Se utiliza un LinkedHashMap, un hashmap que garantiza que al iterar las llaves, se iterarán en el orden
        //   de inserción original. El hashmap representa cuantas veces ocurre cada caracter en la cadena
        LinkedHashMap<Character, Integer> counts = new LinkedHashMap<>(ORDEN.length);

        // Se insertan todos los caracteres de ORDEN en el hashmap, con un valor de 0
        for (char value : ORDEN) {
            counts.put(value, 0);
        }

        // Iterar una sola vez por cada caracter del input, y por cada vez, incrementando el contador del caracter correspondiente
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            Integer existingValue = counts.get(c);
            counts.put(c, existingValue == null ? 1 : existingValue + 1);
        }

        //Iterar por cada pareja (c: Character, i: Integer) del HashMap (en el orden correcto), y appendear a la
        // cadena final el caracter c una cantidad i de veces repetidas.
        StringBuilder sb = new StringBuilder();
        counts.forEach((c, i)-> {
            sb.append(String.valueOf(c).repeat(Math.max(0, i)));
        });

        //Retornar String
        return sb.toString();
    }

    /**
     * <strong>METODO NAIVE DE PRUEBA, Este NO es el que se debería considerar para la cosa de Habi</strong>
     * Este metodo tiene una complejidad de O(n log n), debido a que requiere el uso de un sort.
     * Este metodo solo se incluye aca para comparar con el otro metodo
     * Retorna la cadena input reordenada según el orden especificado en el enunciado
     * @param input una cadena alfanumerica, cuya longitud es entre 0 y 1000 no inclusivo
     * @return la cadena input reordenada
     */
    public static String ordenarCadenaNaive(String input){
        HashMap<Character, Integer> indices = new HashMap<>();
        for (int i = 0; i < ORDEN.length; i++) {
            indices.put(ORDEN[i], i);
        }
        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characterArrayList.add(c);
        }
        characterArrayList.sort(Comparator.comparing(indices::get));
        StringBuilder sb = new StringBuilder();
        for(Character c: characterArrayList){
            sb.append(c);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        test();
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Pregunta 1) Por favor ingrese la cadena que se quiere probar:");
        //String input = "Sorting1234";
        String input = sc.nextLine().trim();

        String output = Pregunta1.ordenarCadena(input);
        System.out.printf("Se ingresó la cadena: %s \nLa cadena ordenada es: %s\n", input, output);*/


    }

    public static void test(){
        //https://www.baeldung.com/java-random-string
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 1000;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String input = generatedString;

        if (ordenarCadena(input).equals(ordenarCadenaNaive(input))){
            System.out.println("Mismo output");
        }else{
            System.out.println("OUTPUT DIFERENTE ERROR");
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            ordenarCadena(input);
        }
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion: " + (end-start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            ordenarCadenaNaive(input);
        }
        end = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion: " + (end-start));

    }
}