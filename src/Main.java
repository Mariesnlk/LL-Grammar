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
        LinkedList<String> word = new LinkedList<>();
        LinkedList<String> email = new LinkedList<>();
        LinkedList<String> number = new LinkedList<>();
        LinkedList<String> telephone = new LinkedList<>();
        LinkedList<String> delimiter = new LinkedList<>();
        LinkedList<String> data = new LinkedList<>();
        LinkedList<String> notSymbol = new LinkedList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src//file1.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Name of your file is not correct");
        }
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        //String ls = System.getProperty("line.separator");
        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(line);
            //stringBuilder.append(ls);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String content = stringBuilder.toString();

//        Pattern p = Pattern.compile("[!._,'?//s]");
//        Matcher m = p.matcher(content);

        String[] words = content.split(" ");
        for (String w : words) {
            System.out.println(w);
            if (w.contains("!"))
                delimiter.add("!");
            else if (w.contains("?"))
                delimiter.add("?");
            else if (w.contains("_"))
                delimiter.add("_");
            else if (w.contains(" "))
                delimiter.add(" ");
            else if (w.matches(EMAIL))
                email.add(w);
            else if (w.matches(TELEPHONE_NUMBER))
                telephone.add(w);
            else if (w.matches(DATA))
                data.add(w);
            else if (w.matches(NUMBER) || w.matches(HEXADECIMAL))
                number.add(w);
            else if (w.matches(SURNAME_ALPHABET))
                word.add(w);
            else if(w.matches(NOT_ALPHABET) || w.matches(NOT_SYMBOLS))
                notSymbol.add(w);
        }

        System.out.println("Роздільники " + delimiter);
        System.out.println("Слова " + word);
        System.out.println("Числа " + number);
        System.out.println("Телефон " + telephone);
        System.out.println("Дата " + data);
        System.out.println("E-mail " + email);
        System.out.println("Не символи і не слова " + notSymbol);


        //print text
//        Iterator i = list.iterator();
//        while (i.hasNext()) {
//            System.out.println(i.next());
//        }
    }

    public static boolean isAlphabet(String word) {

        return word.matches(SURNAME_ALPHABET);
    }

    public static boolean email(String email) {

        return email.matches(EMAIL);
    }

    public static boolean isHexadecimal(String hexadecimal) {

        return hexadecimal.matches(HEXADECIMAL);
    }

    public static boolean isPhoneNum(String tel) {

        return tel.matches(TELEPHONE_NUMBER);
    }

    public static boolean isData(String data) {

        return data.matches(DATA);
    }
}


