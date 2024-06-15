import java.util.HashMap;
import java.util.Map;

public class Translator {

    private final Map<Character, Character> map;
    private final static String CYRILLIC_KEYS = "АБВГДЂЕЖЗИЈКЛЉМНЊОПРСТЋУФХЦЧЏШ";
    private final static String LATIN_VALUES = "ABVGDĐEŽZIJKLLjMNNjOPRSTĆUFHCČDzŠ";


    public Translator() {
        map = new HashMap<>();
        fillMap();
        System.out.println(map);
    }

    //Fills the map with the key-value pairs
    private void fillMap() {
        int counter = 0;
        while (counter < CYRILLIC_KEYS.length()) {
            map.put(CYRILLIC_KEYS.charAt(counter), LATIN_VALUES.charAt(counter));
            counter++;
        }
    }

    //Method for getting the current char
    private char getLatinLetter(Character cyrillicChar){
        return map.get(cyrillicChar);
    }

    public static void main(String[] args) {
         Translator translator = new Translator();
    }



}

