public class Symbols {

    public static void main(String args[]) {
        System.out.println(isDigit("1234567890"));
        System.out.println(isDigit("34567cvbn5u"));
        System.out.println(isDoubleNumber("223.789"));
        System.out.println(isDigit("-112789"));
        System.out.println(isDoubleNumber("-11.5"));
    }

    /**
     *
     * @param digit
     * @return true for digit negative or positive number, otherwise return false
     */
    public static boolean isDigit(String digit) {

        return digit.matches("^[-]*[0-9]+$");
    }

    /**
     *
     * @param doubleNumber
     * @return true for double negative or positive number, otherwise return false
     */
    public static boolean isDoubleNumber(String doubleNumber) {

        return doubleNumber.matches("^[-]*[0-9]+\\.[0-9]+$");
    }

}
