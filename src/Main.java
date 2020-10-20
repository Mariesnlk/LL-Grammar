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
        content.replaceAll("\\s{2,}", " "). trim();
        System.out.println(content);

        System.out.println("Separated words");
        String[] words = content.split("\\s");
        for (String w : words) {
            System.out.println(w);

        }
    }
}
