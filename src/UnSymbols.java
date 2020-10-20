
public class UnSymbols {

    final static String NOTSYMBOLS = "[\\^!@#$%&*()_+=|<>?{}\\[\\]~\\-\\.\\/]*";

    public static void main(String args[]) {
        System.out.println(notSymbols("./"));
        System.out.println(notSymbols("()"));
        System.out.println(notSymbols("This string not contain special characters"));
        System.out.println(notSymbols("234"));

        String str = "Hello+-^Java+-Programmer^ ^^-- ^^^ +!";
        str = str.replaceAll(NOTSYMBOLS, " ");
        System.out.println(str);

    }


    public static boolean notSymbols(String notSymbols) {

        return notSymbols.matches(NOTSYMBOLS);
    }
}