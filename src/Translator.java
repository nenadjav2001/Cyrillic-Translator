import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {

    private final Map<Character, Character> mapForChars;
    private final Map<Character , String> mapForLettersWithLengthTwo;
    private final static String CYRILLIC_KEYS = "АБВГДЂЕЖЗИЈКЛМНОПРСТЋУФХЦЧШ";
    private final static String LATIN_VALUES = "ABVGDĐEŽZIJKLMNOPRSTĆUFHCČŠ";



    private String cyrillicSentence;
    private String translatedLatinSentence;

    //Scanner to handle User input
    private Scanner input;


    public Translator() {
        mapForChars = new HashMap<>();
        mapForLettersWithLengthTwo = new HashMap<>();
        cyrillicSentence = "";
        translatedLatinSentence = "";
        input = new Scanner(System.in);
    }

    //Starts the translator
    public void initTranslator(){

        fillMap();
        fillSecondMap();
        translateSentence();

    }

    //Fills the map with the key-value pairs
    private void fillMap() {
        int counter = 0;
        while (counter < CYRILLIC_KEYS.length()) {
            mapForChars.put(CYRILLIC_KEYS.charAt(counter), LATIN_VALUES.charAt(counter));
            counter++;
        }
    }


   //Fills the second map with the key-value pairs that have 2 letter values
    private void fillSecondMap(){
        mapForLettersWithLengthTwo.put('Љ' , "Lj");
        mapForLettersWithLengthTwo.put('Њ' , "Nj");
        mapForLettersWithLengthTwo.put('Џ' , "Dž");
    }

    //Translate the sentence from cyrillic to latin
    private void translateSentence(){

        char latinChar = 0;

        System.out.println("Pass a sentence in cyrillic that i can translate Sir... ");
        cyrillicSentence = input.nextLine();

        for (int i = 0; i < cyrillicSentence.length(); i++){

            if (mapForChars.containsKey(cyrillicSentence.charAt(i)) ||
                mapForLettersWithLengthTwo.containsKey(cyrillicSentence.charAt(i)) ){
                latinChar = mapForChars.get(cyrillicSentence.charAt(i));
                translatedLatinSentence += latinChar;
                System.out.println(translatedLatinSentence);
            }
        }
    }

    public static void main(String[] args) {
         Translator translator = new Translator();
         translator.initTranslator();
    }


}

