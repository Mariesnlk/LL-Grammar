public class Symbols {

    final static String DIGIT_NUMBER = "^[-]*[0-9]+$";
    final static String DOUBLE_NUMBER = "^[-]*[0-9]+\\.[0-9]+$";
    final static String HEXADECIMAL = "^[-]*[0-9A-F]+$";

    public static void main(String args[]) {
        System.out.println(isDigit("1234567890"));
        System.out.println(isDigit("34567cvbn5u"));
        System.out.println(isDoubleNumber("223.789"));
        System.out.println(isDigit("-112789"));
        System.out.println(isDoubleNumber("-11.5"));
        System.out.println(isHexadecimal("98AF"));
    }

    /**
     *
     * @param digit
     * @return true for digit negative or positive number, otherwise return false
     */
    public static boolean isDigit(String digit) {

        return digit.matches(DIGIT_NUMBER);
    }

    /**
     *
     * @param doubleNumber
     * @return true for double negative or positive number, otherwise return false
     */
    public static boolean isDoubleNumber(String doubleNumber) {

        return doubleNumber.matches(DOUBLE_NUMBER);
    }

    public static boolean isHexadecimal(String hexadecimal) {

        return hexadecimal.matches(HEXADECIMAL);
    }

}
