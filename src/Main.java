import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {

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
                if (!((line = reader.readLine()) != null)) break;
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

        System.out.println(content);
        System.out.println("------------------------------------------------------");
        System.out.println("Separated words");
        System.out.println("------------------------------------------------------");
        String[] words = content.split(" ");
        for (String w : words) {
            System.out.println(w);
        }

        ArrayList<String> word = new ArrayList<String>();
        ArrayList<String> email = new ArrayList<String>();
        ArrayList<String> number = new ArrayList<String>();
        ArrayList<String> telephone = new ArrayList<String>();
        ArrayList<String> notSymbol = new ArrayList<String>();
        ArrayList<String> data = new ArrayList<String>();

        for (String w : words) {
            if (w.matches(Email.EMAIL))
                email.add(w);
            else if (w.matches(Telephone.TELEPHONE_NUMBER))
                telephone.add(w);
            else if (w.matches(Telephone.DATA))
                data.add(w);
            else if (w.matches(UnSymbols.NOT_ALPHABET) || w.matches(UnSymbols.NOT_SYMBOLS))
                notSymbol.add(w);
            else if (w.matches(Symbols.DIGIT_NUMBER) || w.matches(Symbols.DOUBLE_NUMBER)
                     || w.matches(Symbols.HEXADECIMAL))
                number.add(w);
            else if (w.matches(Alphabet.SURNAME_ALPHABET))
                word.add(w);
        }
//        for (char ch : UnSymbols.SEPARATORS.toCharArray()) {
//            if (content.contains(String.valueOf(ch))) {
//                notSymbol.add(String.valueOf(ch));
//                content.replace(String.valueOf(ch), " ");
//            }
//        }
        System.out.println(telephone);
        System.out.println(email);
        System.out.println(data);
        System.out.println(notSymbol);
        System.out.println(number);
        System.out.println(word);


    }
}


