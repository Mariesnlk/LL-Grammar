
public class Email {

    public static void main(String args[]) {
        System.out.println(email("mariesnlk90@gmail.com"));
        System.out.println(email("mariia.synelnyk@ukma.edu.ua"));
    }

    public static boolean email(String email) {

        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}