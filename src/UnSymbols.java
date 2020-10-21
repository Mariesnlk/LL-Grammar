
public class UnSymbols {

    final static String NOT_SYMBOLS = "[\\^!@#$%&*()_+=|<>?{}\\[\\]~\\-\\.\\/]*";
    final static String NOT_ALPHABET = "^[^СИНЕЛЬНИКсинельник]*$";

    public static void main(String args[]) {
        System.out.println(notSymbols("./"));
        System.out.println(notSymbols("()"));
        System.out.println(notSymbols("This string not contain special characters"));
        System.out.println(notSymbols("234"));

        System.out.println(notAlphabet("а"));
    }


    public static boolean notSymbols(String notSymbols) {

        return notSymbols.matches(NOT_SYMBOLS);
    }

    public static boolean notAlphabet(String word) {
        return word.matches(NOT_ALPHABET);
    }
}