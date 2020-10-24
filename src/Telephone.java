
public class Telephone {

    final static String TELEPHONE_NUMBER = "\\+[380]*\\(\\d{2}\\)-\\d{3}-\\d{2}-\\d{2}";
    final static String DATA = "^\\d{4}-\\d{2}-\\d{2}$";

    public static void main(String args[]) {
        System.out.println(isPhoneNum("+380(66)-440-48-06"));
        System.out.println(isData("2020-10-24"));
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

    /**
     *YYYY-MM-DD
     * @param data
     * @return
     */
    public static boolean isData(String data) {

        return data.matches(DATA);
    }
}
