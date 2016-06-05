import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Bobo on 5/26/2016.
 */
public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        String line = sc.nextLine();

        while (!line.equals("stop")){
            String email = sc.nextLine();

            if (!(email.toLowerCase().endsWith("us" ) || email.toLowerCase().endsWith("uk"))){
                emails.put(line, email);
            }

            line = sc.nextLine();
        }

        for (Map.Entry<String, String> email : emails.entrySet()) {
            System.out.printf("%s -> %s%n", email.getKey(), email.getValue());
        }
    }
}
