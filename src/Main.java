import java.io.*;
import java.util.*;

public class Main {

    public static String SURNAME_ALPHABET = "^[СсИиНнЕеЛлЬьНнИиКк]+$";
    final static String EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
    final static String NUMBER = "(\\-?)[0-9]+\\.?[0-9]+$";
    final static String HEXADECIMAL = "^[0-9A-F]+$";
    final static String TELEPHONE_NUMBER = "^\\+[380]*\\(\\d{2}\\)-\\d{3}-\\d{2}-\\d{2}$";
    final static String DATA = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
    final static String NOT_SYMBOLS = "[\\^#$%&*()+=|<>{}\\[\\]~\\/]+";
    final static String NOT_ALPHABET = "^[а-яА-Яa-zA-Z]+\\.?$";


    public static void main(String args[]) {

        LinkedList<String> notSymbol = new LinkedList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src//file1.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Name of your file is not correct");
        }
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(line);
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = stringBuilder.toString().split("\\s");

        System.out.println("----OUTPUT TEXT----");
        for (String w : words) {
            if (w.matches("!")  ||w.contains("?")) {
                System.out.println(w + " - роздільник");
            } else if (w.matches("_")) {
                System.out.println(w + " - роздільник");
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
                notSymbol.add(w);
                System.out.println(w + " - не символ і не число");
            }
        }
    }
}


