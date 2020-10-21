
public class Telephone {

    final static String TELEPHONE_NUMBER = "\\+[380]*\\(\\d{2}\\)-\\d{3}-\\d{2}-\\d{2}";

    public static void main(String args[]) {
        System.out.println(isPhoneNum("+380(66)-440-48-06"));

    }

    /**
     *
     * @param tel type String
     * @return true if tel matches regex expression, which is ukrainian telephone
     * number, otherwise false
     */
    public static boolean isPhoneNum(String tel) {

        return tel.matches(TELEPHONE_NUMBER);
    }
}
