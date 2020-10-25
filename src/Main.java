import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static String SURNAME_ALPHABET = "^[СсИиНнЕеЛлЬьНнИиКк]*$";
    final static String EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
    final static String NUMBER = "(\\-*)[0-9]+\\.?[0-9]+$";
    final static String HEXADECIMAL = "^[-]*[0-9A-F]+$";
    final static String TELEPHONE_NUMBER = "^\\+[380]*\\(\\d{2}\\)-\\d{3}-\\d{2}-\\d{2}$";
    final static String DATA = "^\\d{4}-\\d{2}-\\d{2}$";
    final static String NOT_SYMBOLS = "[\\^#$%&*()+=|<>{}\\[\\]~\\/]*";
    final static String NOT_ALPHABET = "^[^СсИиНнЕеЛлЬьНнИиКк]*$";


    public static void main(String args[]) {
        ArrayList<String> word = new ArrayList<>();
        ArrayList<String> email = new ArrayList<>();
        ArrayList<String> number = new ArrayList<>();
        ArrayList<String> telephone = new ArrayList<>();
        ArrayList<String> delimiter = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();
        ArrayList<String> notSymbol = new ArrayList<>();

        System.out.println(isPhoneNum("+380(66)-440-48-06"));

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("C:\\LL\\file.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Name of your file is not correct");
        }
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(line);
            stringBuilder.append(ls);
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
            else if (w.contains("-"))
                delimiter.add(",");
            else if (w.matches("[//s]"))
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


