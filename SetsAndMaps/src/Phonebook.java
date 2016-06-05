import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Bobo on 5/24/2016.
 */
public class Phonebook {
    public static void main(String[] args) {
        HashMap<String, String> phonenumbers = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        while (!line.equals("search")) {
            String[] data = line.split("-");
            phonenumbers.put(data[0], data[1]);

            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!line.equals("stop")){
            if (!phonenumbers.containsKey(line)){
                System.out.printf("Contact %s does not exist.%n", line);
            }else {
                System.out.printf("%s -> %s%n", line, phonenumbers.get(line));
            }

            line = scanner.nextLine();
        }
    }
}
