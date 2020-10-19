
public class Telephone {
    public static void main(String args[]) {
        System.out.println(phone("+380 (66)-440-48-06"));

    }

    /**
     *
     * @param tel type String
     * @return true if tel matches regex expression, which is ukrainian telephone
     * number, otherwise false
     */
    public static boolean phone(String tel) {

        return tel.matches("\\+[380]*\\s+\\(\\d{2}\\)-\\d{3}-\\d{2}-\\d{2}");
    }
}
