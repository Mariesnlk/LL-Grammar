import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

        String text = readFileAsString("src//file1.txt");//отримуємо текст з файлу
        System.out.println("---- INPUT FROM FILE ----");
        System.out.println(text);//виводимо прочитаний текст у консоль

        //переміщаємо текст у масив стрінгів ділячи його на окремі слова через пробіл
        //сам пробіл як лексема не буде враховуватись
        String[] strArray = text.split("\\s");

        //створюємо зв'язний список, який є динамічний, тому потім легко можна вставляти у будь-яке місце списку
        LinkedList<String> list = new LinkedList<String>();
        //проходимось по кожному елементу списка і додаємо його в список
        for (String w : strArray) {
            list.add(w);
        }

        //проходимось по кожному елементу зв'язного списка і на непарну позицію вставляємо пробіл,
        // який був видалений під час розбиття стрінга на лексеми
        for (int i = 1; i < list.size(); i += 2) {
            list.add(i, " ");
        }

        System.out.println("---- OUTPUT ----");
        //проходимось по кожному елементу зв'язного списка і порівнюємо
        //на відповідність приналежності до певного класу лексем
        //виводимо відповідне повідомлення
        for (String w : list) {
            if (w.matches("[-\\.!?_,]+")) {
                System.out.println(w + " - роздільник");
            } else if (w.matches("\\s")) {
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

    /**
     * метод, який зчитує дані з файлу за допомогою буферрідеру та повертає текст
     *
     * @param filePath бере як параметр шлях до фойлу
     * @return повертає прочитаний текст з файлу як стрічку
     */
    private static String readFileAsString(String filePath) {
        StringBuilder fileData = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        char[] buf = new char[1024];
        int numRead = 0;
        while (true) {
            try {
                assert reader != null;
                if ((numRead = reader.read(buf)) == -1) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileData.toString();
    }
}
