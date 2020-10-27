import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class LL {

    public static String SURNAME_ALPHABET = "^[СсИиНнЕеЛлЬьНнИиКк]+$";
    final static String EMAIL = "^[A-Za-zА-Яа-я0-9+_.-]+@(.+)$";
    final static String NUMBER = "(\\-?)[0-9]+\\.?[0-9]+$";
    final static String HEXADECIMAL = "^[0-9A-F]+$";
    final static String TELEPHONE_NUMBER = "^\\+[380]*\\(\\d{2}\\)-\\d{3}-\\d{2}-\\d{2}$";
    final static String DATA = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
    final static String NOT_SYMBOLS = "[\\^#$%&*()+=|<>{}\\[\\]~\\/]+";
    final static String NOT_ALPHABET = "^[а-яА-Яa-zA-Z]+\\.?$";

    public static void main(String args[]) throws IOException {

        String text = readFileAsString("src//file1.txt");
        System.out.println("---- INPUT FROM FILE ----");
        System.out.println(text);

        String[] strArray = text.split("\\s");

        LinkedList<String> list = new LinkedList<String>();
        for (String w : strArray) {
            list.add(w);
        }

        for (int i = 1; i < list.size(); i += 2) {
            list.add(i, " ");
        }

        System.out.println("---- OUTPUT ----");

        for (int i = 0; i < list.size(); i++) {
            String w = list.get(i);
            if (w.matches("!") || w.contains("?")) {
                System.out.println(w + " - роздільник");
            } else if (w.matches("_")) {
                System.out.println(w + " - роздільник");
            } else if (w.matches(" ")) {
                System.out.println(w + " - роздільник \" \" ");
            } else if (w.matches(EMAIL)) {
                System.out.println(w + " - e-mail");
            } else if (w.matches(TELEPHONE_NUMBER)) {
                System.out.println(w + " - номер телефону");
            } else if (w.matches(DATA)) {
                System.out.println(w + " - дата");
            } else if (w.matches(NUMBER) || w.matches(HEXADECIMAL)) {
                System.out.println(w + " - число");
            } else if (w.matches(SURNAME_ALPHABET)) {
                System.out.println(w + " - слово");
            } else if (w.matches(NOT_ALPHABET) || w.matches(NOT_SYMBOLS)) {
                System.out.println(w + " - не символ і не число");
            }
        }
    }

    private static String readFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
}
