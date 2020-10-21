public class Alphabet {

    public static String SURNAME_ALPHABET= "^[СИНЕЛЬНИКсинельник]*$";

    public static void main(String args[]) {
        System.out.println(isAlphabet("ин"));
        System.out.println(isAlphabet("ник"));
        System.out.println(isAlphabet("Сенк"));
        System.out.println(isAlphabet("але"));

    }

    public static boolean isAlphabet(String word) {

        return word.matches(SURNAME_ALPHABET);
    }


}
