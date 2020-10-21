import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
        /*match one or more spaces and replace them with a single space
        and then trim whitespaces at the beginning and end
        */
        System.out.println(content);
        System.out.println("------------------------------------------------------");
        System.out.println("Separated words");
        String[] words = content.split("\\s");
        for (String w : words) {
            System.out.println(w);
        }

        int count_email = 0;
        int count_alphabet = 0;
        int count_telephone = 0;
        int count_not_symbol = 0;
        int count_not_alphabet = 0;
        int count_digit = 0;
        int count_double = 0;

        for (String word : words) {
            if (Email.email(word))
                count_email++;
            else if (Alphabet.isAlphabet(word))
                count_alphabet++;
            else if (Telephone.isPhoneNum(word))
                count_telephone++;
            else if (UnSymbols.notSymbols(word))
                count_not_symbol++;
            else if (UnSymbols.notAlphabet(word))
                count_not_alphabet++;
            else if (Symbols.isDigit(word))
                count_digit++;
            else if (Symbols.isDoubleNumber(word))
                count_double++;
        }

        System.out.println("Email " + count_email);
        System.out.println("Alphabet " + count_alphabet);
        System.out.println("Phone " + count_telephone);
        System.out.println("Not symbols " + count_not_symbol);
        System.out.println("Not alphabet " + count_not_alphabet);
        System.out.println("Digit number " + count_digit);
        System.out.println("Double number " +count_double);
    }
}


